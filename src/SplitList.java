public class SplitList {
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

    public static void printList(Node head) {
        Node curr = head;
        if (head == null) {
            return;
        }
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public Node[] splitLL() {
        if (head == null || head.next == null) {
            return new Node[]{head, null}; // Only one node or empty
        }

        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list
        prev.next = null;

        Node firstHalf = head;
        Node secondHalf = slow;

        return new Node[]{firstHalf, secondHalf}; // Array of two heads
    }

    public static void main(String[] args) {
        SplitList list = new SplitList();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        printList(list.head);

        Node[] result = list.splitLL();

        System.out.println("First Half:");
        printList(result[0]);

        System.out.println("Second Half:");
        printList(result[1]);
    }
}
