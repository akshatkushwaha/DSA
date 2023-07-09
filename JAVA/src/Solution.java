import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface MyList {
    void convert(String[] strings);

    void replace(int index);
}

class ArrayToList implements MyList {
    List<String> arrayToList;

    public ArrayToList() {
        this.arrayToList = new ArrayList<>();
    }

    public void convert(String[] strings) {
        for (String string : strings) {
            arrayToList.add(string);
            System.out.println("I have added the string: " + string + " at the index: " + arrayToList.indexOf(string));
        }
    }

    public void replace(int index) {
        String string = arrayToList.get(index);
        arrayToList.set(index, null);
        System.out.println("I have replaced the string: " + string + " with a null string");
    }

    public ArrayList<String> compact() {
        ArrayList<String> compactList = new ArrayList<>();
        for (String string : arrayToList) {
            if (string != null) {
                compactList.add(string);
            }
        }
        return compactList;
    }
}

class InvalidStringException extends Exception {
    public InvalidStringException(String message) {
        super(message);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayToList arrayToList = new ArrayToList();
        String[] strings = new String[n];
        for (int i = 0; i < n; ++i) {
            String input = sc.next();
            strings[i] = input;
        }

        arrayToList.convert(strings);
        arrayToList.replace(1);
    }
}