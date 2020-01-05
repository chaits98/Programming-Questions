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
    private static Result lengthOfLongestSubstring(String s) {
        int startIndex = 0, endIndex = 0, start = 0, result = 1, i;
        HashMap<Character, Integer> chars = new HashMap();
        for (i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (chars.get(c) == null || startIndex > chars.get(c)) {
                endIndex = i;

            } else {
                startIndex = chars.get(c);
            }
            chars.put(c, i);
            if (endIndex - startIndex > result) {
                result = endIndex - startIndex;
                start = startIndex + 1;                
            }
        }

        return new Result(result, start);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString;

        System.out.print("Please enter the string: ");
        inputString = sc.nextLine();

        Result res = lengthOfLongestSubstring(inputString);
        System.out.println("Length of longest substring without repeating characters is " + (res.getResult()));
        System.out.println("The substring is: \"" + (inputString.substring(res.getStart(), res.getResult() + res.getStart())) + "\"");
        sc.close();
    }
}