package com.design.pattern.chain.responsibility;

public class Main {

    public static void main(String[] args) {
        Handler h1 = new ConcreteHandler1();
        Handler h2 = new ConcreteHandler2();
        Handler h3 = new ConcreteHandler3();
        h1.setSuccessor(h2); //设置职责链上家与下家
        h2.setSuccessor(h3);

        int[] requests = {2, 5, 14, 22, 18, 3, 27, 20, 100};
        for (int i : requests) {
            h1.handleRequest(i);
        }
    }

}
