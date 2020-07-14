interface LinkedList {
    void insert(Warrior warrior);

    String toString();
}

public class SortedDoublyLinkedList implements LinkedList {

    private Node header;
    private Node trailer;

    public SortedDoublyLinkedList() {
        this.header = null;
        this.trailer = null;
    }

    public String toString() {
        Node T = header;
        String listContents = "";
        while (T != null) {
            listContents += (T.toString() + " ");
            T = T.next;
        }
        listContents += " ";
        return listContents;
    }

    private static class Node {
        Node next;
        Node prev;
        Warrior warrior;

        public Node(Warrior warrior) {
            this.warrior = warrior;
            this.next = next;
        }

        @Override
        public String toString() {
            return this.warrior.toString();
        }
    }

    @Override
    public void insert(Warrior warrior) {
        if (this.header == null) {
        this.header = new Node(warrior);
        this.trailer = header;
        return;
        }
        Node temporary = new Node (warrior);
        Node move = this.header;
        Node prevMove = this.header;
        while (move != null)
        {
            //implemented the sort here, it sorts as the mosnter information is enetered
            if (move.warrior.getSpeed() < warrior.getSpeed())
            {
                temporary.next = move;
                if (prevMove != this.header)
                {
                    prevMove.next = temporary;
                }else
                {
                    this.header = temporary;
                }
                return;
            }
            prevMove = move;
            move = move.next;
        }
        this.trailer.next = temporary;
        this.trailer = this.trailer.next;
    }
    }

class Warrior {
    private String name;
    private int speed;
    private int strength;
    private int hp;

    public Warrior(String name, int speed, int str, int hp) {
        this.name = name;
        this.speed = speed;
        this.strength = str;
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public int getSpeed() {
        return this.speed;
    }

    public int getStrength() {
        return this.strength;
    }

    public int getHp() {
        return this.hp;
    }

    public String toString() {
        return this.name + "(" +
                this.speed + ")";
    }
}

class LinkedListDriver {
    public static void main(String[] args) {
        LinkedList list = new SortedDoublyLinkedList();
        System.out.println(list);
        Warrior krogg = new Warrior("Krogg", 30, 50, 200);
        list.insert(krogg);
        System.out.println(list);
        Warrior gurkh = new Warrior("Gurkh", 40, 45, 180);
        list.insert(gurkh);
        System.out.println(list);
        Warrior brynn = new Warrior("Brynn", 45, 40, 190);
        list.insert(brynn);
        System.out.println(list);
        Warrior dolf = new Warrior("Dolf", 20, 65, 210);
        list.insert(dolf);
        System.out.println(list);
        Warrior zuni = new Warrior("Zuni", 50, 35, 170);
        list.insert(zuni);
        System.out.println(list);
    }
}