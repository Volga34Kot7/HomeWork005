//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
package Work005;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Task001 {
    public static void main(String[] args) {

        LinkedList<String> lk = new LinkedList<>();
        lk.add(0, " 8989044551, 8984436677");
        lk.add(1, " 8989556611");
        lk.add(2, " 8919445588, 8989007777");
        lk.add(3, " 8989111223");

        LinkedList<String> lk_name = new LinkedList<>();
        lk_name.add(0, "Ivan ");
        lk_name.add(1, "Kirill ");
        lk_name.add(2, "Igor ");
        lk_name.add(3, "Nadia ");


        HashMap<String, String> guid = new HashMap<>();
        for(int i =0; i < lk.size(); i++){

            guid.put(lk_name.get(i), lk.get(i));

        }
        System.out.println(guid);
    }

}
