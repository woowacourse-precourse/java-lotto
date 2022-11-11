package lotto.view;

import java.util.List;

public interface InputView {
    int getPurchaseAmount();

    List<Integer> getWinningNumbers();

    Integer getBonusNumber();
}