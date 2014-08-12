/**
 * Created by Faton on 10.08.2014.
 */
public class MySimpleLinkedListCollection {
    public static void main(String[] args) {
        Node tail;
        tail=new Node(0,null);
        tail=new Node(1,tail);
        tail=new Node(2,tail);
        tail=new Node(3,tail);
        System.out.println("Основной список: "+printToString(tail));
//        System.out.println("Добавляем в голову итеративно: "+printToString(addToHeadIter(7, tail)));
        System.out.println("Добавляем в голову рекурсивно: "+printToString(addToHeadRec(9, tail)));
//        System.out.println("Вставляем в позицию значение итеративно: "+printToString(inseartInPositionIter(5, 2, tail)));
//        System.out.println("Вставляем в позицию значение рекурсивно: "+printToString(inseartInPositionRec(12, 1, tail)));
//        System.out.println("Удалить последнюю позицию итеративно: "+printToString(removeHeadIter(tail)));
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
        return tail.next==null ? (tail.next=new Node(value, null)) : (tail=tail.next);
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

    public static Node inseartInPositionRec(int value, int position, Node tail){
        Node currentItemRec=tail;
        int i=1; //НЕ верно, работать не будет!
        if (position==0){
            tail=new Node(value, tail);
        } else if(i==position) {
            currentItemRec.next=new Node(value, currentItemRec.next);
        } else {
            i++;
            currentItemRec=currentItemRec.next;
            inseartInPositionRec(value, position, currentItemRec);
        }
        return tail;
    }

    public static Node removeHeadIter(Node tail){
        Node currentItemIter=tail;
        Node previousItemIter=tail;
        while (currentItemIter.next!=null){
            previousItemIter=currentItemIter;
            currentItemIter=currentItemIter.next;
        }
        previousItemIter.next=null;
        return tail;
    }

    public static Node removeHeadRec(Node tail){
        Node currentItemRec=tail;
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
