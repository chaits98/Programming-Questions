import java.lang.*;
import java.io.*;
import java.util.*;

class List {
    class ListNode {
        private int val;
        private List.ListNode next;

        public ListNode(int x) {
            this.val = x;
            this.next = null;
        }

        int getVal() {
            return this.val;
        }

        void setVal(int x) {
            this.val = x;
        }

        List.ListNode getNext() {
            return this.next;
        }

        void setNext(List.ListNode next) {
            this.next = next;
        }
    }

    private int length = 0;
    private List.ListNode root;
    private List.ListNode iterator;

    public List(int x) {
        root = new List.ListNode(x);
        iterator = root;
    }

    public void addRoot(int x) {
        length++;
        List.ListNode temp = root;
        root = new List.ListNode(x);
        root.setNext(temp);
    }

    public void add(int x) {
        length++;
        List.ListNode temp = root;

        while(temp.getNext() != null) {
            temp = temp.getNext();
        }

        temp.setNext(new List.ListNode(x));
    }

    public String toString() {
        String str = "";
        this.reset();

        while (this.iterator != null) {
            str += this.iterator.getVal();
            this.moveToNext();
        }

        this.reset();
        StringBuilder builder = new StringBuilder();
        builder.append(str);

        return builder.reverse().toString();
    }

    public List.ListNode moveToNext() {
        this.iterator = this.iterator.getNext();
        return this.iterator;
    }

    public void reset() {
        this.iterator = this.root;
    }

    public int getLength() {
        return this.length;
    }

    public List.ListNode getRoot() {
        return this.root;
    }

    public List.ListNode getIterator() {
        return this.iterator;
    }
}


public class Answer {
    public static List addTwoNumbers(List l1, List l2) {
        List result = null;

        if (l2.getLength() > l1.getLength()) {
            result = l1;
            l1 = l2;
            l2 = result;
            result = null;
        }

        boolean carry = false;
        l1.reset();
        l2.reset();

        while (l2.getIterator() != null) {
            int x = l2.getIterator().getVal() + l1.getIterator().getVal();
            if (carry) {
                x++;
            }
            
            if (x > 9) {
                x %= 10;
                carry = true;
            } else {
                carry = false;
            }

            if (result == null) {
                result = new List(x);
            } else {
                result.add(x);
            }

            l1.moveToNext();
            l2.moveToNext();
        }

        if (l1.getLength() != l2.getLength()) {
            int i = 0;
            while (i < l1.getLength() - l2.getLength()) {
                result.add(l1.getIterator().getVal());
				result.moveToNext();
				l1.moveToNext();
				i += 1;
            }
        }

        l1.reset();
        l2.reset();
        result.reset();
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List list1 = null;
        List list2 = null;
        String inputString;

        System.out.print("Please enter the first number: ");
        inputString = Integer.toString(sc.nextInt());
        for (char c : inputString.toCharArray()) {
            if (list1 == null)
                list1 = new List(Integer.parseInt(String.valueOf(c)));
            else
                list1.addRoot(Integer.parseInt(String.valueOf(c)));
        }

        System.out.print("Please enter the second number: ");
        inputString = Integer.toString(sc.nextInt());
        for (char c : inputString.toCharArray()) {
            if (list2 == null)
                list2 = new List(Integer.parseInt(String.valueOf(c)));
            else
                list2.addRoot(Integer.parseInt(String.valueOf(c)));
        }

        System.out.println(list1.toString());
        System.out.println(list2.toString());

        List result = addTwoNumbers(list1, list2);
        System.out.println(result.toString());

        sc.close();
    }
}