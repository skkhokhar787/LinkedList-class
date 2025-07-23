public class MiddleNode {
    Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
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

    public void printList () {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("null");
    }

    public Node midNode () {
        int count = 0;
        Node curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int middle = count / 2;
        curr = head;
        for (int i = 0; i < middle; i++) {
            curr = curr.next;
        }

        return curr;
    }

    public static void main (String [] args) {
        MiddleNode list = new MiddleNode();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(5);
        list.addLast(6);

        list.printList();

        Node mid = list.midNode();

        System.out.println("Mid = " + mid.data);
    }
}
