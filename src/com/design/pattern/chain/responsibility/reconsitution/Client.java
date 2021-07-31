package com.design.pattern.chain.responsibility.reconsitution;

import com.design.pattern.chain.responsibility.Request;

public class Client {
    public static void main(String[] args) {
        CommonManager jinli = new CommonManager("金立");
        MajorManager zongjian = new MajorManager("中建");
        GeneralManager zongjingli = new GeneralManager("宗经历");
        //设置上级 可根据实际需求更改设置
        jinli.setSuperior(zongjian);
        zongjian.setSuperior(zongjingli);

        Request request = new Request();
        request.setRequestType("请假");
        request.setRequestContent("小菜请假");
        request.setNumber(1);
        jinli.RequestApplications(request);

        Request request2 = new Request();
        request2.setRequestType("请假");
        request2.setRequestContent("小菜请假");
        request2.setNumber(4);
        jinli.RequestApplications(request2);

        Request request3 = new Request();
        request3.setRequestType("加薪");
        request3.setRequestContent("小菜请求加薪");
        request3.setNumber(500);
        jinli.RequestApplications(request3);

        Request request4 = new Request();
        request4.setRequestType("加薪");
        request4.setRequestContent("小菜请求加薪");
        request4.setNumber(1000);
        jinli.RequestApplications(request4);
    }
}
