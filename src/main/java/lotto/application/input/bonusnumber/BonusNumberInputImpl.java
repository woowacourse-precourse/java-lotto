package lotto.application.input.bonusnumber;

import lotto.application.util.inputagent.InputAgent;

import java.util.List;

public class BonusNumberInputImpl implements BonusNumberInput {

    private final InputAgent inputAgent;

    public BonusNumberInputImpl(InputAgent inputAgent) {
        this.inputAgent = inputAgent;
    }

    @Override
    public int inputWinningLottoBonusNumber(List<Integer> winningLottoNumbers) {
        System.out.println("\n보너스 번호를 입력해주세요.");
        return inputAgent.inputBonusNumber(winningLottoNumbers);
    }
}
