package com.company.cft.utils;
​
import com.google.gson.*;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
​
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
​
public class ParamNestedToNormalViceVersaModifier {
​
    public static void main(String args[]) throws IOException {
​
        String targetDirectory = "/Users/lmallampati/git/iot-cft/common/kms";
​
        List<File> allFiles = Files.walk(Paths.get(targetDirectory))
                .filter(Files::isRegularFile).map(path -> path.toFile()).collect(Collectors.toList());
​
        List<File> allRequiredFiles = allFiles.stream()
                .filter(f -> f.getAbsolutePath().contains("parameters"))
                .collect(Collectors.toList());
​
        for (File file : allRequiredFiles) {
            modifyParameters(file);
        }
    }
​
    private static void modifyParameters(File file) throws IOException {
        String jsonString = FileUtils.readFileToString(file, Charsets.UTF_8);
        JsonElement oldElement = new JsonParser().parse(jsonString);
        JsonElement newElemt = null;
        if (oldElement.isJsonObject()) {
            newElemt = convertObjectToArray(oldElement);
        } else {
            newElemt = convertArrayToObject(oldElement);
        }
​
        Gson gson = new Gson();
        String resultingJson = gson.toJson(newElemt);
        FileUtils.writeStringToFile(file, resultingJson, Charsets.UTF_8);
    }
​
    private static JsonElement convertArrayToObject(JsonElement oldElement) {
        JsonArray jsonArray = oldElement.getAsJsonArray();
        JsonObject jobject = new JsonObject();
        for(int index = 0; index < jsonArray.size(); index++){
            String key = jsonArray.get(index).getAsJsonObject().get("ParameterKey").getAsString();
            String value = jsonArray.get(index).getAsJsonObject().get("ParameterValue").getAsString();
            jobject.addProperty(key, value);
        }
        return  jobject;
    }
​
    private static JsonElement convertObjectToArray(JsonElement oldElement) {
​
        JsonObject jobject = oldElement.getAsJsonObject();
        JsonArray jArray = new JsonArray();
        Gson gson = new Gson();
        jobject.keySet().stream().map(key -> {
            NormalParameters params = new NormalParameters(key, jobject.get(key).getAsString());
            return gson.toJsonTree(params);
        }).forEach(jArray::add);
     return jArray;
​
    }
}
​
class NormalParameters {
    String ParameterKey;
    String ParameterValue;
​
    public NormalParameters(String parameterKey, String parameterValue) {
        ParameterKey = parameterKey;
        ParameterValue = parameterValue;
    }
}