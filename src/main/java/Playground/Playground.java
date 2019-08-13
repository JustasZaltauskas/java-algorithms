package Playground;

import DataStructures.LinkedList.Node;

import java.util.ArrayList;

public class Playground {
    public static void main(String[] args) {
        Node<Integer> list = new Node(1, null);
        list.next = new Node(2, null);
        list.next.next = new Node(3, null);
        list.next.next.next = new Node(4, null);
    }
}
