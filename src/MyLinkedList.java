/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-08
 * Time:19:48
 **/

class Node{
    private int data;
    private Node prev;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
public class MyLinkedList {
        public Node head;
        public Node tail;

    public MyLinkedList() {
        this.head = head;
        this.tail = tail;
    }

    public void addFirst(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            this.tail = node;
return;
        }
        node.setNext(this.head);
        this.head.setPrev(node);
        this.head = node;

    }

    public void display(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.getData()+"   ");
            cur = cur.getNext();
        }
        System.out.println();
    }

    public void addLast(int data){
        Node node = new Node(data);
        if (this.head == null){
            this.head = node;
            this.tail = node;
            }else {
            this.tail.setNext(node);
            node.setPrev(this.tail);
            this.tail = node;
        }

    }

    public int size(){
        Node cur  = this.head;
        int count = 0;
        while(cur != null){
            count++;
            cur = cur.getNext();
        }
        return count;
    }
    public boolean contains(int key){
        Node cur = this.head;
        while ( cur != null){
            if (cur.getData() == key){
                return true;
            }
            cur = cur.getNext();
        }
        return false;
    }
    private boolean checkPos(int pos){
        if (pos < 0 || pos > size()){
            return true;
        }
        return false;
    }
    private Node searchPos(int pos){
        Node seat = this.head;
        while(pos > 0){
            seat = seat.getNext();
            pos--;
        }
        return seat;
    }
    public void addIndex(int pos,int data){
        if (checkPos(pos)){
            return;
        }
        if (pos == 0){
            addFirst(pos);
            return;
        }
        if (pos == size()){
            addLast(data);
            return;
        }
        Node cur = searchPos(pos);
        Node node = new Node(data);
        node.setNext(cur);
        node.setPrev(cur.getPrev());
        cur.getPrev().setNext(node);
        cur.setPrev(node);


    }

    public int remove(int toRemove){
        Node cur = this.head;
        if (this.head == null){
            return -1;
        }
        if (this.head.getData() == toRemove){
            this.head = this.head.getNext();
            this.head.setPrev(null);
        }else {
            while(cur != null){
                if (cur.getNext().getData() == toRemove){
                    cur.getPrev().setNext(cur.getNext());
                    cur.getNext().setPrev(cur.getPrev());

                }
            }
        }
        return -1;
    }
}
