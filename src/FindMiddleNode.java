public class FindMiddleNode {
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

    public void printList () {
        Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public Node midNode (FindMiddleNode.Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main (String [] args) {
        FindMiddleNode list = new FindMiddleNode();

        list.addFirst(1);
        list.addLast(6);
        list.addLast(5);
        list.addLast(8);
        list.addLast(7);
        list.addLast(2);
        list.addLast(7);

        list.printList();
        System.out.println("Mid = "+list.midNode(list.head).data);

    }
}
