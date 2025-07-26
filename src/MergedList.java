public class MergedList {
    Node head;

    public static class Node {
        int data;
        Node next;

        Node (int data) {
            this.data = data;
            this.next = null;

        }
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
        System.out.println("Null");
    }

    public static MergedList mergeLists(MergedList list1, MergedList list2) {
        MergedList result = new MergedList();
        Node dummy = new Node(0);
        Node tail = dummy;

        Node l1 = list1.head;
        Node l2 = list2.head;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                tail.next = new Node(l1.data);
                l1 = l1.next;
            } else {
                tail.next = new Node(l2.data);
                l2 = l2.next;
            }
            tail = tail.next;
        }

        while (l1 != null) {
            tail.next = new Node(l1.data);
            l1 = l1.next;
            tail = tail.next;
        }

        while (l2 != null) {
            tail.next = new Node(l2.data);
            l2 = l2.next;
            tail = tail.next;
        }

        result.head = dummy.next;
        return result;
    }

    public static void main (String [] args) {
        MergedList list1 = new MergedList();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);

        MergedList list2 = new MergedList();
        list2.addLast(2);
        list2.addLast(4);
        list2.addLast(6);

        MergedList merged = MergedList.mergeLists(list1, list2);
        merged.printList();  // Output: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> Null
    }
}
