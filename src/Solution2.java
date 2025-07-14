public class Solution2 {
    Node head;

    public static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst (int data) {
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

    public void filterGreaterThan(int limit) {
        // Remove nodes from the beginning if they exceed 25
        while (head != null && head.data > limit) {
            head = head.next;
        }

        // Traverse and remove subsequent nodes as needed
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data > limit) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
       // System.out.println();
    }

    public static void main (String [] args) {
        Solution2 list = new Solution2();

        list.addFirst(44);
        list.addLast(9);
        list.addLast(15);
        list.addLast(45);
        list.addLast(20);
        list.addLast(33);
        list.addLast(40);
        list.addLast(2);
        list.addLast(3);

        list.printList();

        list.filterGreaterThan(15);

        list.printList();
    }
}
