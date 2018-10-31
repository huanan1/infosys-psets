import java.util.Arrays;

public class Palindrome {
    public static boolean isPalindrome (char[] S) {
        char[] newS = S;
        if(newS.length == 0 || newS.length ==1) return true;
        if(newS[0] == newS[newS.length-1]) {
            newS = Arrays.copyOfRange(newS,1,newS.length-1);
            return isPalindrome(newS);
        }
        return false;
    }
}
