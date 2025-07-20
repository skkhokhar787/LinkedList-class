public static class Palindrome {
    Node head;
   // private boolean data;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
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
        Palindrome.Node currNode = head;

        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public Node reverse() {
        if (head == null || head.next == null) {
            return null;
        }
        Node perNode = head;
        Node currNode = head.next;
        while (currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = perNode;

            // update
            perNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = perNode;
        return perNode;
    }

    public boolean isPalindrome(Palindrome list) {
        if (head == null || head.next == null) {
            return true;
        }

        Node original = head;
        Node reversed = list.reverse();

        while (original != null && reversed != null) {
            if (original.data != reversed.data) {
                return false;
            }
            original = original.next;
            reversed = reversed.next;
        }

        return true;
    }
}

public static void main(String[] args) {
    Palindrome list = new Palindrome();

    list.addFirst(1);
    list.addLast(2);
    list.addLast(1);

    System.out.println(list.isPalindrome(list));

}
