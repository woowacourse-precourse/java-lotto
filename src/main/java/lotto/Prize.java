package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

enum Prize {
    FIRST("2,000,000,000", 1, 7),
    SECOND("30,000,000", 2, 6),
    THIRD("1,500,000", 3, 5),
    FORTH("50,000", 4, 4),
    FIFTH("5,000", 5, 3),
    NOTHING("0", 6, 0);

    private final String prize;
    private final int name;
    private final int count;

    Prize(String money, int name, int count){
        this.prize = money;
        this.name = name;
        this.count = count;
    }

    public String getPrize(){
        return prize;
    }

    public int getName(){
        return name;
    }

    public int getCount(){
        return count;
    }
}
