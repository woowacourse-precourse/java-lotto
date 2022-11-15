package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.Constants.*;
import static lotto.exception.Exception.*;

public class Player {
    private final List<Lotto> lottos = new ArrayList<>();
    public int purchaseCost = 0;

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
        validateDelimiter(numbers);
        validateNumberFormatForAll(numbers);
        return new Lotto(numbers);
    }

    public int getBonusNumber(Lotto winningNumbers) {
        String input = Console.readLine();
        validateBonusNumber(input, winningNumbers);
        return Integer.parseInt(input);
    }

    public String getRateOfReturn() {
        long totalPrize = Statistic.getTotalPrize();
        return String.format("%.1f", (double)totalPrize / (double)purchaseCost * UNIT);
    }

    private void validatePurchaseCost(String purchaseCost) {
        validateNumberFormat(purchaseCost);
        validateDivision(purchaseCost);
    }

    private void validateBonusNumber(String number, Lotto winningNumbers) {
        validateNumberFormat(number);
        validateBonusNumberRange(number);
        validateDuplicateForBonus(number, winningNumbers);
    }
}
