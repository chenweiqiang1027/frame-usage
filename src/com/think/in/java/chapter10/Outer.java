package com.think.in.java.chapter10;

public class Outer {
    private String s;

    public Outer(String s) {
        this.s = s;
    }

    class Inner {
        private int i;

        public int value() {
            return i;
        }

        public String toString(){
            return s;
        }
    }

    public Inner to() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer = new Outer("abc");
        Outer.Inner inner = outer.to(); //我看直接使用的Inner声明也是没有报错
        System.out.println(inner.toString());
    }
}
