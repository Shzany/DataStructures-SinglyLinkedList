class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class SinglyLinkedList {
    Node head;
    Node tail;
    SinglyLinkedList(){this.head = null;this.tail = null;}
    void insertAtHead(int data){
        Node newNode = new Node(data);
        if(head == null){            //Liste boşsa (head boş oradan anlıyoruz) head yeni elamanımız oluyor
            head = newNode;
            tail = newNode;
        }else{                       //Liste boş değilse
            newNode.next = head;
            head = newNode;
        }
    }
    void insertAtEnd(int data){
        Node newNode = new Node(data);
        if (tail == null){           //Liste boşsa bu seferde headden anlayabilirdik ama tail de bu cevabı bize verir
            tail = newNode;
            head = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    void printList(){               //Tüm listeyi yazdır
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
    }
    void deleteAtHead() {
        if (head == null) {
            System.out.println("Liste boş, silinecek eleman yok!");
            return;
        }
        head = head.next;
        if (head == null) { // Eğer liste tek elemanlıysa ve silindiyse, tail'i de null'a çek
            tail = null;
        }
    }

    void deleteAtEnd() {
        if (head == null) {
            System.out.println("Liste boş, silinecek eleman yok!");
            return;
        }
        if(head == tail){ // Liste tek elemanlıysa
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
    }

    void deleteAtAnywhere(int key) {
        if (head == null) {
            System.out.println("Liste boş, silinecek eleman yok!");
            return;
        }
        if (head.data == key) { // Eğer silinecek düğüm head ise
            deleteAtHead();
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Listede " + key + " değerine sahip bir eleman bulunamadı.");
            return;
        }
        temp.next = temp.next.next;
        if (temp.next == null) { // Silinen son düğümse, tail'i güncelle
            tail = temp;
        }
    }
    
}
public class LinkedList_SinglyLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(7);
        list.insertAtHead(10);
        list.insertAtHead(9);
        list.insertAtHead(8);
        list.insertAtEnd(7);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.insertAtHead(10);
        list.insertAtHead(9);
        list.insertAtHead(8);
        list.insertAtEnd(7);
        list.insertAtEnd(5);
        list.insertAtEnd(6);
        list.insertAtEnd(7);
        list.deleteAtHead();
        list.deleteAtEnd();
        list.deleteAtAnywhere(5);
        list.printList();


        


    }
}