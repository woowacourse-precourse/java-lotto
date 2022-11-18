package lotto.domain;

import lotto.utils.Converter;

import java.util.List;

import static lotto.resources.ValidationPattern.*;

public class LottoWinningNumber extends Lotto {
    private static final String EXCEPTION_MESSAGE = "1~45 사이 숫자를 입력해 주시기 바랍니다.";
    private final int bonusNumber;

    public LottoWinningNumber(Converter<String, List<Integer>> converter, String winningNumber, String bonus) {
        this(converter.convert(winningNumber), bonus);
    }

    private LottoWinningNumber(List<Integer> winningNumber, String bonusNumber) {
        super(winningNumber);
        this.bonusNumber = validate(bonusNumber);
    }

    public WinningResult getResult(IssuedLotto issuedLotto) {
        return issuedLotto.compare(super.getNumbers(), bonusNumber);
    }

    private int validate(String bonus) {
        int bonusNumber = validateInputIsNumber(bonus);
        return validateDuplicate(bonusNumber);
    }

    private int validateInputIsNumber(String bonus) {
        if (LOTTO_RANGE.isValid(bonus)) {
            return Integer.parseInt(bonus);
        }
        throw new IllegalArgumentException(EXCEPTION_MESSAGE);
    }

    private int validateDuplicate(int bonusNumber) {
        if (super.hasBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
        return bonusNumber;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", bonusNumber : " +
                bonusNumber;
    }
}
