public class SwapNodes {
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

    public void swapNodes(int x, int y) {
        if (x == y) {
            return;
        }

        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y not found, do nothing
        if (currX == null || currY == null) {
            return;
        }

        // Update previous pointers
        if (prevX != null) {
            prevX.next = currY;
        }
        else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        }
        else {
            head = currX;
        }

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public static void main (String [] args) {
        SwapNodes list = new SwapNodes();

        list.addFirst(1);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);

        list.printList();

        list.swapNodes(2,5);

        list.printList();
    }

}
