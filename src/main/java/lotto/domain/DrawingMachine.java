package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class DrawingMachine {
    public final List<Integer> winningNumber;
    public final Integer bonusNumber;

    DrawingMachine() {
        winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
    }
}
