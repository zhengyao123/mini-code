package com.zy.pctransaction.netty;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zy.pctransaction.transaction.Transaction;
import com.zy.pctransaction.transaction.TransactionMangage;
import com.zy.pctransaction.transaction.TransactionType;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * date:  2020-06-29 14:51
 *
 * @author zhengyao
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {

    private ChannelHandlerContext context;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        context = ctx;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("接受数据:" + msg.toString());
        JSONObject jsonObject = JSON.parseObject((String) msg);

        String groupId = jsonObject.getString("groupId");
        String command = jsonObject.getString("command");
        String transactionId = jsonObject.getString("transactionId");

        //拿到通知的事物对象
        Transaction transaction = TransactionMangage.getTransactionById(groupId, transactionId);
        System.out.println("接收command:" + command);

        if (transaction!=null){
            if (command.equals("rollback")){
                transaction.setTransactionType(TransactionType.ROLLBACK);
            }else{
                transaction.setTransactionType(TransactionType.COMMIT);
            }
            transaction.getTask().signalTask();
        }
    }

    public synchronized Object call(JSONObject data) throws Exception {
        context.writeAndFlush(data.toJSONString()).channel().newPromise();
        return null;
    }
}
