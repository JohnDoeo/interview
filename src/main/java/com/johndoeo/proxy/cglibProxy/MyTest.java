package com.johndoeo.proxy.cglibProxy;

public class MyTest {
    public static void main(String[] args){
        final ProxyFactory proxyFactory = new ProxyFactory(new Singer());
        final Singer proxyInstance = (Singer) proxyFactory.getProxyInstance();
        proxyInstance.sing();
    }
}
