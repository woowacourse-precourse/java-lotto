package lotto.domain;

import lotto.Lotto;
import lotto.constant.ExceptionConstants;
import lotto.constant.GameConstants;
import lotto.util.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int purchaseAmount;
    private final List<Lotto> lottos = new ArrayList<>();

    public Player() {
        String purchaseAmount = InputView.readPurchaseAmount();
        validate(purchaseAmount);
        this.purchaseAmount = Integer.parseInt(purchaseAmount);

        buyLotto();
        printLotto();
    }

    private void validate(String purchaseAmount) {
        Validator.validateNaturalNumber(purchaseAmount);
        Validator.validateLeadingZero(purchaseAmount);
        validateDivisibility(Integer.parseInt(purchaseAmount));
    }

    private void validateDivisibility(int purchaseAmount) {
        if (purchaseAmount % GameConstants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionConstants.INDIVISIBLE_PURCHASE_AMOUNT.toString());
        }
    }

    public void buyLotto() {
        while (this.purchaseAmount > 0) {
            lottos.add(Computer.issueLotto());
            purchaseAmount -= GameConstants.LOTTO_PRICE;
        }
    }

    public void printLotto() {
        OutputView.printPurchaseQuantity(lottos.size());
        lottos.forEach(OutputView::printLottoNumber);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}