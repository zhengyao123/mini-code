package com.zy.serverone;

import com.zy.pctransaction.annotation.PcTransaction;
import com.zy.pctransaction.tack.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;
    //isStart
    //isEnd
    @PcTransaction(isStart = true)
    @Transactional
    public void test() {
        demoDao.insert("server1");
        HttpUtil.post("http://localhost:9020/server2/test");
        int i = 1/0;
    }
}
