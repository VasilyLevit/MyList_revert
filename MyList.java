/* Простой односвязный список - последовательность элементов, каждый
из которых ссылается на следующий элемент цепочки */
public class MyList {

  public static void main(String[] args) {

    List mylist = new List();
    mylist.addFirst("First");
    mylist.addFirst("Second");
    mylist.addFirst("Third");
    mylist.addFirst("Fourth");
    mylist.addFirst("Fifth");
    mylist.print();
    System.out.println();

    // System.out.println(mylist.contains("Fourth")); // проверка наличия элемента
    // System.out.println();

    // mylist.removeFirst(); //  удаление первого элемента списка
    mylist.revert(); // разворот списка
    mylist.print();
    // System.out.println(mylist.head.value);   

  }
}

/**
 * Односвязный список
 */
class List {
  
  Node head;

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

  public void revert() {
    if(head != null && head.next != null) { // сключаем разворот для списка меньше 2х элементов
      revert(head.next, head); // запускаем со второго элемента списка
    }
  }
  
  /**
   * Метод разворота списка
   * @param currentNode ссылка на текущий элемент списка
   * @param previousNode ссылка на предыдущий элемент списка
   */
  private void revert(Node currentNode, Node previousNode) {
    if (currentNode.next == null) {
      head = currentNode;
    } else {
      revert(currentNode.next, currentNode); // рекурсивно обходим список до последнего элемента
    }
    currentNode.next = previousNode;
    previousNode.next = null; // т.к. рекурсия начинается со второго элемента списка, предыдущий (первый) не меняется
  }
  
  
  class Node {
    Node next; // ссылка на следующий элемент списка
    String value;
  }
}

