public class CountFromLast {
    Node head;

    public static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast (int data) {
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

    public static Node removeNThNode(Node list, int n) {
        if (list.next == null) {
            return null;
        }

        int size = 0;
        Node curr = list;

        while (curr != null) {
            curr = curr.next;
            size++;
        }
        int idxToSearch = size - n;
        Node perv = list;
        int i = 1;
        while (i < idxToSearch) {
            perv = perv.next;
            i++;
        }
        perv.next = perv.next.next;
        return list;
    }

    public void printList () {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
        // System.out.println();
    }

    public static void main (String [] args) {
        CountFromLast list = new CountFromLast();
        int n = 4;

        list.addFirst(1);
        list.addLast(5);
        list.addLast(4);
        list.addLast(9);
        list.addLast(7);
        list.addLast(3);
        list.addLast(6);

        list.printList();

        list.head = removeNThNode(list.head, n);

        list.printList();
    }
}
