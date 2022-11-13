package lotto.application.service.inputagent;

import java.util.List;

public interface InputAgent {
    int inputUserMoney();

    List<Integer> inputWinningNumbers();

    int inputBonusNumber(List<Integer> winningLottoNumbers);

}
