package com.johndoeo.base.quate;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/5/4 21:53
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        User user = new User();
        user.setUserName("张三");
        String str = ", 你好！";
        changeStr(user);
        System.err.println(user.getUserName()+str);
    }
    public static void changeStr(User user){
        user.setUserName("zhangsan");
        String str = ", hello!";
        System.err.println(user.getUserName()+str);
    }
}
