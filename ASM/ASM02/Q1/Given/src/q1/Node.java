package q1;

class Node {

    Order info;
    Node next;

    Node(Order x, Node p) {
        info = x;
        next = p;
    }

    Node(Order x) {
        this(x, null);
    }
}
