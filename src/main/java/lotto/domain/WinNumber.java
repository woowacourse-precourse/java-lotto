package lotto.domain;

import constants.ExceptionMessage;
import lotto.domain.dto.MatchResultDTO;

public class WinNumber {

    private final GeneralWinNumber generalWinNumber;
    private final BonusNumber bonusNumber;

    public WinNumber(GeneralWinNumber generalWinNumber, BonusNumber bonusNumber) {
        validate(generalWinNumber, bonusNumber);
        this.generalWinNumber = generalWinNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(GeneralWinNumber generalWinNumber, BonusNumber bonusNumber) {
        if (generalWinNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.CONTAIN_BONUS);
        }
    }

    public MatchResultDTO matching(Lotto lotto) {
        int matchCount = generalWinNumber.matchCount(lotto);
        boolean isMatchBonusNumber = bonusNumber.isMatch(lotto);

        return new MatchResultDTO(matchCount, isMatchBonusNumber);
    }

}
