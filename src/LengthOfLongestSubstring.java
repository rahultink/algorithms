class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int start =0 ;
        int end = 0;
        for(int i =0; i<chars.length; i++){
             start =i;

            for(int j =i+1; j<chars.length; j++){
                String substring = s.substring(i,j);
                if(substring.indexOf(chars[j]) == -1){
                    end=j;
                }
                else{
                    end = i;
                }
            }
        }
        return s.substring(start,end).length();
    }

    public static void main(String args[]){
       lengthOfLongestSubstring("abcabcbb");
    }
}