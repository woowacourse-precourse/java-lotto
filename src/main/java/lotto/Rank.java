package lotto;

import java.util.ArrayList;
import java.util.List;

public enum Rank {
    FIFTH(4,3, "5,000원", 0),
    FOURTH(3,4, "50,000원", 0),
    THIRD(2,5, "1,500,000원", 0),
    SECOND(1,5, "30,000,000원", 1),
    FIRST(0,6, "2,000,000,000원", 0),
    NOTHING(5,0,"0원",0);
    private int count;
    private String money;
    private int bonus;
    private int idx;

    Rank(int idx, int count, String money, int bonus) {
        this.count = count;
        this.money = money;
        this.bonus = bonus;
        this.idx = idx;
    }

    public int getIdx(){
        return idx;
    }
    public String getMoney() {
        return money;
    }

    public int getCount(){
        return count;
    }
    public int getBonus(){
        return bonus;
    }
}
