package lotto;

import java.util.ArrayList;
import java.util.List;

public enum Prize {
    THREE(0, 5_000),
    FOUR(1, 50_000),
    FIVE(2, 1_500_000),
    SIX(3, 2_000_000_000),
    FIVE_AND_BONUS(4, 30_000_000);

    private int index;
    private int reward;

    Prize(int index, int reward) {
        this.reward = reward;
    }

    public int getIndex() {
        return index;
    }

    public int getReward() {
        return reward;
    }

    public static List<Prize> getList() {
        List<Prize> list = new ArrayList<>(List.of(THREE, FOUR, FIVE, SIX, FIVE_AND_BONUS));
        return list;
    }

    public static int sizeToInd(int size) {
        return size - 3;
    }
}
