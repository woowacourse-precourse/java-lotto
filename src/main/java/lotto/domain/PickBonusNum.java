package lotto.domain;

import lotto.domain.enums.ErrorMessage;

public class PickBonusNum {

    public int pickBonus;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final String NUMBER_RANGE_ERR = "[ERROR] 로또 숫자는 " + MIN_NUM + " 이상 " + MAX_NUM + "이하의 숫자만 가능합니다";

    public PickBonusNum(Lotto pickLottoNum, String pickBonusNum) {
        validate(pickLottoNum, pickBonusNum);
        this.pickBonus = Integer.parseInt(pickBonusNum);
    }

    private void validate(Lotto pickLottoNum, String pickBonusNum) {
        validateInvalidInput(pickBonusNum);
        int bonusNum = Integer.parseInt(pickBonusNum);
        validateNumberRange(bonusNum);
        validateDuplicateNumber(pickLottoNum, bonusNum);
    }

    private void validateInvalidInput(String pickBonusNum) {
        try {
            Integer.parseInt(pickBonusNum);
        } catch (Exception e) {
            System.out.println(ErrorMessage.DATA_TYPE_ERR_MESSAGE.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.DATA_TYPE_ERR_MESSAGE.getErrorMessage());
        }
    }

    private void validateNumberRange(int bonusNum) {
        if (bonusNum < MIN_NUM || bonusNum > MAX_NUM) {
            System.out.println(NUMBER_RANGE_ERR);
            throw new IllegalArgumentException(NUMBER_RANGE_ERR);
        }
    }

    private void validateDuplicateNumber(Lotto pickLottoNum, int bonusNum) {
        if (pickLottoNum.checkBounsInclude(bonusNum)) {
            System.out.println(ErrorMessage.NUMBER_DUPLICATE_ERR.getErrorMessage());
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE_ERR.getErrorMessage());
        }
    }
}
