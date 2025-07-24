public class Swap {
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
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("Null");
    }

    public Node swapPairs (Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node first = head;
        Node sec = head.next;
        Node perv = null;

        while (first != null && sec != null) {
            Node third = sec.next;

            sec.next = first;
            first.next = third;

            if (perv != null) {
                perv.next = sec;
            }else {
                head = sec;
            }
            // Update
            perv = first;
            first = third;
            if (third != null) {
                sec = third.next;
            }else {
                sec = null;
            }
        }

        return head;
    }

    public static void main (String [] args) {
        Swap list = new Swap();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        list.printList();

        list.head = list.swapPairs(list.head);

        list.printList();
    }
}
