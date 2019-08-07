package Playground;

import Algorithms.LinkedList.ListAlgorithms;
import DataStructures.LinkedList.LinkedList;
import DataStructures.LinkedList.Node;

import java.util.Arrays;

public class Playground {
    public static void main(String[] args) {
        Node<Integer> list = new Node<>(1, null);
        list.next = new Node<>(2, null);
        list.next.next = new Node<>(3, null);
        list.next.next.next = new Node<>(4, null);
//        list.next.next.next.next = new Node<>(5, null);

        ListAlgorithms.print(list);
        list = ListAlgorithms.segregateByParity(list);
        ListAlgorithms.print(list);
    }
}
