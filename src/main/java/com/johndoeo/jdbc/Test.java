package com.johndoeo.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Auther: JohnDoeo
 * @Date: 2019/4/30 20:52
 * @Description:
 */
public class Test {
    @org.junit.Test
    public void getUser() {
        String sql = "select * from user where id = ?";
        Object[] obj = {1};
        ResultSet resultSet = JDBCutils.executeQuerySql(sql, obj);
        User user = new User();
        try {
            while (resultSet.next()) {

                user.setId(resultSet.getInt("id"));
                user.setAge(resultSet.getInt("age"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setSex(resultSet.getString("sex"));
                user.setResume(resultSet.getString("resume"));
                user.setHobby(resultSet.getString("hobby"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCutils.closeAll();
        }
        System.err.println(user.getUsername());
    }
}
