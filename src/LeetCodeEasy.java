import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LeetCodeEasy {

    public static void main(String[] args) {
        removeDuplicates1(new int[]{1, 1, 2});
        removeDuplicatesAlternate(new int[]{1, 1, 2});

    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int n : nums) {
            int count = 1;
            if (map.get(n) == null) {
                map.put(n, count);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public boolean isHappy(int number) {
        Set<Integer> seenNumbers = new HashSet<Integer>();
        while (seenNumbers.add(number)) {
            int digitsSum = 0;
            while (number > 0) {
                digitsSum += Math.pow(number % 10, 2);
                number /= 10;
            }
            number = digitsSum;
            if (number == 1)
                return true;
        }
        return false;
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSumAlternate(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }
        }
        map.entrySet().forEach(k -> System.out.println(k.getKey()));
        return map.size();
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        //  System.out.println(nums.length);
        printArr(nums);
        return i + 1;
    }

    public static int removeDuplicatesAlternate(int[] nums) {
        int n = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[n++] = nums[i + 1];
            }
        }
        return nums.length;
    }

    static void printArr(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }


    public void reverseString(char[] s) {
        int n = s.length - 1;
        for (int i = 0; i < s.length/2; i++) {
            char temp = 0;
            temp =s[n];
            s[n] = s[i];
            s[i] = temp;
            n--;
        }
    }

    public String defangIPaddr(String address) {

        return address.replace(".", "[.]");

    }

}

