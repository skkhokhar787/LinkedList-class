public class ReverseKGroup {
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

    public Node reverseKGroup(Node head, int k) {
        Node temp = head;
        int count = 0;
        // Check if K Nodes Exist
        while (count < k) {
            if (temp == null) {
                return head;
            }
            temp = temp.next;
            count++;
        }
        // Recursively call for reset of Linked List
        Node pervNode = reverseKGroup(temp, k);

        // Reverse current group
        temp = head;
        count = 0;
        while (count < k) {
            Node next = temp.next;
            temp.next = pervNode;

            pervNode = temp;
            temp = next;
            count++;
        }
        return pervNode;
    }

    public static void main(String[] args) {
        ReverseKGroup list = new ReverseKGroup();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.printList();

        list.head = list.reverseKGroup(list.head, 2);

        list.printList();

    }
}
