package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.List;

public class LottoAmount {

    private static final int MIN_MONEY = 1000;
    private static final int MAX_MONEY = 100000;
    private static final int LOTTO_AMOUNT = 1000;
    private static final int ZERO = 0;
    private final int purchaseAmount;
    private final int lottoTickets;

    public LottoAmount(int number) {
        validate(number);
        this.purchaseAmount = number;
        this.lottoTickets = exchangeTicket(number);
    }

    public List<List<Integer>> buyLotto() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        return lottoNumberGenerator.createRandomNumbers(lottoTickets);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validate(int number) {
        if (!validMinRange(number)) {
            throw new IllegalArgumentException("로또 구입 금액은 최소 1,000원 입니다.");
        }
        if (!validUnit(number)) {
            throw new IllegalArgumentException("1000원 단위의 숫자를 입력하셔야 합니다.");
        }
        if (!validMaxRange(number)) {
            throw new IllegalArgumentException("로또는 최대 100,000원까지 구매하실 수 있습니다.");
        }
    }

    private int exchangeTicket(int number) {
        return number / LOTTO_AMOUNT;
    }

    private boolean validUnit(int number) {
        return number % LOTTO_AMOUNT == ZERO;
    }

    private boolean validMaxRange(int number) {
        return number <= MAX_MONEY;
    }

    private boolean validMinRange(int number) {
        return MIN_MONEY <= number;
    }
}
