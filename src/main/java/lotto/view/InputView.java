package lotto.view;

import java.util.List;

public interface InputView {
    int askPurchaseAmount();

    List<Integer> askWinningNumbers();

    Integer askBonusNumber();
}