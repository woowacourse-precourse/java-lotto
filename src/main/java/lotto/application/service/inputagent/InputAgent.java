package lotto.application.service.inputagent;

import java.util.List;

public interface InputAgent {
    int inputUserPurchaseMoney();

    List<Integer> inputWinningNumbers();

    int inputBonusNumber(List<Integer> winningLottoNumbers);

}
