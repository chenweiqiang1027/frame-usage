package com.design.pattern.chain.responsibility;

import java.util.Objects;
import java.util.logging.Logger;

public class Manager {

    private static Logger logger = Logger.getLogger(Manager.class.getName());

    protected String name;

    public Manager(String name) {
        this.name = name;
    }

    //比较长的方法，多条的分支，这些其实都是代码坏味道。
    //1、类有太多责任，违背了单一职责原则 2、增加新的管理类别，需要修改类，违背了开放-封闭原则
    public void getResult(String managerLevel, Request request) {
        if (Objects.equals("经理", managerLevel)) {
            if (Objects.equals("请假", request.getRequestType()) && request.getNumber() <= 2) {
                logger.info(String.format("%s:%s 数量%s 被批准", name, request.getRequestContent(), request.getNumber()));
            } else {
                logger.info(String.format("%s:%s 数量%s 我无权处理", name, request.getRequestContent(), request.getNumber()));
            }
        } else if (Objects.equals("总监", managerLevel)) {
            if (Objects.equals("请假", request.getRequestType()) && request.getNumber() <= 5) {
                logger.info(String.format("%s:%s 数量%s 被批准", name, request.getRequestContent(), request.getNumber()));
            } else {
                logger.info(String.format("%s:%s 数量%s 我无权处理", name, request.getRequestContent(), request.getNumber()));
            }
        } else if (Objects.equals("总经理", managerLevel)) {
            if (Objects.equals("请假", request.getRequestType())) {
                logger.info(String.format("%s:%s 数量%s 被批准", name, request.getRequestContent(), request.getNumber()));
            } else if(Objects.equals("加薪", request.getRequestType()) && request.getNumber() <= 500){
                logger.info(String.format("%s:%s 数量%s 被批准", name, request.getRequestContent(), request.getNumber()));
            } else if(Objects.equals("加薪", request.getRequestType()) && request.getNumber() > 500){
                logger.info(String.format("%s:%s 数量%s 再说吧", name, request.getRequestContent(), request.getNumber()));
            }
        }
    }
}
