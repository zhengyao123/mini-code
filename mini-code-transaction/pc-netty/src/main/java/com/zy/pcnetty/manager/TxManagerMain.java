package com.zy.pcnetty.manager;

/**
 * date:  2020-06-29 11:17
 *
 * @author zhengyao
 */
public class TxManagerMain {
    public static void main(String[] args) {
        NettyServer nettyServer = new NettyServer();
        nettyServer.start("localhost", 8080);

        System.out.println("netty 启动成功");
    }
}
