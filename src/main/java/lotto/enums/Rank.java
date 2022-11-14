package lotto.enums;

import java.util.ArrayList;
import java.util.List;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000);

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
