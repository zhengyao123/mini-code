package com.zy.minicodegof.strategy.two;

import com.zy.minicodegof.strategy.one.EatFruit;

/**
 * date:  2020-07-28 08:12
 *
 * @author zhengyao
 */
public class Test {
    public static void main(String[] args) {
        EatFruit apple = new FruitFactory().getEatFruit("apple");
        apple.eatFruit();
    }
}
