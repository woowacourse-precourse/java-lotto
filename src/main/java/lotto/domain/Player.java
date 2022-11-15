package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.*;
import static lotto.exception.Exception.*;

public class Player {
    private final List<Lotto> lottos = new ArrayList<>();
    private int purchaseCost = 0;

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void getPurchaseCost() {
        String input = Console.readLine();
        validatePurchaseCost(input);
        purchaseCost = Integer.parseInt(input);
    }

    public void purchaseLotto() {
        int lottoCount = purchaseCost / LOTTO_COST;
        for(int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.generate());
        }
    }

    public Lotto getWinningNumbers() {
        String numbers = Console.readLine();
        return new Lotto(numbers);
    }

    private void validatePurchaseCost(String purchaseCost) {
        validateNumberFormat(purchaseCost);
        validateDivision(purchaseCost);
    }
}
