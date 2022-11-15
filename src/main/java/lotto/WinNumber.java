package lotto;

import java.util.List;

public class WinNumber {
    private List<Integer> winNumber;
    private int bonusNumber = 0;

    private WinNumberController wc = new WinNumberController();

    public WinNumber(String winNumber, String bonusNumber) {
        this.winNumber = wc.readWinNumber(winNumber);
        this.bonusNumber = wc.readBonusNumber(bonusNumber);

        validateBonusNumber(this.bonusNumber);
        validateWinNumber(this.winNumber);
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(Integer bonusNumber) {
        if (winNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다");
        }
    }

    private void validateWinNumber(List<Integer> winNumbers) {
        if (winNumber.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 여섯자리여야 합니다");
        }
        for (int winNumber : winNumbers) {
            if (winNumber < 1 || winNumber > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1과 45사이여야 합니다");
            }
        }
    }

}
