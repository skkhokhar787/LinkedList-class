public class RearrangeLinkedList {
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
        if (head == null) {
            System.out.println("Linked List is Empty..");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    private Node sortList(Node head) {
        if (head == null || head.next == null) return head;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        return head;
    }

    public void rearrangeAndSortBySign() {
        if (head == null || head.next == null) {
            return;
        }

        Node negativeDummy = new Node(0);
        Node zeroDummy = new Node(0);
        Node positiveDummy = new Node(0);

        Node negTail = negativeDummy;
        Node zeroTail = zeroDummy;
        Node posTail = positiveDummy;

        Node current = head;

        while (current != null) {
            if (current.data < 0) {
                negTail.next = new Node(current.data);
                negTail = negTail.next;
            } else if (current.data == 0) {
                zeroTail.next = new Node(current.data);
                zeroTail = zeroTail.next;
            } else {
                posTail.next = new Node(current.data);
                posTail = posTail.next;
            }
            current = current.next;
        }

        // Sort each sublist
        Node sortedNeg = sortList(negativeDummy.next);
        // Node sortedZero = sortList(zeroDummy.next); // optional, since all are 0
        Node sortedPos = sortList(positiveDummy.next);

        // Merge all
        head = mergeLists(sortedNeg, zeroDummy);
        head = mergeLists(head, sortedPos);
    }

    private Node mergeLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        Node current = l1;
        while (current.next != null) {
            current = current.next;
        }
        current.next = l2;
        return l1;
    }

    public static void main(String[] args) {
        RearrangeLinkedList list = new RearrangeLinkedList();

        list.addFirst(1);
        list.addLast(3);
        list.addLast(2);
        list.addLast(-2);
        list.addLast(-1);
        list.addLast(0);
        list.addLast(0);
        list.addLast(-3);
        list.addLast(0);

        list.printList();

        list.rearrangeAndSortBySign();

        list.printList();
    }
}
