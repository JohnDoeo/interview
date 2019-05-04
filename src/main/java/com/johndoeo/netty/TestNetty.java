package com.johndoeo.netty;

public class TestNetty {
  public static void main(String[] args){
      final ClientHandler clientHandler = new ClientHandler();
      try {
          clientHandler.channelRead(null,"测试信息");
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}
