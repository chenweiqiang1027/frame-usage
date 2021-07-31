package com.design.pattern.chain.responsibility.reconsitution;

import com.design.pattern.chain.responsibility.Request;

import java.util.Objects;
import java.util.logging.Logger;

public class GeneralManager extends Manager{

    private static Logger logger = Logger.getLogger(GeneralManager.class.getName());

    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void RequestApplications(Request request) {
        if(Objects.equals("请假", request.getRequestType())){
            logger.info(String.format("%s:%s 数量%s 被批准", name, request.getRequestContent(), request.getNumber()));
        }else if(Objects.equals("加薪", request.getRequestType()) && request.getNumber() <=500){
            logger.info(String.format("%s:%s 数量%s 被批准", name, request.getRequestContent(), request.getNumber()));
        }else{
            logger.info(String.format("%s:%s 数量%s 再说吧", name, request.getRequestContent(), request.getNumber()));
        }
    }
}
