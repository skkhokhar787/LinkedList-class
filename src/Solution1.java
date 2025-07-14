public class Solution1 {
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
        Solution1.Node newNode = new Solution1.Node(data);
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

    public void printList() {
        Solution1.Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;

        }

        System.out.println("null");
    }

    public int printIdx (int target) {
        Node currNode = head;
        int idx = 0;

        while (currNode != null) {
            if (currNode.data == target) {
                return idx;
            }
            currNode = currNode.next;
            idx++;
        }
        return -1;
    }

    public static void main (String [] args) {
        Solution1 list = new Solution1();
        list.addFirst(1);
        list.addLast(5);
        list.addLast(7);
        list.addLast(3);
        list.addLast(8);
        list.addLast(2);
        list.addLast(3);

        list.printList();

        int idx = list.printIdx(7);
        System.out.println("7 is at index "+idx);

    }
}
