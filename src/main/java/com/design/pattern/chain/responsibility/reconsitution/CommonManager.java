package com.design.pattern.chain.responsibility.reconsitution;

import com.design.pattern.chain.responsibility.Request;

import java.util.Objects;
import java.util.logging.Logger;

public class CommonManager extends Manager {

    private static Logger logger = Logger.getLogger(CommonManager.class.getName());

    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void RequestApplications(Request request) {
        if (Objects.equals("请假", request.getRequestType()) && request.getNumber() <= 2) {
            logger.info(String.format("%s:%s 数量%s 被批准", name, request.getRequestContent(), request.getNumber()));
        }else{
            if(superior != null){ //转到上级处理
                superior.RequestApplications(request);
            }
        }
    }
}
