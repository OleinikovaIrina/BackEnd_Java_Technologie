import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Person> list = new ArrayList<>();
        list.add(new Person("Oleg", 23));
        list.add(new Person("Ira", 23));
        list.add(new Person("Olga", 23));

    }
    public static  boolean ifPersonNameExist(List<Person>list, String name){

        return     list.stream()
        .anyMatch(p-> p.getName().equalsIgnoreCase(name));

    }






}