package lotto.lotterymachine.domain;

import java.util.Collections;
import java.util.List;
import lotto.util.Constant;

public class LotteryMachine {
    private List<Integer> targetNumbers;  // 마주처야 할 6자리
    private int targetBonusNumber; // 보너스 번호

    public LotteryMachine() {
        this.targetNumbers = Collections.singletonList(Constant.INIT_ZERO);
        this.targetBonusNumber = Constant.INIT_ZERO;
    }

    public void setTargetNumbers(List<Integer> targetNumbers) {
        this.targetNumbers = targetNumbers;
    }

    public void setTargetBonusNumber(int targetBonusNumber) {
        this.targetBonusNumber = targetBonusNumber;
    }

    public List<Integer> getTargetNumbers() {
        return targetNumbers;
    }

    public int getTargetBonusNumber() {
        return targetBonusNumber;
    }
}
