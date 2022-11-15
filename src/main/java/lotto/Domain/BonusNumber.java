package lotto.Domain;

import java.util.List;

public class BonusNumber {

    String bonusNumber;

    public BonusNumber(String bonusNumber){
        validInputBonusNumber(bonusNumber);
        outOfRangeBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int matchBonusNumber(List<Integer> unMatchBall) {
        if (unMatchBall.contains(Integer.parseInt(bonusNumber))) return 1;
        return 0;
    }

    public void duplicateInputBonusNumber(List<Integer> WinnerLottoNumber) {
        if (WinnerLottoNumber.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    private void validInputBonusNumber(String bonus) {
        try {
            Integer.parseInt(bonus);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
    }

    private void outOfRangeBonusNumber(String bonus){
        int number = Integer.parseInt(bonus);
        if (number < 1 || number > 45)
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}

