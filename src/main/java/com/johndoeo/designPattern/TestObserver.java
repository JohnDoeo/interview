package com.johndoeo.designPattern;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/4/24 21:39
 * @Description:
 */
public class TestObserver {

    public static void main(String[] args) {

        TeacherSubject teacher=new TeacherSubject();
        StudentObserver zhangSan=new StudentObserver("张三", teacher);
        StudentObserver LiSi=new StudentObserver("李四", teacher);
        StudentObserver WangWu=new StudentObserver("王五", teacher);

        teacher.setHomework("第二页第六题");
        teacher.setHomework("第三页第七题");
        teacher.setHomework("第五页第八题");
    }
}
