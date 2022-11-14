package lotto;

import java.util.List;

public class User {
    private int cost;
    private List<Integer> lottoNumbers;

    public User(int cost) {
        validateCost(cost);
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private void validateCost(int cost) {
        if (cost % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원으로 나누어 떨어져야 합니다");
        }
    }

}
