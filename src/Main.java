// Written by Igor Kharkovskiy - 321228215 & Yarden Algoar - 319096103

import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String args[])
    {
        LinkedList creature = Math.random() > 0.5 ? initializeSnake(): initializeSnail();
        printList(creature);
    }

    private static LinkedList initializeSnake() {
        LinkedList snake = new LinkedList();

        Random rand = new Random();

        while (true) {
            float chance = rand.nextFloat();
            if (chance <= 0.01f)
            {
                break;
            } else {
                snake.createNewNode();
            }
        }

        return snake;
    }

    private static LinkedList initializeSnail() {
        LinkedList snail = new LinkedList();
        Node specialNode;

        Random rand = new Random();

        while (true) {
            float chance = rand.nextFloat();
            if (chance <= 0.015f)
            {
                specialNode = new Node(rand.nextInt(20));
                snail.push(specialNode);
                break;
            } else {
                snail.createNewNode();
            }
        }

        while (true) {
            float chance = rand.nextFloat();
            if (chance <= 0.02f)
            {
                Node new_node = new Node(rand.nextInt(20));

                snail.push(new_node);

                new_node.next = specialNode;

                break;
            } else {
                snail.createNewNode();
            }
        }

        return snail;
    }

    public static Node SnakeorSnail(LinkedList creature) {
        HashSet<Node> s = new HashSet<Node>();
        Node current = creature.head;
        while (current != null) {
            // If we have already has this node
            // in hashmap it means their is a cycle
            // (Because you we encountering the
            // node second time).
            if (s.contains(current))
                return current;

            // If we are seeing the node for
            // the first time, insert it in hash
            s.add(current);

            current = current.next;
        }

        return null;
    }

    public static void printList(LinkedList list)
    {
        Node specialNode = SnakeorSnail(list);
        if (specialNode != null) {
            int counter = 0;
            Node tnode = list.head;
            while (counter != 2)
            {
                if (tnode.next != specialNode) {
                    System.out.print(tnode.data+"->");
                } else {
                    counter++;
                    System.out.print(tnode.data+"↓↑");
                }
                tnode = tnode.next;
            }

        } else {
            Node tnode = list.head;
            while (tnode != null)
            {
                System.out.print(tnode.data+"->");
                tnode = tnode.next;
            }
            System.out.println("NULL");
        }
    }
}


//Node class
class Node
{
    int data;
    Node next;
    Node(int d)
    {
        data = d;
        next = null;
    }
}

//Linked list class
class LinkedList
{
    Node head;    //Head of list

    //Inserts a new node at the front of the list
    public void push(Node new_node)
    {
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }
    }

    public void createNewNode() {
        Random rand = new Random();

        // Create a new node with given data
        Node new_node = new Node(rand.nextInt(20));
        new_node.next = null;

        // If the Linked List is empty,
        // then make the new node as head
        if (head == null) {
            head = new_node;
        }
        else {
            // Else traverse till the last node
            // and insert the new_node there
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = new_node;
        }
    }
}



