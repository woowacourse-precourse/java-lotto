package lotto.domain;

import java.util.List;

public class Result {
    private int accordedNumbers;
    private boolean isHitBonus = false;

    Result(int accordedNumbers, boolean isHitBonus) {
        this.accordedNumbers = accordedNumbers;
        if (accordedNumbers == 5)
            this.isHitBonus = isHitBonus;
    }

    public int getAccordedNumbers() {
        return accordedNumbers;
    }
}
