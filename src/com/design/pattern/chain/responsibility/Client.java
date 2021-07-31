package com.design.pattern.chain.responsibility;

public class Client {
    public static void main(String[] args) {
        // 三个人 都只有人名
        Manager jinli = new Manager("金立");
        Manager zongjian = new Manager("总建");
        Manager zhongjingli = new Manager("中经历");

        Request request = new Request();
        request.setRequestType("加薪");
        request.setRequestContent("小菜请求加薪");
        request.setNumber(1000);
        jinli.getResult("经理", request); //职位作为参数传进去
        zongjian.getResult("总监", request);
        zhongjingli.getResult("总经理", request);

        Request anotherRequest = new Request();
        anotherRequest.setRequestType("请假");
        anotherRequest.setRequestContent("小菜请假");
        anotherRequest.setNumber(5);
        jinli.getResult("经理", anotherRequest);
        zongjian.getResult("总监", anotherRequest);
        zhongjingli.getResult("总经理", anotherRequest);
    }
}
