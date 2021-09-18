package com.design.pattern.chain.responsibility.reconsitution;

import com.design.pattern.chain.responsibility.Request;

public abstract class Manager {
    protected String name;

    protected Manager superior;

    public Manager(String name){
        this.name = name;
    }

    public void setSuperior(Manager superior){
        this.superior = superior;
    }

    public abstract void RequestApplications(Request request);

}
