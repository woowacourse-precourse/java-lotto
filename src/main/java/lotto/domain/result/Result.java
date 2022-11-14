package lotto.domain.result;

import java.util.List;

public class Result {
    private int accordedNumbers;
    private boolean isHitBonus;

    Result(int accordedNumbers, boolean isHitBonus) {
        this.accordedNumbers = accordedNumbers;
        this.isHitBonus = isHitBonus;
    }

    public int getAccordedNumbers() {
        return accordedNumbers;
    }

    public boolean isHitBonus() {
        return isHitBonus;
    }
}
