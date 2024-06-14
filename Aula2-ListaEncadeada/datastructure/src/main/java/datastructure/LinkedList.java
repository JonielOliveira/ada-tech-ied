package datastructure;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    public LinkedList(String data) {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public int getLength() {
        return this.length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void print() {
        Node temp = this.head;
        System.out.println("##################################################");
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("##################################################");
    }

    public void append(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        } else {
            Node pre = head;
            Node temp = null;

            while (pre.next != tail) {
                pre = pre.next;
            }

            temp = tail;
            tail = pre;
            pre.next = null;

            length--;
            if (length == 0) {
                head = null;
                tail = null;
            }

            return temp;
        }
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        } else {
            Node temp = head;
            head = head.next;
            temp.next = null;
            length--;
            if (length == 0) {
                head = null;
                tail = null;
            }
            return temp;
        }
    }

    public void prepend(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node get(int index) {
        if (index < 0 | index >= length) {
            return null;
        } else {
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }
    }

    public boolean insert(int index, String data) {
        if (index < 0 | index > length) {
            return false;
        } else if (index == 0) {
            prepend(data);
            return true;
        } else if (index == length) {
            append(data);
            return true;
        } else {
            Node newNode = new Node(data);
            Node temp = get(index - 1);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
            return true;
        }
    }

    public boolean set(int index, String data) {
        Node temp = get(index);
        if (temp != null) {
            temp.data = data;
            return true;
        } else {
            return false;
        }
    }

    public Node remove(int index) {
        if (index < 0 | index >= length) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        } else {
            Node prev = get(index - 1);
            Node temp = prev.next;
            prev.next = temp.next;
            temp.next = null;
            length--;
            return temp;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList("F");
        list.append("B");
        list.append("X");
        list.append("D");
        list.append("Y");
        list.append("A");
        System.out.println("Lista criada com " + list.getLength() + " elemento(s):");
        list.print();

        System.out.println("Remoção do primeiro elemento: " + list.removeFirst().getData());
        System.out.println("Lista atualizada:");
        list.print();

        System.out.println("Remoção do último elemento: " + list.removeLast().getData());
        System.out.println("Lista atualizada:");
        list.print();

        System.out.println("Remoção de um elemento qualquer da lista: " + list.remove(1).getData());
        System.out.println("Lista atualizada:");
        list.print();

        list.prepend("A");
        System.out.println("Adição no início da lista:");
        System.out.println("Lista atualizada:");
        list.print();

        list.append("F");
        System.out.println("Adição no fim da lista:");
        System.out.println("Lista atualizada:");
        list.print();

        list.insert(2,"C");
        System.out.println("Adição de um elemento qualquer da lista: ");
        System.out.println("Lista atualizada:");
        list.print();

        list.set(4, "E");
        System.out.println("Alteração de um elemento qualquer da lista: ");
        System.out.println("Lista atualizada:");
        list.print();

        System.out.println("Captura um elemento qualquer da lista: " + list.get(2).getData());

        System.out.println("Cabeça da lista: " + list.getHead().getData());
        System.out.println("Calda da lista: " + list.getTail().getData());
        System.out.println("Comprimento da lista: " + list.getLength());
    }
}
