public class IntersectionPoint {
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

    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) {
            return null;
        }

        Node p1 = headA;
        Node p2 = headB;

        // When one pointer hits the end, redirect it to the head of the other list
        while (p1 != p2) {
            p1 = (p1 == null) ? headB : p1.next;
            p2 = (p2 == null) ? headA : p2.next;
        }

        // Either both are null (no intersection), or both at intersection node
        return p1;
    }

    public static void main(String[] args) {
        IntersectionPoint list1 = new IntersectionPoint();
        IntersectionPoint list2 = new IntersectionPoint();

        // Build list1: 1 -> 2 -> 3 -> 6 -> 7 -> null
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list1.addLast(6);
        list1.addLast(7);

        // Build list2: 4 -> 5 -> [intersect at node with value 6]
        list2.addLast(4);
        list2.addLast(5);

        // Get reference to node with value 6 in list1
        Node curr = list1.head;
        while (curr != null && curr.data != 6) {
            curr = curr.next;
        }

        // Point list2's tail to this node
        Node tail2 = list2.head;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        tail2.next = curr; // Now lists intersect

        // Print lists (visually they may look misleading because they share a tail)
        list1.printList();
        list2.printList();

        // Test intersection finder
        Node intersection = list1.getIntersectionNode(list1.head, list2.head);
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.data);
        } else {
            System.out.println("No intersection");
        }
    }
}
