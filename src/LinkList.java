public class LinkList {
    Node head;
    private static int size = 0;

    public static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;

            size++;
        }
    }
    public void addFirst (String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast (String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;

            return;
        }
        Node lastNode = head;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;

    }
    public void printList() {
        Node currNode = head;


        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    // delete first
    public void removeFirst () {
        if (head == null) {
            System.out.println("The list is empty...");
            return;
        }
        size--;
        head = head.next;
    }

    // delete last
    public void removeLast () {
        if (head == null) {
            System.out.println("The list is empty...");
            return;
        }
        size--;

        if (head.next == null) {
            head = null;
            return;
        }

        Node sce_lastNode  = head;
        Node lastNode = head.next;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
            sce_lastNode = sce_lastNode.next;
        }

        sce_lastNode.next = null;
    }

    public void getSize () {
        System.out.println(size);
    }

    public static void main (String [] args) {
        LinkList list = new LinkList();

        list.addFirst("a");
        list.addFirst("is");
        list.printList();
        list.addLast("list");
        list.printList();
        list.addFirst("This");
        list.printList();

        list.removeFirst();
        list.printList();
        list.removeLast();
        list.printList();

        list.getSize();
    }
}