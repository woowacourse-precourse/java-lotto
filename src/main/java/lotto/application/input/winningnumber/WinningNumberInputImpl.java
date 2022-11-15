package lotto.application.input.winningnumber;

import lotto.application.util.inputagent.InputAgent;

import java.util.ArrayList;
import java.util.List;

public class WinningNumberInputImpl implements WinningNumberInput {

    private final InputAgent inputAgent;

    public WinningNumberInputImpl(InputAgent inputAgent) {
        this.inputAgent = inputAgent;
    }

    @Override
    public List<Integer> inputWinningLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해주세요.");

        return new ArrayList<>(inputAgent.inputWinningNumbers());
    }
}
