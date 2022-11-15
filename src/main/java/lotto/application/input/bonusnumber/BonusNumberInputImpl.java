package lotto.application.input.bonusnumber;

import lotto.application.output.inputguideprinter.InputGuidePrinter;
import lotto.application.util.inputagent.InputAgent;

import java.util.List;

public class BonusNumberInputImpl implements BonusNumberInput {

    private final InputAgent inputAgent;
    private final InputGuidePrinter inputGuidePrinter;

    public BonusNumberInputImpl(InputAgent inputAgent, InputGuidePrinter inputGuidePrinter) {
        this.inputAgent = inputAgent;
        this.inputGuidePrinter = inputGuidePrinter;
    }

    @Override
    public int inputWinningLottoBonusNumber(List<Integer> winningLottoNumbers) {
        inputGuidePrinter.inputBonusNumberGuide();
        return inputAgent.inputBonusNumber(winningLottoNumbers);
    }
}
