package com.johndoeo.designPattern;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/4/24 21:37
 * @Description:
 */
interface Observer {
    //当主题状态改变时,会将一个String类型字符传入该方法的参数,每个观察者都需要实现该方法
    public void update(String info);
}
