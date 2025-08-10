public class ExtractEvenOdd {
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

    public void checkEven() {
        Node currHead = head;
        while (currHead != null) {
            if (currHead.data % 2 == 0) {
                System.out.print(currHead.data + " -> ");
            }
            currHead = currHead.next;
        }
        System.out.println("null");
    }

    public void checkOdd() {
        Node currHead = head;
        while (currHead != null) {
            if (currHead.data % 2 != 0) {
                System.out.print(currHead.data + " -> ");
            }
            currHead = currHead.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ExtractEvenOdd list = new ExtractEvenOdd();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);

        list.printList();

        list.checkEven();

        list.checkOdd();
    }
}
