package lotto;

import java.util.List;

public class User {
    private int cost;
    private List<Integer> userInput;
    private int userBonus;

    public User(int cost) {
        validateCost(cost);
        this.cost = cost;
    }

    private void validateCost(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다");
        }
    }
}
