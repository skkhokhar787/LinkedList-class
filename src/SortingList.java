public class SortingList {
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

    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void sortList() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            Node prev = null;
            Node curr = head;
            swapped = false;

            while (curr.next != null) {
                if (curr.data > curr.next.data) {
                    // Swap nodes
                    Node temp = curr.next;
                    curr.next = temp.next;
                    temp.next = curr;

                    if (prev == null) {
                        head = temp;
                    } else {
                        prev.next = temp;
                    }

                    swapped = true;
                    prev = temp;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
        } while (swapped);
    }

    public static void main (String [] args) {
        SortingList list = new SortingList();

        list.addFirst(5);
        list.addLast(3);
        list.addLast(7);
        list.addLast(1);

        list.printList();

        list.sortList();

        list.printList();
    }
}
