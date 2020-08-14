package com.zy.minicodegof.strategy.two;

import com.zy.minicodegof.strategy.one.EatApple;
import com.zy.minicodegof.strategy.one.EatBanana;
import com.zy.minicodegof.strategy.one.EatFruit;

import java.util.HashMap;
import java.util.Map;

/**
 * date:  2020-07-28 08:06
 *
 * @author zhengyao
 */
public class FruitFactory {

    static Map<String, EatFruit> map = new HashMap<>();

    static {
        map.put("apple",new EatApple());
        map.put("banana",new EatBanana());
    }

    public FruitFactory() {
    }

    public EatFruit getEatFruit(String fruit){
        EatFruit eatFruit = map.get(fruit);
        return eatFruit;
    }
}
