/**
 * Created by Faton on 10.08.2014.
 */
public class MySimpleLinkedListCollection {
    public static void main(String[] args) {
        Node tail;
        tail = new Node(0, null);
        tail = new Node(1, tail);
        tail = new Node(2, tail);
        tail = new Node(3, tail);

        Node tailB;
        tailB = new Node(0, null);
        tailB = new Node(1, tailB);
        tailB = new Node(5, tailB);
        tailB = new Node(3, tailB);

        Node tailC;
        tailC = listCreator(5, 8, 9, 7, 6);

//        System.out.println("Основной список: " + printToString(tail));
//        System.out.println("Добавляем в голову итеративно: "+printToString(addToHeadIter(77, tail)));
//        System.out.println("Добавляем в голову рекурсивно: " + printToString(addToHeadRec(99, tail)));
//        System.out.println("Вставляем в позицию значение итеративно: "+printToString(inseartInPositionIter(55, 2, tail)));
//        System.out.println("Вставляем в позицию значение рекурсивно: "+printToString(inseartInPositionRec(122, 3, tail)));
//        System.out.println("Удалить голову итеративно: "+printToString(removeHeadIter(tail)));
//        System.out.println("Удалить голову рекурсивно: " + printToString(removeHeadRec(tail)));
//        System.out.println("Удалить удалить позицию итеративно: " + printToString(removePositionIter(0, tail)));
//        System.out.println("Удалить удалить позицию рекурсивно: " + printToString(removePositionRec(2, tail)));
//        System.out.println("Хвост А: " + printToString(tail)+"\nХвост В: "+printToString(tailB)+"\nРезультат сравнения: "+isEqualRec(tail, tailB));
//        System.out.println("Длина списка "+printToString(tail)+" равна "+length(tail)+" единиц(ы)");
        System.out.println("Сумма всех элементов списка " + printToString(tailC) + " равна " + summOfList(tailC));
//        System.out.println("Максимальное значение среди всех элементов списка " + printToString(tail) + " равно " + maxItem(tail));
//        System.out.println("Создание списка с помощью цикла " + printToString(tailC));
    }

    public static Node addToHeadIter(int value, Node tail) {
        Node currentItemIter = tail; //Такая же ссылка на список как и tail, представляет собой маленький блочёк значёк+ссылка на другой блок
        while (currentItemIter.next != null) {
            currentItemIter = currentItemIter.next;
        }
        currentItemIter.next = new Node(value, null);
        return tail;
    }

    public static Node addToHeadRec(int value, Node tail) {
        if (tail.next == null) {
            tail.next = new Node(value, null);
        } else {
            addToHeadRec(value, tail.next);
        }
        return tail;
    }

    public static Node inseartInPositionIter(int value, int position, Node tail) {
        Node currentItemIter = tail;
        if (position == 0) {
            tail = new Node(value, tail);
        } else {
            for (int i = 1; i < position; i++) {
                currentItemIter = currentItemIter.next;
            }
            currentItemIter.next = new Node(value, currentItemIter.next);
        }
        return tail;
    }

    public static Node inseartInPositionRec(int value, int position, Node tail) {
        tail = inseartInPositionInnerRec(1, value, position, tail);
        return tail;
    }

    public static Node removeHeadIter(Node tail) {
        Node currentItemIter = tail;
        Node previousItemIter = tail;
        while (currentItemIter.next != null) {
            previousItemIter = currentItemIter;
            currentItemIter = currentItemIter.next;
        }
        previousItemIter.next = null;
        return tail;
    }

    public static Node removeHeadRec(Node tail) {
        Node prevElement = tail;
        tail = removeHeadInnerRec(prevElement, tail);
        return tail;
    }

    public static Node removePositionIter(int position, Node tail) {
        Node currentItemIter = tail;
        if (position == 0) {
            tail = tail.next;
        } else {
            int i = 0;
            while (i < position - 1) {
                i++;
                currentItemIter = currentItemIter.next;
            }
            currentItemIter.next = currentItemIter.next.next;
        }
        return tail;
    }

    public static Node removePositionRec(int position, Node tail) {
        if (position == 0) {
            tail = tail.next;
        } else {
            removePositionInnerRec(0, position, tail);
        }
        return tail;
    }

    public static Boolean isEqualRec(Node tail, Node tailB) {
        if (tail != null && tailB != null) {
            return (tail.value == tailB.value) && isEqualRec(tail.next, tailB.next);
        } else {
            return tail == tailB;
        }
    }

    public static int length(Node tail) {
        return (tail == null) ? 0 : 1 + length(tail.next);
    }

    public static int summOfList(Node tail) {
        return (tail == null) ? 0 : (tail.value + summOfList(tail.next));
    }

    public static int maxItem(Node tail) {
        return (tail == null) ? 0 : Math.max(tail.value, maxItem(tail.next));
    }

//    Внутренние методы...

    public static Node inseartInPositionInnerRec(int i, int valueInner, int positionInner, Node tailInner) {
        if (positionInner == 0) {
            tailInner = new Node(valueInner, tailInner);
        } else if (i == positionInner) {
            tailInner.next = new Node(valueInner, tailInner.next);
        } else {
            i++;
            inseartInPositionInnerRec(i, valueInner, positionInner, tailInner.next);
        }
        return tailInner;
    }

    public static Node removeHeadInnerRec(Node prevElement, Node tailInner) {
        if (tailInner.next == null) {
            prevElement.next = null;
        } else {
            prevElement = tailInner;
            removeHeadInnerRec(prevElement, tailInner.next);
        }
        return tailInner;
    }

    public static Node removePositionInnerRec(int i, int positionInner, Node tailInner) {
        if (i < positionInner - 1) {
            i++;
            removePositionInnerRec(i, positionInner, tailInner.next);
        } else {
            tailInner.next = tailInner.next.next;
        }
        return tailInner;
    }

    public static String printToString(Node tail) {
        String result = "";
        while (tail != null) {
            result += tail.value + "->";
            tail = tail.next;
        }
        return result + "*";
    }

    public static Node listCreator(int... values) {
        Node tailToCreate = null;
        for (int k = values.length - 1; k >= 0; k--) {
            tailToCreate = new Node(values[k], tailToCreate);
        }
        return tailToCreate;
    }
}
