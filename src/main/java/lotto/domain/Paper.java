package lotto.domain;

public class Paper {
    private static final int UNIT = 1000;
    private final int paper;

    public Paper(int money){
        paper = How_Many_Paper(money);
    }

    private int How_Many_Paper(int money){
        return money / UNIT;
    }

    public int Get_Paper() {
        return paper;
    }
}
