package lotto.entity;

import java.util.function.BiFunction;

public enum Rank {

    FIRST(6, false,2_000_000_000, (count, bonus) -> count == 6),
    SECOND(5, true, 30_000_000, (count, bonus) -> count == 5 && bonus),
    THIRD(5, false, 1_500_000, (count, bonus) -> count == 5 && !bonus),
    FOURTH(4, false, 50_000, (count, bonus) -> count == 4),
    FIFTH(3, false, 5_000, (count, bonus) -> count == 3),
    NONE(0, false, 0, (count, bonus) -> count <= 2);

    private final int count;
    private final boolean bonus;
    private final int prize;
    private final BiFunction<Integer, Boolean, Boolean> expression;

    Rank(int count, boolean bonus, int prize, BiFunction<Integer, Boolean, Boolean> expression) {
        this.count = count;
        this.bonus = bonus;
        this.prize = prize;
        this.expression = expression;
    }

    public int getCount() { return count; }

    public int getPrize() {
        return prize;
    }

    public boolean win(int count, boolean bonus) {
        return expression.apply(count, bonus);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(count).append("개 일치");
        if (bonus) {
            output.append(", 보너스 볼 일치");
        }
        output.append(" (").append(String.format("%,d", prize)).append("원)");
        return output.toString();
    }

}
