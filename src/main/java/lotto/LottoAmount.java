package lotto;

import java.util.List;

public class LottoAmount {

    private int purchaseAmount;
    private int lottoTickets;

    public LottoAmount(int number) {
        validate(number);
        this.purchaseAmount = number;
        this.lottoTickets = exchangeTicket(number);
    }

    public List<List<Integer>> buyLotto() {
        NumberGenerator numberGenerator = new NumberGenerator();
        System.out.println(lottoTickets + "개를 구매했습니다.");
        return numberGenerator.createRandomNumbers(lottoTickets);
    }
    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    private void validate(int number) {
        if (! validUnit(number)) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 숫자를 입력하셔야 합니다.");
        }
        if (! validRange(number)) {
            throw new IllegalArgumentException("[ERROR] 로또는 최대 100,000원까지 구매하실 수 있습니다.");
        }
    }

    private int exchangeTicket(int number) {
        return number / 1000;
    }

    private boolean validUnit(int number) {
        return number % 1000 == 0;
    }

    private boolean validRange(int number) {
        return 1000 <= number && number <= 100000;
    }
}
