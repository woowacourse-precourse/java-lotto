package lotto;

import java.util.List;

public class LottoAmount {

    private int purchaseAmount;
    private int lottoTickets;

    public LottoAmount(String input) {
        Validator validator = new Validator();
        this.purchaseAmount = validator.validDatePurchaseAmount(input);
        this.lottoTickets = purchaseAmount/1000;
    }

    public List<List<Integer>> buyLotto() {
        NumberGenerator numberGenerator = new NumberGenerator();
        System.out.println(lottoTickets + "개를 구매했습니다.");
        return numberGenerator.createRandomNumbers(lottoTickets);
    }
}
