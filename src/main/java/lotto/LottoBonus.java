package lotto;

import java.util.List;

public class LottoBonus {
    private int LottoBonusNumber;

    public LottoBonus(List<Integer> lottoNumber, String orderBonusNumber) {
        validateOrderNumber(orderBonusNumber);
        int bonusNumber = Integer.parseInt(orderBonusNumber);
        validateBonusNumber(bonusNumber);
        LottoBonusNumber = bonusNumber;
        validateLottoNumbers(lottoNumber);
    }

    private void validateBonusNumber(int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void validateOrderNumber(String orderBonusNumber) {
        if (!(orderBonusNumber.matches("[0-9]+"))) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해 주세요.");
        }

    }


    public void validateLottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(LottoBonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복되지 않는 번호여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return LottoBonusNumber;
    }
}

