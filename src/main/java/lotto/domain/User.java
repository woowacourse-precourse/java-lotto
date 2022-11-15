package lotto.domain;

import lotto.exception.LottoError;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private final List<Lotto> lottos = new ArrayList<>();
    private int purchaseAmount;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void inputPurchaseAmount(String input) {
        validate(input);
        this.purchaseAmount = Integer.parseInt(input);
    }

    private void validate(String input) throws RuntimeException {
        long numericLength = input.chars()
                .filter(Character::isDigit)
                .count();
        if (numericLength != input.length())
            throw new IllegalArgumentException(LottoError.NOT_NUMERIC.getErrorMessage());

        int money = Integer.parseInt(input);
        if (money % 1000 != 0)
            throw new IllegalArgumentException(LottoError.WRONG_UNIT_OF_WON.getErrorMessage());
    }

}
