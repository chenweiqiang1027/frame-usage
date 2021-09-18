package datastructure.yan;

public class StaticLinkedList {
    private static final int MAX_SIZE = 12;
    private static ElementType[] sl = new ElementType[MAX_SIZE];

    //对静态链表进行初始化
    private void initSL(ElementType[] sl) {
        for (int i = 0; i < MAX_SIZE - 1; i++) {
            ElementType elementType = new ElementType();
            elementType.setData('-');
            elementType.setCur(i + 1);
            sl[i] = elementType;
        }
        ElementType elementType = new ElementType();
        elementType.setData('X');
        elementType.setCur(0);
        sl[MAX_SIZE - 1] = elementType;
    }

    //静态链表分配一个空间
    private int malloc(ElementType[] sl) {
        int s = sl[0].getCur();
        if (s != 0) {
            sl[0].setCur(sl[s].getCur());
        }
        return s;
    }

    //静态链表回收一个空间 放到链表最前面
    private void free(ElementType[] sl, int k) {
        sl[k].setCur(sl[0].getCur());
        sl[0].setCur(k);
    }

    public static void main(String[] args) {
        char[] A = {'c', 'b', 'e', 'g', 'f', 'd'};
        StaticLinkedList staticLinkedList = new StaticLinkedList();
        staticLinkedList.initSL(sl);
        int S = staticLinkedList.malloc(sl); //生成头结点
        int r = S; //标志A的最后一个节点
        int p = S;
        for (int i = 0; i < A.length; i++) {
            int k = staticLinkedList.malloc(sl);
            ElementType e = new ElementType();
            e.setData(A[i]);
            e.setCur(sl[p].getCur());
            sl[p].setCur(k);
            sl[k] = e;
            if(i!=A.length-1){
                p = k;
            }
            r = k;
        }
        sl[r].setCur(0);
        staticLinkedList.printf(sl);

        System.out.println("===========================================");

        char[] B = {'a', 'b', 'n', 'f'};
        for (int i = 0; i < B.length; i++) {
            int pn = S;
            int n = sl[S].getCur(); //头指针（实际有数据的第一个指针）
            while (n != 0 && sl[n].getData() != B[i]) {
                pn = n;
                n = sl[n].getCur();
            }
            if(n==0){ //未找到 让其插队
                int k = staticLinkedList.malloc(sl);
                ElementType elementType = new ElementType();
                elementType.setData(B[i]);
                elementType.setCur(sl[r].getCur());
                sl[k] = elementType;
                sl[r].setCur(k);
            }else{ //找到
                sl[pn].setCur(sl[n].getCur());
                staticLinkedList.free(sl, n);
                if(n == r){
                    r = p;
                }
            }
        }

        staticLinkedList.printf(sl);
    }

    private void printf(ElementType[] sl) {
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.println(String.format("%2d", i) + " " + sl[i].getData() + " " + sl[i].getCur());
        }
    }

}
