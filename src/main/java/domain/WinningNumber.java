package domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private final List<Integer> winNumbers;

    public WinningNumber(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }
}
