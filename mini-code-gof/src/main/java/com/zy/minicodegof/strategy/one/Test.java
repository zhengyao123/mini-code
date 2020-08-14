package com.zy.minicodegof.strategy.one;

/**
 * date:  2020-07-28 07:58
 *
 * @author zhengyao
 */
public class Test {

    public static void main(String[] args) {

        EatFruit eatFruit = new EatApple();
        eatFruit.eatFruit();
    }
}
