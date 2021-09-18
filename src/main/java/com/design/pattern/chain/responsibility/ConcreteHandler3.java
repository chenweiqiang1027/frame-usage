package com.design.pattern.chain.responsibility;

import java.util.logging.Logger;

public class ConcreteHandler3 extends Handler {

    private static Logger logger = Logger.getLogger(ConcreteHandler2.class.getName());

    @Override
    public void handleRequest(int request) {
        if (request >= 20 && request < 30) {
            logger.info(this.getClass() + " 处理请求 " + request);
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }

}
