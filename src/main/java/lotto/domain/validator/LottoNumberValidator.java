package lotto.domain.validator;

import java.util.Arrays;
import java.util.stream.Stream;
import lotto.util.ErrorMessages;

public class LottoNumberValidator {
    public void validateFomula(final String inputValue) {
        checkingSeparator(inputValue);
        checkingNotNumber(inputValue);
        checkingRange(inputValue);
        checkingQuantity(inputValue);
        checkingOverlap(inputValue);
    }

    public void validateBonus(final String inputValue) {
        checkingSingleNumber(inputValue);
        checkingNotNumber(inputValue);
        checkingRange(inputValue);
    }


    // 1차 : 쉼표로 split했는데 다른 구분자 있을 때
    public void checkingSeparator(final String inputValue) {
        String[] splitValues = inputValue.split(",");
        for (String value : splitValues) {
            value = value.trim();
            if (!value.matches("[0-9a-zA-Z]")) {
                throw new IllegalArgumentException(ErrorMessages.WRONG_SEPARATOR.getMessage());
            }
        }
    }

    // 2차 : 숫자값이 맞는지
    public void checkingNotNumber(final String inputValue) {
        String[] splitValues = inputValue.split(",");
        for (String value : splitValues) {
            value = value.trim();
            if (!value.matches("[0-9]")) {
                throw new IllegalArgumentException(ErrorMessages.NOT_NUMBER_EXIST.getMessage());
            }
        }
    }

    // 3차 : 1~45 범위가 맞는지
    public void checkingRange(final String inputValue) {
        String[] splitValues = inputValue.split(",");
        for (String value : splitValues) {
            value = value.trim();
            int number = Integer.parseInt(value);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorMessages.OUT_OF_BOUND.getMessage());
            }
        }
    }

    // 4차 : 6개가 맞는지
    public void checkingQuantity(final String inputValue) {
        String[] splitValues = inputValue.split(",");
        if (splitValues.length > 6) {
            throw new IllegalArgumentException(ErrorMessages.MORE_THAN_SIX.getMessage());
        } else if (splitValues.length < 6) {
            throw new IllegalArgumentException(ErrorMessages.LESS_THAN_SIX.getMessage());
        }
    }

    // 5차 : 중복값 여부 - 중복값 제거했는데 6개 미만일 때
    public void checkingOverlap(final String inputValue) {
        Stream<String> deduplicatedNumbers = Arrays.stream(inputValue.split(",")).distinct();
        if (deduplicatedNumbers.count() < 6) {
            throw new IllegalArgumentException(ErrorMessages.HAS_OVERLAP_NUMBER.getMessage());
        }
    }

    public void checkingSingleNumber(final String inputValue) {
        String[] splitValues = inputValue.split("");
        for (String value : splitValues) {
            if (value.matches("[^0-9]") || value.isBlank() ){
                throw new IllegalArgumentException(ErrorMessages.NOT_SINGLE_NUMBER.getMessage());
            }
        }
//        try{
//            Integer.parseInt(trimValue);
//        }catch( NumberFormatException e){
//            throw new IllegalArgumentException();
//        }
    }
}
