package datastructure.yan.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P51MathPath {

    static int a[][] = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 1, 1, 0, 1, 1, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 1, 1, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public static class Coordinate {
        int x;
        int y;
        int next; //0:东边 1:南边 2:西边 3:北边

        public Coordinate(int x, int y, int next) {
            this.x = x;
            this.y = y;
            this.next = next;
        }
    }

    //共计17步骤 走了弯路(1,1) -> (2,1) -> (2,2) -> (2,3) -> (1,3) -> ...
    public static void main(String[] args) {
        Stack<Coordinate> stack = new Stack<>();
        List<Coordinate> alreadyIn = new ArrayList<>();
        Coordinate coordinate = new Coordinate(1, 1, 0);
        alreadyIn.add(coordinate);
        stack.push(coordinate); //放入第一个元素
        while (!stack.isEmpty()) {
            Coordinate top = stack.peek();
            Coordinate current = null;
            while (current == null && top.next < 4) {
                switch (top.next) {
                    case 0: {
                        if ((top.x + 1) >= 0 && (top.x + 1) <= 9) {
                            current = new Coordinate(top.x + 1, top.y, 0);
                        }
                        top.next++;
                        break;
                    }
                    case 1: {
                        if ((top.y + 1) >= 0 && (top.y + 1) <= 9) {
                            current = new Coordinate(top.x, top.y + 1, 0);
                        }
                        top.next++;
                        break;
                    }
                    case 2: {
                        if ((top.x - 1) >= 0 && (top.x - 1) <= 9) {
                            current = new Coordinate(top.x - 1, top.y, 0);
                        }
                        top.next++;
                        break;

                    }
                    case 3: {
                        if ((top.y - 1) >= 0 && (top.y - 1) <= 9) {
                            current = new Coordinate(top.x, top.y - 1, 0);
                        }
                        top.next++;
                        break;
                    }
                }
                if (current != null) {
                    for (Coordinate coordinate1 : alreadyIn) { //曾经进过栈的不允许再次入栈
                        if (coordinate1.x == current.x && coordinate1.y == current.y) {
                            current = null;  //寻找下一个
                            break;
                        }
                    }
                }
            }
            if (current == null) {
                stack.pop();
                continue;
            }
            if (a[current.y][current.x] == 1) {  // 坐标轴的x，y和数组的下标不一致
                stack.push(current);
                alreadyIn.add(current);
                if (current.x == 8 && current.y == 8) {
                    break;
                }
            }
        }
        System.out.println("done");
    }

}
