package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

enum Prize {
    FIRST(4, 7),
    SECOND(3, 6),
    THIRD(2, 5),
    FORTH(1, 4),
    FIFTH(0, 3),
    NOTHING(5, 0);

    private final int name;
    private final int count;

    Prize(int name, int count){
        this.name = name;
        this.count = count;
    }

    public int getName(){
        return name;
    }

    public int getCount(){
        return count;
    }
}
