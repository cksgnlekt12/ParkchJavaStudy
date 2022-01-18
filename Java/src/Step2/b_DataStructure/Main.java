package Step2.b_DataStructure;

import Step2.b_DataStructure.Struct.MyArray;
import Step2.b_DataStructure.Struct.MyArrayStack;
import Step2.b_DataStructure.Struct.MyLinkedList;
import Step2.b_DataStructure.Struct.MyListQueue;

public class Main {
    public static void main (String[] args){
        /** [1] 선형 구조 (Linear) **/
        /* 한 줄로 자료를 관리하는 구조 */

        MyArray array = new MyArray();
        array.addElement(10);
        array.addElement(20);
        array.addElement(30);
        array.insertElement(1, 50);
        array.printAll();

        System.out.println("===============");
        array.removeElement(1);
        array.printAll();
        System.out.println("===============");

        array.addElement(70);
        array.printAll();
        System.out.println("===============");
        array.removeElement(1);
        array.printAll();

        System.out.println("===============");
        System.out.println(array.getElement(2));
        System.out.println("------------------------------------------------------------");



        /** [2] LinkedList 구조 (Linear) **/
        /* 한 객체가 다음 객체의 정보를 저장하고 있는 구조 */
        MyLinkedList list = new MyLinkedList();
//        MyListNode list2 = list.addElement("A");
//        System.out.println(list.getNode(0));
//        System.out.println(list.getElement(0));
//        MyListNode list3 = list.addElement("B");
//        System.out.println(list.getNode(1));
//        System.out.println(list3);
        list.addElement("A");
        list.addElement("B");
        list.addElement("C");
        list.printAll();
        list.insertElement(3, "D");
        list.printAll();
        list.removeElement(0);
        list.printAll();
        list.removeElement(1);
        list.printAll();

        list.insertElement(0, "A-1");
        list.printAll();
        System.out.println(list.getSize());

        list.removeElement(0);
        list.printAll();
        System.out.println(list.getSize());

        list.removeAll();
        list.printAll();
        list.addElement("A");
        list.printAll();
        System.out.println(list.getElement(0));
        list.removeElement(0);

        System.out.println("------------------------------------------------------------");

        /** [3] Stack 은 맨 위의 자료만 삽입,삭제가 가능 **/
        MyArrayStack stack = new MyArrayStack(3);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.printAll();

        System.out.println("top element is " + stack.pop());
        stack.printAll();
        System.out.println("stack size is " + stack.getSize());

        System.out.println("------------------------------------------------------------");
        /** [4] Queue **/
        /* 먼저 들어와서 먼저 나가는 구조 */
        MyListQueue listQueue = new MyListQueue();
        listQueue.enQueue("A");
        listQueue.enQueue("B");
        listQueue.enQueue("C");
        listQueue.enQueue("D");
        listQueue.enQueue("E");

        System.out.println(listQueue.deQueue());
        listQueue.printAll();

    }
}
