package lotto.domain;

import java.util.List;

public class WinningNumber {
    List<Integer> winNumber;
    int bonusNumber;
    public WinningNumber(String winInput, int bonusNumber) {
        splitInput(winInput);
        this.bonusNumber = bonusNumber;
    }

    private void splitInput(String winInput) {
        String[] ArrayStr = winInput.split(",");

        for (String s : ArrayStr) {
            winNumber.add(Integer.valueOf(s));
        }
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
