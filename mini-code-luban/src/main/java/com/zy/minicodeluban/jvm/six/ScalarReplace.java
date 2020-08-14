package com.zy.minicodeluban.jvm.six;

public class ScalarReplace {

    public static void main(String[] args) {

    }

    public static void test() {
        Position position = new Position(1, 2, 3);

        System.out.println(position.x);
        System.out.println(position.y);
        System.out.println(position.z);
    }
}

class Position {
    int x;
    int y;
    int z;

    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
