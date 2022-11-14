package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    NONE(0, 0, false);
    private final int price;
    private final int count;
    private final boolean hasBonusNumber;

    LottoRank(int price, int count, boolean hasBonusNumber) {
        this.price = price;
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
    }


    public long multiple(Integer count) {
        return (long) price * count;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public boolean getHasBonusNumber() {
        return hasBonusNumber;
    }
}
