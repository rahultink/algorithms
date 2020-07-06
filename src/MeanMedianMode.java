import java.util.*;
import java.util.stream.Collectors;


public class MeanMedianMode {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int [] a = new int[size];
        for(int i = 0;i < size;i++) {
            a[i] = s.nextInt();
        }
        int [] b = new int[size];
        for(int i = 0;i < size;i++) {
            b[i] = s.nextInt();
        }
        System.out.println(getMean(a, size));
        System.out.println(getMedian(a, size));
        System.out.println(getMode(a));
        System.out.printf("%.1f\n", getWeightedMean(a,b,size));
        printQuartiles(a, size);
    }

    private static void printQuartiles(int[] a, int size) {
        int [] q1Set = new int[size/2];
        int [] q2Set = new int[size/2];
        if(a.length % 2 != 0){
            for(int i = 0; i< (size/2)-1; i++){
                q1Set[i] = a[i];
            }
            for(int i = size/2; i< size; i++){
                q2Set[i] = a[i];
            }
        }else{
            for(int i = 0; i< (size/2)-1; i++){
                q1Set[i] = a[i];
            }
            for(int i = size/2+1; i< size; i++){
                q2Set[i] = a[i];
            }
        }
        System.out.println(getMedian(q1Set, size));
        System.out.println(getMedian(a, size));
        System.out.println(getMedian(q2Set, size));
    }

    private static double getMedian(int[] a, int size) {
        Arrays.sort(a);
        int half = size / 2;
        if (a.length % 2 != 0)
            return (double) a[half];
        else
            return (double) (a[half-1] + a[half]) / 2;
    }

    private static double getWeightedMean(int[] a, int[] b, int size) {
        int sumOfWeights = 0;
        int sum = 0;
        for(int i = 0;i < size;i++) {
            sum = sum+(a[i]*b[i]);
            sumOfWeights = sumOfWeights + b[i];
        }
        return (double) sum/sumOfWeights;
    }

    private static double getMean(int[] a, int size) {
        int sum = 0;
        for (int x : a) {
            sum = sum + x;
        }
        return (double) sum / size;
    }

    private static int getMode(int[] a) {
        Arrays.sort(a);
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.get(a[i]) != null) {
                map.put(a[i], map.get(a[i])+1);
            } else {
                map.put(a[i], 1);
            }
        }
        final Map<Integer, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted((Map.Entry.<Integer, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return sortedMap.entrySet().iterator().next().getKey();
    }
}

