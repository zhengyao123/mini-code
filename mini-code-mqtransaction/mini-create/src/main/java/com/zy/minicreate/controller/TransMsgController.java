package com.zy.minicreate.controller;

import com.zy.minicreate.common.Result;
import com.zy.minicreate.common.ResultUtil;
import com.zy.minicreate.service.ITransMsgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * date:  2020-07-01 11:35
 *
 * @author zhengyao
 */
@Api(description = "RocketMQ事务消息Bean模式")
@Slf4j
@RestController
@RequestMapping("/transMsg")
public class TransMsgController {

    @Autowired
    private ITransMsgService transMsgService;

    @ApiOperation(value = "生产数据RocketMQ工具类")
    @GetMapping(value = "/producerTransMsg")
    public Result mqTransMsgProducer(@RequestParam("msg") String msg) {
        transMsgService.templateTransMsg(msg);
        return ResultUtil.success();
    }

}
