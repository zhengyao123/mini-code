package com.zy.minicodezookeeper.watch;

import org.apache.zookeeper.*;

import java.io.IOException;

/**
 * date:  2020-07-23 16:13
 *
 * @author zhengyao
 */
public class WatchClientDemo {
    public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
        ZooKeeper zookeeper=new ZooKeeper("192.168.13.102:2181",4000,new Watcher(){
            @Override
            public void process(WatchedEvent event) {
                System.out.println("event.type"+event.getType());
            }
        });
        zookeeper.create("/watch","0".getBytes(), ZooDefs.Ids. OPEN_ACL_UNSAFE, CreateMode.PERSISTENT); //创建节点
        zookeeper.exists("/watch",true); //注册监听
        Thread.sleep(1000);
        zookeeper.setData("/watch", "1".getBytes(),-1) ; //修改节点的值触发监听
        System.in.read();
    }
}
