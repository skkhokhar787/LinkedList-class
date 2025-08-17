public class OccurrencesOfN {
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

    public void findN(int n) {
        Node newHead = head;
        int count = 0;
        while (newHead != null) {
            if (newHead.data == n) {
                count++;
            }
            newHead = newHead.next;
        }
        System.out.println("The given number " + n + " occurs " + count + " times.");
    }

    public static void main(String[] args) {
        OccurrencesOfN list = new OccurrencesOfN();

        list.addFirst(1);
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(2);
        list.addLast(4);
        list.addLast(4);
        list.addLast(4);

        list.printList();

        list.findN(1);
    }
}
