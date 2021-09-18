package com.design.pattern.chain.responsibility.reconsitution;

import com.design.pattern.chain.responsibility.Request;

import java.util.Objects;
import java.util.logging.Logger;

public class MajorManager extends Manager{

    private static Logger logger = Logger.getLogger(MajorManager.class.getName());

    public MajorManager(String name) {
        super(name);
    }

    @Override
    public void RequestApplications(Request request) {
        if(Objects.equals("请假", request.getRequestType()) && request.getNumber() <=5){
            logger.info(String.format("%s:%s 数量%s 被批准", name, request.getRequestContent(), request.getNumber()));
        }else{
            if(superior != null){
                superior.RequestApplications(request);
            }
        }
    }
}
