public class CheckCycle {
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

    public void makeCycle() {
        if (head == null) {
            return;
        }
        Node cycle = head;
        Node temp = null;
        while (cycle != null) {
            temp = cycle;
            cycle = cycle.next;
        }
        temp.next = head.next;
    }

    public boolean detectCycle() {
        if (head == null) {
            return false;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void removeCycle() {
        if (head == null) {
            return;
        }
        Node slow = head, fast = head;

        // Detect cycle
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) {
            return;
        }

        // Find start of cycle
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        // Remove cycle
        prev.next = null;
    }

    public static void main(String[] args) {
        CheckCycle list = new CheckCycle();

        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        // list.addLast(2);

        list.printList();
        list.makeCycle();
        // list.removeCycle();
        System.out.println(list.detectCycle());
        list.removeCycle();
        list.printList();
    }
}
