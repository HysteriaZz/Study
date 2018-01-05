import simplesort.ArrayBub;
import simplesort.ArrayIns;
import simplesort.ArraySel;
import stackqueue.BracketChecker;
import stackqueue.PriorityQ;

/**
 * Created by KaiLin.Guo on 2017-08-14.
 */
public class MyDataStructureApp {
    public static void main(String[] args){
        /*-----------------------------------------冒泡排序Begin-----------------------------------------------------*/
        ArrayBub arrayBub = new ArrayBub(50);
        arrayBub.insert(77L);
        arrayBub.insert(99L);
        arrayBub.insert(44L);
        arrayBub.insert(55L);
        arrayBub.insert(22L);
        arrayBub.insert(88L);
        arrayBub.insert(11L);
        arrayBub.insert(00L);
        arrayBub.insert(66L);
        arrayBub.insert(33L);
        arrayBub.display();
        arrayBub.bubbleSort();
        arrayBub.display();
        /*-----------------------------------------冒泡排序End-------------------------------------------------------*/

        /*-----------------------------------------选择排序Begin-----------------------------------------------------*/
        ArraySel arraySel = new ArraySel(50);
        arraySel.insert(77L);
        arraySel.insert(99L);
        arraySel.insert(44L);
        arraySel.insert(55L);
        arraySel.insert(22L);
        arraySel.insert(88L);
        arraySel.insert(11L);
        arraySel.insert(00L);
        arraySel.insert(66L);
        arraySel.insert(33L);
        arraySel.display();
        arraySel.selectionSort();
        arraySel.display();
        /*-----------------------------------------选择排序End-------------------------------------------------------*/

        /*-----------------------------------------插入排序Begin-----------------------------------------------------*/
        ArrayIns arrayIns = new ArrayIns(50);
        arrayIns.insert(77L);
        arrayIns.insert(99L);
        arrayIns.insert(44L);
        arrayIns.insert(55L);
        arrayIns.insert(22L);
        arrayIns.insert(88L);
        arrayIns.insert(11L);
        arrayIns.insert(00L);
        arrayIns.insert(66L);
        arrayIns.insert(33L);
        arrayIns.display();
        arrayIns.insertionSort();
        arrayIns.display();
        /*-----------------------------------------插入排序End-------------------------------------------------------*/

        /*-----------------------------------------栈【分配符匹配】Begin---------------------------------------------*/
        BracketChecker bracketChecker = new BracketChecker("a{b(c[d)f}");
        bracketChecker.check();
        /*-----------------------------------------栈【分配符匹配】End-----------------------------------------------*/

        /*-----------------------------------------优先级队列Begin---------------------------------------------------*/
        PriorityQ priorityQ = new PriorityQ(5);
        priorityQ.insert(30);
        priorityQ.insert(50);
        priorityQ.insert(10);
        priorityQ.insert(40);
        priorityQ.insert(20);
        while (!priorityQ.isEmpty()){
            long item = priorityQ.remove();
            System.out.print(item + " ");
        }
        /*-----------------------------------------优先级队列End-------------------------------------------------------*/
    }
}
