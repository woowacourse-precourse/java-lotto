package lotto.domain.player;

import lotto.domain.statistic.Rank;
import lotto.utils.ErrorCode;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.lotto.LottoConstants.PRICE_UNIT;

public class Player {
    private int lottoCount;
    private int price;
    private Map<Rank, Integer> correctLotto;

    public void setLottoCount(String input) {
        this.validate(input);
        this.price = Integer.parseInt(input);
        this.lottoCount = calculateLottoCount();
        this.correctLotto = new HashMap();
    }

    public void addRank(Rank rank) {
        correctLotto.put(rank, correctLotto.getOrDefault(rank, 0) + 1);
    }

    private void validate(String input) {
        int price = Integer.parseInt(input);
        if (price < 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PRICE.getMessage());
        }

        if (price % PRICE_UNIT.getNumber() != 0) {
            throw new IllegalArgumentException(ErrorCode.INVALID_PRICE.getMessage());
        }
    }

    private int calculateLottoCount() {
        return price / PRICE_UNIT.getNumber();
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public Map<Rank, Integer> getCorrectLotto() {
        return correctLotto;
    }

    public int getPrice() {
        return price;
    }
}
