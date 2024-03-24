import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

public class CustomListExample {
    public static void main(String[] args) {
        CustomList<String> customList = new CustomList<>();

        customList.add("A");
        customList.add("B");
        customList.add("C");

        System.out.println("Lista: " + customList);


        Iterator<String> iterator = customList.iterator();
        System.out.println("Wysietlanie elementow z listy za pomoca iteratora: ");
        while (iterator.hasNext()){
            String element = iterator.next();
            System.out.println(element + " ");
        }

        customList.add(1, "X");
        customList.add(3, "Y");

        System.out.println("Lista po dodaniu na pozycjach: " + customList);

        customList.remove("X");
        customList.remove(3);

        System.out.println("Lista po usunięciu: " + customList);

        System.out.println("Czy lista zawiera litere A: " + customList.contains("A"));

        System.out.println("Element listy o indeksie 1: " + customList.get(1));

        System.out.println("Litera Y znajduje sie na miejscu: " + customList.indexOf("Y"));

        customList.clear();

        System.out.println("Lista po uzyciu funkcji clear: " + customList);

        customList.add("A");
        customList.add("B");
        customList.add("A");
        customList.add("C");

        
        System.out.println("Lista: " + customList);
        customList.removeAll(Collections.singleton("A"));
        System.out.println("Lista po funkcji removeAll(): " + customList);
        customList.add("C");
        customList.retainAll(Collections.singleton("C"));
        System.out.println("Lista: " + customList);

    }
}
