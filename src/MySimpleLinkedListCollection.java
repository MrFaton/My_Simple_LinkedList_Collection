/**
 * Created by root on 10.08.2014.
 */
public class MySimpleLinkedListCollection {
    public static void main(String[] args) {
        Node tail;
        tail=new Node(0,null);
        tail=new Node(1,tail);
        tail=new Node(2,tail);
        tail=new Node(3,tail);
        System.out.println("Основной список: "+printToString(tail));
//        System.out.println("Добавляем в конец итеративно: "+printToString(addToHeadIter(7, tail)));
//        System.out.println("Добавляем в конец рекурсивно: "+printToString(addToHeadRec(9, tail)));
        System.out.println("Вставляем в позицию значение итеративно: "+printToString(inseartInPositionIter(5, 2, tail)));
    }

    public static Node addToHeadIter(int value, Node tail){
        Node currentItemIter=tail; //Такая же ссылка на список как и tail, представляет собой маленький блочёк значёк+ссылка на другой блок
        while (currentItemIter.next!=null){
            currentItemIter=currentItemIter.next;
        }
        currentItemIter.next=new Node(value,null);
        return tail;
    }

    public static Node addToHeadRec(int value, Node tail){
        Node currentItemRec=tail;
        if(currentItemRec==null){
            currentItemRec.next=new Node(value,null);
        } else {
            currentItemRec=currentItemRec.next;
            addToHeadIter(value,currentItemRec);
        }
        return tail;
    }

    public static Node inseartInPositionIter(int value, int position, Node tail){
        Node currentItemIter=tail;
        if (position==0){
            tail=new Node(value, tail);
        } else{
            for (int i=1; i<position; i++){
                currentItemIter=currentItemIter.next;
            }
            currentItemIter.next=new Node(value, currentItemIter.next);
        }
        return tail;
    }

    public static String printToString(Node tail){
        String result="";
        while (tail!=null){
            result+=tail.value+"->";
            tail=tail.next;
        }
        return result+"*";
    }
}
