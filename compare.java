import java.io.*;
import java.util.Scanner;

/*
Create a PhoneBook.
In the first version of the program, the PhoneBook will be a ListPhoneBook.
In the second version of the program, the PhoneBook will be a BinarySearchTreePhoneBook.
Read each line of data.csv and insert() it into the PhoneBook created. Print out the total time (in milliseconds) it takes to insert() a million name and phone number entries.
Print out the size() of the PhoneBook and ensure that it is 1000000. This is a basic test to ensure that you’ve successfully read all the data. If the size if not 1000000 you should terminate your program with an error message.
Read each line of search.txt and find() it in the PhoneBook you created. Ensure that the find() method never returns -1, as each name in search.txt is present in data.csv. If find() ever returns -1, you should terminate your program with an error message. Print the number of times that find() is called, and ensure that it is exactly 1000. If it isn’t, you should terminate your program with an error message. Print out the total time (in milliseconds) it takes to find() a thousand names in your PhoneBook.

Here is what sample output of your program should look like:

Insert took 2250 milliseconds.
The size of the PhoneBook is 1000000.
find() was called 1000 times.
Search took 500 milliseconds.

 */
public class compare {
    public static class PhoneBookFactory {
        public static PhoneBook getArrayListPhoneBook() {
            return new ListPhoneBook();
        }

        public static PhoneBook getBinarySearchTreePhoneBook() {
            return new BinarySearchTreePhoneBook();
        }
    }

//    public static void main(String[] args) throws IOException {
//        String csvFile = "/User/TJ/Destop/Career Prep/HomeWork2/src/data.csv";
//        BufferedReader br = null;
//        String line = "";
//        String csvSplitBy = ",";
//        try {
//            br = new BufferedReader(new FileReader(csvFile));
//            while ((line = br.readLine()) != null) {
//                String coun = line.split();
//
//                ListPhoneBook lpb = new ListPhoneBook();
//                lpb.insert(coun.substring(0), coun.substring());
//
//                System.out.println(lpb);
//
//
//            }
//        } catch (Exception e) {
//
//        }
//    }
}

