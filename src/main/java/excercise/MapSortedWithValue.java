package excercise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Employee {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class MapSortedWithValue{
    public static void main(String[] args) {
        HashMap<Integer, Employee> records = new HashMap<>();
        records.put(100, new Employee(123, "Charlie"));
        records.put(28, new Employee(3232, "Bob"));
        records.put(79, new Employee(34, "Alice"));

        Comparator<Integer> idComparator = (id1, id2) -> {
            int empId1 = records.get(id1).getId();
            int empId2 = records.get(id2).getId();
            return Integer.compare(empId1, empId2);
        };

        // Create a TreeMap with the custom comparator
        TreeMap<Integer, Employee> sortedRecords = new TreeMap<>(idComparator);

        // Put all elements from HashMap to TreeMap
        sortedRecords.putAll(records);

        // Print the sorted map
        for (Map.Entry<Integer, Employee> entry : sortedRecords.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue().getName() + " (ID: " + entry.getValue().getId() + ")");
        }
    }
}
