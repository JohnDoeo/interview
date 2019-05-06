package com.johndoeo.proxy.dynamicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

public class MyTest {
    public static void main(String[] args) {
        Singer target = new Singer();
        ISinger proxy  = (ISinger) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy 代理的真实对象
                     * @param method 被代理的方法
                     * @param args 被代理方法的参数列表
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println(String.valueOf(args[0])+"的演唱者，向观众问好");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("谢谢大家来听"+String.valueOf(args[0]));
                        return returnValue;
                    }
                });
        proxy.sing("黄昏");
//        new MyTest().ssss();
    }

//    public void ssss(){
//        Singer target = new Singer();
//        ISinger proxy = (ISinger) Proxy.newProxyInstance(
//                target.getClass().getClassLoader(),
//                target.getClass().getInterfaces(),
//                (p,m,a)->{
//                    System.out.println("向观众问好");
//                    //执行目标对象方法
//                    Object returnValue = m.invoke(target, a);
//                    System.out.println("谢谢大家");
//                    return returnValue;
//                });
//        proxy.sing();
//    }
}
