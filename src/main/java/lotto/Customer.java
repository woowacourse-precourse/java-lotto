package lotto;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private static final int RANK_NUM = 5;
    private final List<Lotto> lottoNumbers;
    private final List<Integer> rankCount;
    private final int money;
    private final int lottoCount;

    public Customer(int money) {
        rankCount = new ArrayList<>();
        validateMoney(money);
        this.money = money;
        lottoCount = money / 1000;
        lottoNumbers = new ArrayList<>();
        initRankCount();
    }

    private void initRankCount() {
        for (int i = 0; i < RANK_NUM; i++) {
            rankCount.add(0);
        }
    }

    private void validateMoney(int money) {
        if (money % 1000 > 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_MONEY.getMessage());
        }
        if (money < 1000) {
            throw new IllegalArgumentException(ErrorCode.TOO_SMALl_MONEY.getMessage());
        }
    }

    public void purchaseLotto() {
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new Lotto(NumbersGenerator.getRandomNumbers()));
        }
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
}
