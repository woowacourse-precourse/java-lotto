package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import static lotto.exception.Exception.*;

public class Player {
    public int purchaseCost = 0;

    public void getPurchaseCost() {
        String input = Console.readLine();
        validatePurchaseCost(input);
        purchaseCost = Integer.parseInt(input);
    }

    private void validatePurchaseCost(String purchaseCost) {
        validateNumberFormat(purchaseCost);
        validateDivision(purchaseCost);
    }
}
