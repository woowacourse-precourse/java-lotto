package lotto.validator.impl;

import java.util.List;
import java.util.stream.Collectors;
import lotto.type.ErrorCode;
import lotto.type.LottoInformation;
import lotto.validator.integrated.WinningNumberInputValidator;

public class WinningNumberInputValidatorImpl implements WinningNumberInputValidator {

    @Override
    public void validate(final List<String> targets) throws IllegalArgumentException {
        if (!isAllNumeric(targets)) {
            throw new IllegalArgumentException(ErrorCode.NON_NUMERIC_VALUE.getMessage());
        }
        List<Integer> targetNumbers = parseTargetsToInteger(targets);
        if (!isAllInRange(targetNumbers)) {
            throw new IllegalArgumentException(ErrorCode.TOO_BIG_OR_TOO_SMALL_VALUE.getMessage());
        }
        if (!isValidSize(targetNumbers, LottoInformation.SIZE.value())) {
            throw new IllegalArgumentException(ErrorCode.LOTTO_SIZE_ERROR.getMessage());
        }
        if (!isDuplicate(targetNumbers)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_ERROR.getMessage());
        }
    }

    private boolean isAllNumeric(final List<String> targets) {
        for (String target : targets) {
            if (!isNumeric(target)) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllInRange(final List<Integer> targetNumbers) {
        for (Integer targetNumber : targetNumbers) {
            if (!isInRange(targetNumber, LottoInformation.START.value(),
                LottoInformation.END.value())) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> parseTargetsToInteger(final List<String> targets) {
        return targets.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
