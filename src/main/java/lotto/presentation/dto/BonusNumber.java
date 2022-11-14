package lotto.presentation.dto;

import lotto.domain.repository.LottoRepository;
import lotto.support.Validator;

import java.util.List;

public class BonusNumber {
    private static final int NUMBER_OF_DIGIT=1;
    private final LottoRepository lottoRepository;
    private final Integer bonusNumber;

    public BonusNumber(String bonusNumber){
        lottoRepository=LottoRepository.getInstance();
        validate(bonusNumber);
        this.bonusNumber=Integer.parseInt(bonusNumber);
    }
    private void validate(String target){
        Validator.checkInteger(target);
        Validator.checkNumberOfDigit(NUMBER_OF_DIGIT, List.of(Integer.parseInt(target)));
        Validator.checkNumericalRange(List.of(Integer.parseInt(target)));
        Validator.checkBonusDuplicate(Integer.parseInt(target),lottoRepository.getWinnerNumber().getWinnerNumber());
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
