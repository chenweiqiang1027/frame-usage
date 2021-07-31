package com.design.pattern.chain.responsibility;

import java.util.logging.Logger;

public class ConcreteHandler1 extends Handler {

    private static Logger logger = Logger.getLogger(ConcreteHandler1.class.getName());

    @Override
    public void handleRequest(int request) {
        if (request >= 0 && request < 10) {
            logger.info(this.getClass() + " 处理请求 " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }

}
