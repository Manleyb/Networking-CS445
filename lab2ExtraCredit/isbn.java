import java.util.*;

class isbn {

    /*
     * Bryce Manley, Nathan Kline, Kai Vickers
     * Networking
     * Lab 2 Extra credit
     * ISBN Checker
     * will determin if a given isbn is valid will not accept command line args
     */

    public static void main(String[] args) {
        String isbn = "0074625428";
        if (isbnCheck(isbn)) {
            System.out.println("Valid ISBN");
        } else {
            System.out.println("Invalid ISBN");
        }

    }

    static boolean isbnCheck(String isbn) {
        // a method to check is a given isbn string is valid
        // from Geeks for geeks https://www.geeksforgeeks.org/program-check-isbn/
        // "ISBN is a 10 digit number that is used to identify a book.
        // The first nine digits of the ISBN number are used to represent the Title,
        // Publisher and Group of the book and the last digit is used for checking
        // whether
        // ISBN is correct or not....""
        // "To verify an ISBN, calculate
        // 10 times the first digit, plus 9 times the second digit,
        // plus 8 times the third digit and so on until we add
        // 1 time the last digit. If the final number leaves no
        // remainder when divided by 11, the code is a valid ISBN."

        // first we need the length of the string to make sure is is 10
        int n = isbn.length();
        if (n != 10) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            // get relevent didget from 0-9
           // char t = isbn.charAt(i);
            String s;

            s = "" + isbn.charAt(i);
            int x = Integer.parseInt(s);
            sum += x * (10 - i);
        }
        // we have to deal with the last digit if it is X
        // we add 10 to sum otherwise we add the value to the sum
       // String last;
        char later;
        later = isbn.charAt(9);
       // last = "" + isbn.charAt(9);
       // int l = Integer.parseInt(last);
        if (later == 'X') {
            sum += 10;
        } else {

            sum += later;
            //did not know you could add char to int like this 
            //the more you know https://www.youtube.com/watch?v=GD6qtc2_AQA
        }

        // finally we perfom the check by dividing the sum by 11
        // if the remainder is 0 then the isbn is valid
        if (sum % 11 == 0) {
            return true;
        }
        return false;
    }

}
