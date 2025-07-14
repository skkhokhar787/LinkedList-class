public class ReverseLink {
    ReverseLink.Node head;

    public static class Node {
        String data;
        ReverseLink.Node next;

        Node(String data) {
            this.data = data;
            this.next = null;

        }
    }
    public void addFirst (String data) {
        ReverseLink.Node newNode = new ReverseLink.Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast (String data) {
        ReverseLink.Node newNode = new ReverseLink.Node(data);

        if (head == null) {
            head = newNode;

            return;
        }
        ReverseLink.Node lastNode = head;

        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }

        lastNode.next = newNode;

    }
    public void printList() {
        ReverseLink.Node currNode = head;


        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }

        System.out.println("null");
    }


    // Iterative Method
    public void reverseIterate () {
        if (head == null || head.next == null) {
            return;
        }
        Node perNode = head;
        Node currentNode = head.next;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            currentNode.next = perNode;

            // Update
            perNode = currentNode;
            currentNode = nextNode;
        }
        head.next = null;
        head = perNode;
    }

    // Recursive method
    public Node reverseRecursive (Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static void main (String [] args) {
        ReverseLink list = new ReverseLink();

        list.addFirst("a");
        list.addFirst("is");
        list.printList();
        list.addLast("list");
        list.printList();
        list.addFirst("This");
        list.printList();

        list.head = list.reverseRecursive(list.head);
        list.printList();
    }
}
