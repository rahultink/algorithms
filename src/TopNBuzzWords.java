import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopNBuzzWords {

    public static void main(String[] args) {
        int numToys = 6;
        int topToys = 2;
        String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
        int numQuotes = 6;
        String[] quotes = {
                "Elmo is the hottest of the season! Elmo will be on every kid's wishlist!",
                "The new Elmo dolls are super high quality",
                "Expect the Elsa dolls to be very popular this year, Elsa!",
                "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                "For parents of older kids, look into buying them a drone",
                "Warcraft is slowly rising in popularity ahead of the holiday season"
        };
        System.out.println(Math.abs(1-2));
    }

    static String gameOfThrones(String s) {
        List<Map.Entry<Character, Integer>> collect = getCollectorSize(s);
        if (s.length() % 2 == 0 && collect.size() == 0)
            return "YES";
        if (s.length() % 2 != 0 && collect.size() == 1)
            return "YES";
        return "NO";
    }

    private static List<Map.Entry<Character, Integer>> getCollectorSize(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                Integer integer = map.get(s.charAt(i));
                map.put(s.charAt(i), integer + 1);
            } else {
                map.put(s.charAt(i), count);
            }
        }
        return map.entrySet().stream().filter(k -> k.getValue() % 2 != 0).collect(Collectors.toList());
    }

    static int dArr(int[][] arr) {
        List<Integer> list = new ArrayList<>(16);
        for(int i =0; i<4;i++){
            for(int j = 0; j<4;j++){
               list.add(arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]);
            }
        }
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedList.get(15));
        return sortedList.get(15);
    }

    static int dArr2(int[][] arr) {
        int sum[] = new int[16];
        int h = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum[h] = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                        + arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1]
                        + arr[i+2][j+2];
                h++;
            }
        }
        Arrays.sort(sum);
        System.out.println(sum[15]);
        return sum[15];
    }

}
// solve(12,20,8);
//   int[] arr = {3, 4, 7, 5, 6, 2, 1};
//  insertionSort1(10, arr );


// insertionSort1(7, arr);


//        int i = 4;
//        double d = 4.0;
//        String s = "HackerRank ";
//
//        Scanner scan = new Scanner(System.in);
//
//        int inputInt = scan.nextInt();
//        double inputDoub = scan.nextDouble();
//        String inputString = scan.nextLine();
//        int x = i + inputInt;
//        double dd= d + inputDoub;
//        System.out.println(x);
//        System.out.println( dd);
//        System.out.print( s + inputString);
//        System.out.println(inputString);
//        scan.close();

//
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        scan.nextLine();
//
//        for (int i = 0; i < n; i++) {
//            String s = scan.nextLine();
//            StringBuilder even = new StringBuilder();
//            StringBuilder odd = new StringBuilder();
//            for (int j = 0; j < s.length() - 1; j++) {
//                if (j % 2 == 0) {
//                    even.append(s.charAt(j));
//                } else {
//                    odd.append(s.charAt(j));
//                }
//                System.out.println(even.toString() + " " + odd.toString());
//            }
////            System.out.println(even.toString());
////            System.out.println(odd.toString());
//
//        }
//
///*        static void solve ( double meal_cost, int tip_percent, int tax_percent){
//            double i = tip_percent / 100;
//            double tip = meal_cost * i;
//            double tax = meal_cost * (tax_percent / 100);
//            double totalCost = meal_cost + tip + tax;
//            int t = (int) totalCost;
//            System.out.println(t);
//        }*/
//
///*
//        static void insertionSort1(int n,int[] arr){
//            int s = arr[n - 1];
//            for (int i = n - 2; i >= 0; i--) {
//                if (arr[i] <= s) {
//                    arr[i + 1] = s;
//                    //    printArr(arr);
//                    break;
//                }
//                arr[i + 1] = arr[i];
//                //  printArr(arr);
//            }
//            if (s < arr[0]) {
//                arr[0] = s;
//                // printArr(arr);
//            }
//        }
//
//        static void insertionSort2 (int n,int[] arr){
//            for (int i = 1; i < n; i++) {
//                int nu = arr[i];
//                for (int j = 0; j < i; j++) {
//                    if (arr[j] > arr[i]) {
//                        arr[i] = arr[j];
//                        arr[j] = nu;
//                    }
//                }
//                //  printArr(arr);
//            }
//        }*/
//
///*
//        static void printArr(int[] arr){
//            for (int element : arr) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }*/
//
//
//
//
///*    static int factorial(int n) {
//        if(n==0) {
//            return 1;
//        }
//        return (n * factorial(n - 1));
//    }*/
//
//    }
//
//
//
//}
