package lotto.application.input.winningnumber;

import lotto.application.output.inputguideprinter.InputGuidePrinter;
import lotto.application.util.inputagent.InputAgent;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberInputImpl implements WinningNumberInput {

    private final InputAgent inputAgent;
    private final InputGuidePrinter inputGuidePrinter;

    public WinningNumberInputImpl(InputAgent inputAgent, InputGuidePrinter inputGuidePrinter) {
        this.inputAgent = inputAgent;
        this.inputGuidePrinter = inputGuidePrinter;
    }

    @Override
    public List<Integer> inputWinningLottoNumbers() {
        inputGuidePrinter.inputBonusNumberGuide();
        return new ArrayList<>(inputAgent.inputWinningNumbers());
    }
}
