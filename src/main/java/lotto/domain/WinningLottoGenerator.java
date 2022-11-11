package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoRule;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLottoGenerator {
    public static WinningLotto generateWinningLotto(
            List<Integer> winningBall, Integer eventBall) {
        Map<Integer, Boolean> winningNumbers = new HashMap<>();

        validate(winningBall.size());

        for(Integer number : winningBall) {
            winningNumbers.put(number,false);
        }
        winningNumbers.put(eventBall, true);

        return WinningLotto.of(winningNumbers);
    }

    private static void validate(int size) {
        if(size!=LottoRule.AMOUNT_OF_NUMBER.getValueForRule()) {
            throw new IllegalArgumentException(
                    ErrorMessage.NOT_EQUAL_TO_LOTTO_NUMBER_AMOUNT.getMessage());
        }
    }
}
