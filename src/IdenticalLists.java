public class IdenticalLists {
    Node head;

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
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
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void isIdentical(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;

        while (curr1 != null && curr2 != null) {
            if (curr1.data != curr2.data) {
                System.out.println("Both Linked Lists are Not Identical.");
                return;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        if (curr1 == null && curr2 == null) {
            System.out.println("Both Linked Lists are Identical.");
        } else {
            System.out.println("Both Linked Lists are Not Identical.");
        }
    }

    public static void main(String[] args) {
        IdenticalLists list1 = new IdenticalLists();
        IdenticalLists list2 = new IdenticalLists();

        list1.addFirst(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(4);

        list2.addFirst(1);
        list2.addLast(2);
        list2.addLast(3);
        list2.addLast(4);

        list1.isIdentical(list1.head, list2.head);
    }
}
