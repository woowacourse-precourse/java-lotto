package lotto.type;

import lotto.vo.Lotto;
import lotto.vo.LottoAndBonus;

import java.util.List;

public enum PlaceType {
    FIRST_PLACE(List.of(6, 0), 2_000_000_000),
    SECOND_PLACE(List.of(5, 1), 30_000_000),
    THIRD_PLACE(List.of(5, 0), 1_500_000),
    FORTH_PLACE(List.of(4, 0), 50_000),
    FIFTH_PLACE(List.of(3, 0), 5_000);

    private List<Integer> condition;
    private int reward;

    PlaceType(List<Integer> condition, int reward) {
        this.condition = condition;
        this.reward = reward;
    }

    public PlaceType compare(LottoAndBonus winningNumber, Lotto numbers) {
        return PlaceType.THIRD_PLACE;
    }

    public int getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("%d개 일치", condition.get(0)));

        if (condition.get(1) == 1) {
            result.append(", 보너스 볼 일치");
        }

        result.append(String.format(" (%d원)", this.reward));

        return result.toString();
    }
}
