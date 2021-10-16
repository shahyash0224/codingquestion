package blind75.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DetectLoop {
    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();

            if (slow == fast)
                return true;
        }

        return false;
    }

    private static Node buildLoopedList() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node listHead = null;
        Node temp;
        for (int i = 0; i < n; i++) {
            if (listHead == null) {
                listHead = new Node(Integer.parseInt(br.readLine()));
            } else {
                temp = listHead;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                }
                temp.setNext(new Node(Integer.parseInt(br.readLine())));
            }
        }
        int loopIndex = Integer.parseInt(br.readLine());
        if (loopIndex < n) {
            Node loopNode = listHead;
            for (int i = 0; i <= loopIndex; i++) {
                loopNode = loopNode.getNext();
            }
            temp = listHead;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(loopNode);
        }
        return listHead;
    }

    public static void main(String[] s) throws NumberFormatException, IOException {
        Node loopedList = buildLoopedList();
        System.out.println(hasCycle(loopedList));
    }
}

class Node {
    private int val;
    private Node next;

    Node(int x) {
        setVal(x);
        setNext(null);
    }

    int getVal() {
        return val;
    }

    void setVal(int val) {
        this.val = val;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node next) {
        this.next = next;
    }
}
