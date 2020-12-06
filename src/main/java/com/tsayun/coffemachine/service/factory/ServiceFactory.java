package com.tsayun.coffemachine.service.factory;

public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance(){
        return instance;
    }

    private ServiceFactory() {
    }
}
