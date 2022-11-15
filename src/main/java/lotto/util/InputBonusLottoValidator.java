package lotto.util;

import java.util.List;

public class InputBonusLottoValidator {

    public static void validateInputBonusLotto(List<Integer> lotto, String bonusLotto) {
        LottoNumberFormatValidator.validateInteger(bonusLotto);
        Integer bonusLottoNumber = Integer.parseInt(bonusLotto);
        LottoNumberFormatValidator.validateLottoNumberFormat(bonusLottoNumber);
        validateDuplicate(lotto, bonusLottoNumber);
    }

    static void validateDuplicate(List<Integer> lotto, Integer inputBonusLotto) {
        if (lotto.contains(inputBonusLotto)) {
            throw new IllegalArgumentException("보너스 로또 번호가 로또 번호와 중복되지 않아야 합니다.");
        }
    }
}