public class MinMaxValue {
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

    public void maxVal() {
        Node currHead = head;
        int max = Integer.MIN_VALUE;
        while (currHead != null) {
            if (currHead.data > max) {
                max = currHead.data;
            }
            currHead = currHead.next;
        }
        System.out.println("Max = " + max);
    }

    public void minVal() {
        Node currHead = head;
        int min = Integer.MAX_VALUE;
        while (currHead != null) {
            if (currHead.data < min) {
                min = currHead.data;
            }
            currHead = currHead.next;
        }
        System.out.println("Min = " + min);
    }

    public static void main(String[] args) {
        MinMaxValue list = new MinMaxValue();

        list.addFirst(1);
        list.addLast(4);
        list.addLast(2);
        list.addLast(3);
        list.addLast(5);

        list.printList();

        list.maxVal();
        list.minVal();
    }
}
