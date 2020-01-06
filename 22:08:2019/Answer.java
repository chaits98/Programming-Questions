import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

class Stack {
    public class Node {
        private Character val;
        private Stack.Node next;
    
        public Character getVal() {
            return this.val;
        }
    
        public Stack.Node getNext() {
            return this.next;
        }

        public void setNext(Stack.Node next) {
            this.next = next;
        }
        
        public Node(Character x) {
            this.val = x;
            next = null;
        }
    }
    
    private Stack.Node top;
    private int length;
    
    public Stack() {
        this.length = 0;
        this.top = null;
    }

    public int getLength() {
        return this.length;
    }

    public Stack(Character x) {
        length = 1;
        top = new Stack.Node(x);
    }

    public void push(Character x) {
        Stack.Node temp = new Stack.Node(x);
        temp.setNext(this.top);
        this.top = temp;
        length++;
    }

    public Character pop() {
        length--;
        Stack.Node temp = this.top;
        this.top = this.top.getNext();
        return temp.getVal();
    }

    public Character peek() {
        return this.top.getVal();
    }
}

class Answer {
    public static boolean isValid(String s) {
        Stack stack = new Stack();
        HashMap<Character, Character> opening = new HashMap<Character, Character>();
        opening.put('(', ')');
        opening.put('{', '}');
        opening.put('[', ']');
        HashMap<Character, Character> closing = new HashMap<Character, Character>();
        closing.put(')', '(');
        closing.put('}', '{');
        closing.put(']', '[');

        boolean isValid = true;

        for(Character c : s.toCharArray()) {
            if (opening.get(c) != null) {
                stack.push(opening.get(c));
            }
            else if (closing.get(c) != null) {
                if (stack.pop() != c) {
                    isValid = false;
                    break;
                }
            }
        }

        if (stack.getLength() == 0) return isValid; else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString;

        System.out.print("Please enter the string: ");
        inputString = sc.nextLine();

        System.out.println("The input string is " + (isValid(inputString) ? "valid" : "invalid"));
        sc.close();
    }
}