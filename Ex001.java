/**
 * Реализуем простой односвязный список. Пишем только структуру, никаких
 * методов не требуется. Напоминаем студентам структур связного списка и что
 * односвязный список представляет собой последовательность элементов, каждый
 * из которых ссылается на следующий элемент цепочки
 */
public class Ex001 {

  public static void main(String[] args) {

    List mylist = new List();
    mylist.addToStart("First");
    mylist.addToStart("Second");
    mylist.addToStart("Third");
    mylist.addToStart("Fourth");

    mylist.print();
    // System.out.println(mylist.head.value);   

  }
}

class List {
  Node head; // первый элемент списка

  public void print() {
    Node currentNode = head;
    while (currentNode != null) {
      System.out.println(currentNode.value);
      currentNode = currentNode.next;  // присваиваем следующую ноду по списку
    }

  }
  
  public void addToStart(String value) {
    Node node = new Node();
    node.value = value;
    if (head == null) head = node;
    else {
      node.next = head;
      head = node;
    }
  }
  
  
  class Node {
    Node next; // ссылка на следующий элемент списка
    String value;
  }
}

