public class StringLab {

    /**
     * @param str The input string
     * @return The reversed string
     */
    public String reverseString(String str) {
        //TODO
        /*var c=new char[str.length()];
        for(int i=0;i<str.length();i++){
            c[str.length()-1-i]=str.charAt(i);
        }*/
        StringBuilder c=new StringBuilder(str);
        return c.reverse().toString(); // YOU also need to modify this line
    }

    /**
     * Makes all characters before the index value uppercase, makes all characters on the index and afterwards
     * lowercase. See test cases for a better understanding.
     *
     * @param str   The input string
     * @param index All character positions smaller than index must be uppercase. All character positions greater
     *              than index must be lowercase.
     * @return The new string
     */
    public String capitalizeAndMakeLowercase(String str, int index) {
        //TODO
        if(index>=str.length()){
            return str.toUpperCase();
        }else if(index<0){
            return str.toLowerCase();
        }else {
            var f = str.substring(0, index);
            var b = str.substring(index);
            String s1 = f.toUpperCase();
            String s2 = b.toLowerCase();
            return new String(s1 + s2); // YOU also need to modify this line
        }
    }

    /**
     * Counts the number of vowels in a string.
     *
     * @param str The input string
     * @return The number of vowels
     */
    public long countVowels(String str) {
        //TODO
        int num=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                num++;
            }
        }
        StringBuffer s = new StringBuffer(str);
        return num; // YOU also need to modify this line
    }

    /**
     * Removes a certain letter from a string
     *
     * @param str The input string
     * @param a   The letter to remove
     * @return The input string without the specified letter
     */
    public String removeLetter(String str, char a) {
        //TODO
        StringBuffer s=new StringBuffer(str);
        while (s.toString().contains(String.valueOf(a))) {
            s.deleteCharAt(s.indexOf(String.valueOf(a)));
        }
        return s.toString(); // YOU also need to modify this line
    }

    /**
     * Checks if a string is a palindrome
     *
     * @param str The string to check
     * @return Whether or not the string is a palindrome
     */
    public boolean isPalindrome(String str) {
        //TODO
        var f="";
        var b="";
        if(str.length()%2==1){
             f=str.substring(0,str.length()/2);
             b=reverseString(str.substring(str.length()/2+1));
        }else{
             f=str.substring(0,str.length()/2);
             b=reverseString(str.substring(str.length()/2));
        }
        //System.out.println(f);
        if(f.equals(b)){
            return true;
        }else{
            return false;
        }
        //return false; // YOU also need to modify this line
    }
}
