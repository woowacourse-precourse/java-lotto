package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String PRICE_ERROR_MESSAGE = "1000원 이상의 금액을 입력해야합니다.";
    private static LottoMachine lottoMachine;
    private final int purchaseAmount;

    public Lotto(int purchaseAmount) {
        lottoMachine = new LottoMachine();
        this.purchaseAmount = purchaseAmount;
    }

    public LottoTickets generateLottoTickets() {
        return lottoMachine.generate(purchaseQuantity());
    }

    public WinningNumber generateWinningNumber(String inputNumber) {
        return lottoMachine.winningNumber(inputNumber);
    }

    public int purchaseQuantity() {
        if (purchaseAmount < ONE_LOTTO_PRICE) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
        return purchaseAmount / ONE_LOTTO_PRICE;
    }
}

