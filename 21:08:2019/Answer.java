import java.lang.*;
import java.io.*;
import java.util.*;

class Result {
    private int result, start;
    
    public Result(int result, int start) {
        this.result = result;
        this.start = start;
    }

    public int getResult() {
        return this.result;
    }

    public int getStart() {
        return this.start;
    }
}

public class Answer {
    public static Result longestPalindrome(String s) {
        int result = 1, start = 0;
        boolean table[][] = new boolean[s.length()][s.length()];
        for (int i=0; i<s.length(); i++) {
            table[i][i] = true;
        }

        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                start = i;
                result = 2;
                table[i][i+1] = true;
            }
        }

        for (int k=3; k<s.length(); k++) {
            for (int i=0; i<(s.length() - k + 1); i++) {
                int j = i + k - 1;

                if (table[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;
                    if (k > result) {
                        start = i;
                        result = k;
                    }
                }
            }
        }

        return new Result(result, start);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString;

        System.out.print("Please enter the string: ");
        inputString = sc.nextLine();

        Result res = longestPalindrome(inputString);
        System.out.println("The longest palindrome is: \"" + (inputString.substring(res.getStart(), res.getResult() + res.getStart())) + "\"");
        sc.close();
    }
}