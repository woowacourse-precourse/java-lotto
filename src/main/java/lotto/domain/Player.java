package lotto.domain;

import lotto.view.InputView;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static lotto.constant.ExceptionConstants.*;
import static lotto.constant.GameConstants.*;

public class Player {
    private int purchaseAmount;
    private List<Lotto> lottos;

    public Player() {
        String purchaseAmount = InputView.readPurchaseAmount();
        validate(purchaseAmount);
        this.purchaseAmount = parse(purchaseAmount);
    }

    private void validate(String purchaseAmount) {
        validateNaturalNumber(purchaseAmount);
        validateLeadingZero(purchaseAmount);
        validateDivisibility(purchaseAmount);
    }

    private void validateNaturalNumber(String purchaseAmount) {
        if (!Pattern.matches(NATURAL_NUMBER_REGEX, purchaseAmount)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_NATURAL_NUMBER_EXCEPTION.toString());
        }
    }

    private void validateLeadingZero(String purchaseAmount) {
        if (!Pattern.matches(NO_LEADING_ZERO_REGEX, purchaseAmount)) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_WITH_LEADING_ZERO.toString());
        }
    }

    private void validateDivisibility(String purchaseAmount) {
        if (parse(purchaseAmount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_INDIVISIBILITY_EXCEPTION.toString());
        }
    }

    private int parse(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    private List<Lotto> buyLotto(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();

        while (purchaseAmount > 0) {
            lottos.add(Computer.issueLotto());
            purchaseAmount -= LOTTO_PRICE;
        }
        return lottos;
    }
}