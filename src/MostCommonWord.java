import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] s = paragraph.split(" ");
        Map<String,Integer> map = new HashMap<>(s.length);
        int count =0;
        for(int i = 0;i<s.length; i++){
            if(map.get(s[i]) == null){
                map.put(s[i],0);
            }else{
                map.put(s[i],map.get(s[i]+1));
            }
        }

        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue));

        return null;
        
    }
}