/**
 * Реализуем простой односвязный список. Пишем только структуру, никаких
 * методов не требуется. Напоминаем студентам структур связного списка и что
 * односвязный список представляет собой последовательность элементов, каждый
 * из которых ссылается на следующий элемент цепочки
 */
public class Ex001 {

  public static void main(String[] args) {

    List mylist = new List();
    mylist.addFirst("First");
    mylist.addFirst("Second");
    mylist.addFirst("Third");
    mylist.addFirst("Fourth");
    mylist.print();
    System.out.println();

    System.out.println(mylist.contains("Fourth"));
    System.out.println();

    mylist.removeFirst();
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
  
  public boolean contains(String string) {
    Node currentNode = head;
    while (currentNode != null) {
      if (currentNode.value.equals(string)) return true;
      currentNode = currentNode.next;  // присваиваем следующую ноду по списку
    }
    return false;
  }

  public void addFirst(String value) {
    Node node = new Node();
    node.value = value;
    if (head == null) head = node;
    else {
      node.next = head;
      head = node;
    }
  }

  public void removeFirst() {
    if (head != null) {
      head = head.next;
    }
  }
  
  
  class Node {
    Node next; // ссылка на следующий элемент списка
    String value;
  }
}

