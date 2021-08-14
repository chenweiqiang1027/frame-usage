package com.think.in.java.chapter10;

public class DotThis {

    private class Inner{
        public DotThis outer(){
            return DotThis.this;
        }
    }

    public Inner inner(){
        return new Inner();
    }

    public void f(){
        System.out.println("this is f function");
    }

    public static void main(String[] args) {
        DotThis dotThis = new DotThis();
        Inner inner = dotThis.new Inner();
        inner.outer().f();

        new DotThis().new Inner();
    }
}
