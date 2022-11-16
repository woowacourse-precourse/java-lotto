package lotto.dto;

import lotto.Validation;

import java.util.List;

public class LottoResultDto {
    private static final Validation validator = new Validation();
    private final List<Integer> basicNumbers;
    private final Integer bonusNumber;

    public LottoResultDto(List<Integer> basicNumbers, Integer bonusNumber) {
        validator.validateBasicNumber(basicNumbers);
        validator.validateBonusNumber(basicNumbers, bonusNumber);
        this.basicNumbers = basicNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getBasicNumbers() {
        return basicNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

}
