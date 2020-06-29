package com.zy.servertwo;

import com.zy.pctransaction.annotation.PcTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;


    @PcTransaction(isStart = true)
    @Transactional
    public void test() {
        demoDao.insert("server2");
    }
}
