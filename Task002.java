package Work005;

//Пусть дан список сотрудников:Иван Иванов, Светлана Петрова, Кристина Белова и т.д.
//Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Task002 {
    public static void main(String[] args) {
        String[] inData = new String[] {"Ivanov Ivan",
                "Svetlana Petrova",
                "Kristina Belova",
                "Anna Musina",
                "Anna Krutova",
                "Ivan Urin",
                "Petr Luikov",
                "Pavel Chernov",
                "Petr Chernyhov",
                "Marina Fedorova",
                "Marina Svetlova",
                "Marina Savina",
                "Maria Rikova",
                "Marina Lugova",
                "Anna Vladimirova",
                "Ivan Mechnikov",
                "Petr Petin",
                "Ivav Echov"};
        Map <Integer, String[]> humans = new HashMap<Integer, String[]>();
        Map <String, Integer> humansAnalyze = new HashMap<String,Integer>();
        Map <Integer, String[]> humansSorted = new LinkedHashMap<Integer, String[]>();


        int index = 0;
        for (String name : inData) {
            String[] humanData = new String[2];
            humanData = name.split(" ");
            humans.put(index, humanData);
            index++;
        }

        for (Integer id : humans.keySet()) {
            String[] humanData = humans.get(id);
            if (! humansAnalyze.containsKey(humanData[0]) ) {
                humansAnalyze.put(humanData[0], 1);
            }
            else {
                humansAnalyze.put(humanData[0], humansAnalyze.get(humanData[0]) + 1);
            }
        }


        for (Integer id : humans.keySet()) {
            System.out.printf("Data %d before sorting %s \n",id, Arrays.toString(humans.get(id)));
        }


        Map <String, Integer> temp = mySortingDescent(humansAnalyze);


        int newId = 0;
        for (Entry<String, Integer> t : temp.entrySet()) {
            for (Integer id: humans.keySet() ) {
                if ( humans.get(id)[0].equals(t.getKey()) ) {
                    humansSorted.put(newId, humans.get(id));
                    newId++;
                }
            }
        }

        //вывод результатов
        for (String id : temp.keySet()) {
            System.out.printf("Name %s has %d repeats \n",id, (temp.get(id)));
        }

        //вывод результатов
        for (Integer id : humansSorted.keySet()) {
            System.out.printf("Data %d after sorting %s \n",id, Arrays.toString(humansSorted.get(id)));
        }
    }

    public static Map<String, Integer> mySortingDescent(Map<String, Integer> arg) {
        Map <String, Integer> out = new LinkedHashMap<String, Integer>();
        ArrayList<Entry<String, Integer>> temp = new ArrayList<>(arg.entrySet());
        temp.sort(Entry.comparingByValue(Comparator.reverseOrder()));
        for (Entry<String, Integer> t : temp) {
            out.put(t.getKey(), t.getValue());
        }
        return out;
    }
}
