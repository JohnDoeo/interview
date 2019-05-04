package com.johndoeo.day0304;

import org.junit.Test;

import java.util.*;

public class TransferValue {

    @Test
    public void tt1() {
//        final User user = new User("admin","111111");
//        System.out.println(user);
//        changeObj(user);
//        System.out.println(user);
//        System.out.println(Math.round(1.5) );]
//        String str = "123456";
//        System.out.println(convertStr(str));
//        System.out.println(reverseWithSwaps(str));
//        System.out.println(reverseWithXOR(str));
//        final String s = new StringBuilder(str).reverse().toString();
//        System.out.println(s);

//        Map<String,String> map = new HashMap<>();
//        map.put(null,"111");
//        map.put(null,"111");

//        int i = 10;
//        final byte b = intToByte(10);
//        System.out.println(b);
//        final int i1 = byteToInt(b);
//        System.out.println(i1);
        final double v = 3 * 0.1;
        System.out.println(3*0.1==0.3);
    }

    //byte 与 int 的相互转换
    public static byte intToByte(int x) {
        return (byte) x;
    }

    public static int byteToInt(byte b) {
        //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
        return b & 0xFF;
    }

    public String reverseWithSwaps(String string) {
        final char[] array = string.toCharArray();
        final int length = array.length - 1;
        final int half = (int) Math.floor(array.length / 2);
        char c;
        for (int i = length; i >= half; i--) {
            c = array[length - i];
            array[length - i] = array[i];
            array[i] = c;
        }
        return String.valueOf(array);
    }

    public static String reverse(String str) {
        // base case: if string is null or empty
        if (str == null || str.equals(""))
            return str;
        // create an empty stack of characters
        Stack<Character> stack = new Stack<Character>();
        // push every character of the given string into the stack
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++)
            stack.push(ch[i]);
        // start from index 0
        int k = 0;
        // pop characters from the stack until it is empty
        while (!stack.isEmpty()) {
            // assign each popped character back to the character array
            ch[k++] = stack.pop();
        }
        // convert the character array into string and return it
        return String.copyValueOf(ch);
    }

    public String reverseWithXOR(String string) {
        final char[] array = string.toCharArray();
        final int length = array.length;
        final int half = (int) Math.floor(array.length / 2);
        for (int i = 0; i < half; i++) {
            array[i] ^= array[length - i - 1];
            array[length - i - 1] ^= array[i];
            array[i] ^= array[length - i - 1];
        }
        return String.valueOf(array);
    }

    public String convertStr(String s) {
        if (s == null || s.length() == 0 || s.trim().equals("")) {
            return s;
        }
        if (s.length() == 2) {
            return s.substring(s.length() - 1) + s.substring(0, 1);
        }
        return s.substring(s.length() - 1) + convertStr(s.substring(0, s.length() - 1));
    }

    public void changeObj(User user) {
        user.setPassword("000000");
        user.setUserName("johndoeo");
    }

    class User {
        private Integer id;
        private String userName;
        private String password;

        public User() {
        }

        public User(String userName, String password) {
            this.userName = userName;
            this.password = password;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", userName='" + userName + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}

interface Person<T> {
    default void getAge() {
        System.out.println("this is age");
    }
}
