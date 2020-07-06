import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


class Difference {
    private int[] elements;
    public int maximumDifference;

    Difference(int[] a){
        this.elements = a;
    }

    // Add your code here
    void computeDifference(){
        List<Integer> list = new ArrayList<>(16);
        for(int i =0; i<=elements.length-2;i++){
            for(int j =i+1; j<=elements.length-1 ; j++){
                list.add(Math.abs(elements[i]-elements[j]));
            }
        }
        list.sort(Comparator.naturalOrder());
        maximumDifference= list.get(list.size()-1);
    }

    public int divisorSum(int n) {
        int sum =0;
        for(int i =0; i<=n;i++){
            if(n%i ==0)
                sum= sum +i;
        }
        return sum;
    }

    static void printArr(int[] arr){
            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

} // End of Difference class

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}