package lotto.enums;

import java.util.ArrayList;
import java.util.List;

public enum Rank {
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    DEFAULT(0, 0);

    private final int ball;
    private final int prize;
    Rank(int ball, int prize) {
        this.ball = ball;
        this.prize = prize;
    }

    public List<Integer> getRank() {
        List<Integer> rank = new ArrayList<>();
        rank.add(this.ball);
        rank.add(this.prize);
        return rank;
    }
}
