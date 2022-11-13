package lotto.application.util.inputagent;

import java.util.List;

public interface InputAgent {
    int inputUserPurchaseMoney();

    List<Integer> inputWinningNumbers();

    int inputBonusNumber(List<Integer> winningLottoNumbers);

}
