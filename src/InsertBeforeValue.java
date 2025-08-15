public class InsertBeforeValue {
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
        if (head == null) {
            System.out.println("Linked List is Empty..");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void insertBeforeTarget(int target, int value) {
        if (head == null) {
            System.out.println("Insertion is not possible due to null of linked list.");
            return;
        }

        // Special case: target is at the head
        if (head.data == target) {
            addFirst(value);
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data == target) {
                Node newNode = new Node(value);
                prev.next = newNode;
                newNode.next = current;
                return; // Inserted, so exit
            }
            prev = current;
            current = current.next;
        }

        System.out.println("Target value " + target + " not found in the list.");
    }

    public static void main(String[] args) {
        InsertBeforeValue list = new InsertBeforeValue();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(4);

        list.printList();

        list.insertBeforeTarget(4, 3);

        list.printList();
    }
}
