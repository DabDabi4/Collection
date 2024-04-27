import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TesterCollection {
    private final String[] dataStructures = {"ArrayList", "LinkedList", "LinkedHashSet", "TreeSet", "HashSet", "HashMap", "LinkedHashMap", "TreeMap"};
    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private LinkedHashSet<Integer> linkedHashSet;
    private TreeSet<Integer> treeSet;
    private HashSet<Integer> hashSet;
    private HashMap<Integer, String> hashMap;
    private LinkedHashMap<Integer, String> linkedHashMap;
    private TreeMap<Integer, String> treeMap;

    public int anotherI = 1;

    public TesterCollection() {
        this.arrayList = new ArrayList<>();
        this.linkedList = new LinkedList<>();
        this.linkedHashSet = new LinkedHashSet<>();
        this.treeSet = new TreeSet<>();
        this.hashSet = new HashSet<>();
        this.hashMap = new HashMap<>();
        this.linkedHashMap = new LinkedHashMap<>();
        this.treeMap = new TreeMap<>();
    }

    public void runTests(int count) {
        Map<String, Long> addingResults = new HashMap<>();
        Map<String, Long> containingResults = new HashMap<>();
        Map<String, Long> filteringResults = new HashMap<>();
        Map<String, Long> findingResults = new HashMap<>();

        // Додавання елементів
        addingResults.put("ArrayList", testAdding(() -> arrayList.add(anotherI), count));
        addingResults.put("LinkedList", testAdding(() -> linkedList.add(anotherI), count));
        addingResults.put("LinkedHashSet", testAdding(() -> linkedHashSet.add(anotherI), count));
        addingResults.put("TreeSet", testAdding(() -> treeSet.add(anotherI), count));
        addingResults.put("HashSet", testAdding(() -> hashSet.add(anotherI), count));
        addingResults.put("HashMap", testAdding(() -> hashMap.put(anotherI, "da"), count));
        addingResults.put("LinkedHashMap", testAdding(() -> linkedHashMap.put(anotherI, "da"), count));
        addingResults.put("TreeMap", testAdding(() -> treeMap.put(anotherI, "da"), count));

        //Containing test
        containingResults.put("ArrayList", testActions(() -> arrayList.contains(arrayList.size() - 1)));
        containingResults.put("LinkedList", testActions(() -> linkedList.contains(linkedList.size() - 1)));
        containingResults.put("LinkedHashSet", testActions(() -> linkedHashSet.contains(linkedHashSet.size() - 1)));
        containingResults.put("TreeSet", testActions(() -> treeSet.contains(treeSet.size() - 1)));
        containingResults.put("HashSet", testActions(() -> hashSet.contains(hashSet.size() - 1)));
        containingResults.put("HashMap", testActions(() -> hashMap.containsKey(hashMap.size() - 1)));
        containingResults.put("LinkedHashMap", testActions(() -> linkedHashMap.containsKey(linkedHashMap.size() - 1)));
        containingResults.put("TreeMap", testActions(() -> treeMap.containsKey(treeMap.size() - 1)));

        //Filtering test
        filteringResults.put("ArrayList", testActions(() -> arrayList.parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toList())));
        filteringResults.put("LinkedList", testActions(() -> linkedList.parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toList())));
        filteringResults.put("LinkedHashSet", testActions(() -> linkedHashSet.parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toList())));
        filteringResults.put("TreeSet", testActions(() -> treeSet.parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toCollection(TreeSet::new))));
        filteringResults.put("HashSet", testActions(() -> hashSet.parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toSet())));
        filteringResults.put("HashMap", testActions(() -> hashMap.keySet().parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toList())));
        filteringResults.put("LinkedHashMap", testActions(() -> linkedHashMap.keySet().parallelStream().filter(x -> x % 2 == 0).collect(Collectors.toList())));
        filteringResults.put("TreeMap", testActions(() -> treeMap.keySet().parallelStream().filter(x -> x % 2 == 0).collect(
            Collectors.toList())));

        //Finding test
        findingResults.put("ArrayList", testActions(() -> arrayList.parallelStream().filter(x -> x == arrayList.size() - 1).findAny()));
        findingResults.put("LinkedList", testActions(() -> linkedList.parallelStream().filter(x -> x == linkedList.size() - 1).findAny()));
        findingResults.put("LinkedHashSet", testActions(() -> linkedHashSet.parallelStream().filter(x -> x == linkedHashSet.size() - 1).findAny()));
        findingResults.put("TreeSet", testActions(() -> treeSet.parallelStream().filter(x -> x == treeSet.size() - 1).findAny()));
        findingResults.put("HashSet", testActions(() -> hashSet.parallelStream().filter(x -> x == hashSet.size() - 1).findAny()));
        findingResults.put("HashMap", testActions(() -> hashMap.keySet().parallelStream().filter(x -> x == hashMap.size() - 1).findAny()));
        findingResults.put("LinkedHashMap", testActions(() -> linkedHashMap.keySet().parallelStream().filter(x -> x == linkedHashMap.size() - 1).findAny()));
        findingResults.put("TreeMap", testActions(() -> treeMap.keySet().parallelStream().filter(x -> x == treeMap.size() - 1).findAny()));

        printResults("Додавання елементів:", addingResults);
        printResults("Перевірка наявності елемента:", containingResults);
        printResults("Фільтрування елементів:", filteringResults);
        printResults("Пошук елемента:", findingResults);
    }

    private long testAdding(Runnable action, int count) {
        long start = System.nanoTime();
        for (int i = 0; i < count; i++) {
            action.run();
            anotherI++;
        }
        long end = System.nanoTime();
        anotherI = 1;
        return (end - start) / 1_000_000;
    }

    public long testActions(Runnable action) {
        long startTime = System.nanoTime();
        action.run();
        long endTime = System.nanoTime();
        return (endTime - startTime)  / 1_000_000;
    }

    private void printResults(String message, Map<String, Long> results) {
        System.out.println(message);
        for (String dataStructure : dataStructures) {
            System.out.print("{" + dataStructure + "=" + (results.getOrDefault(dataStructure, 0L)) + "}, ");
        }
        System.out.println();
    }

}
