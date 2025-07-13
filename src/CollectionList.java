import java.util.*;

public class CollectionList {
    public static void main (String [] args) {
        LinkedList<String> list = new LinkedList<>();

        list.addFirst("a");
        list.addFirst("is");
        list.addFirst("This");
        System.out.println(list);

        list.addLast("list");
        System.out.println(list);

        list.removeLast();
        System.out.println(list);

        list.removeFirst();
        System.out.println(list);

        System.out.println(list.size());

        for (String s : list) {
            System.out.print(s + " -> ");
        }
        System.out.println("null");
    }
}
