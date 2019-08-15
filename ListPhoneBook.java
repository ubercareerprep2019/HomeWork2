import java.util.ArrayList;
import java.util.List;

public class ListPhoneBook implements PhoneBook {

    private ArrayList<PhoneRecord> records;
    public ListPhoneBook () {
        records = new ArrayList<>();
    }
    @Override
    public void insert(String name, long phoneNumber) {
        records.add(new PhoneRecord(name, phoneNumber));
    }
    @Override
    public long find(String name) {
        for (PhoneRecord s : records) {
            if (s.name.contains(name)) {
                return s.phoneNumber;
            }
        }
        return -1;
    }
    @Override
    public int size() {
        return records.size();
    }
    public static class PhoneRecord {
        public String name;
        public long phoneNumber;
        public PhoneRecord(String name, long phoneNumber) {
            this.name = name;
            this.phoneNumber = phoneNumber;
        }
    }
    public static void main(String[] args) {
        ListPhoneBook lpb = new ListPhoneBook();
        lpb.insert("ABC", 1111111111);
        lpb.insert("XYZ", 999999999);
        lpb.insert("DEF", 222222222);

        System.out.println(lpb.find("poy"));


    }
}
