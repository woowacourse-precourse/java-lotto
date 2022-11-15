package lotto;

import java.util.Arrays;
import java.util.List;

public enum ValidationGroup {
    LOTTO_NUMBERS("numbers", Arrays.asList(ValidationType.CHECK_DUPLICATE_NUMBERS,
            ValidationType.CHECK_SIZE_NUMBERS, ValidationType.CHECK_RANGE_NUMBERS));

    private String inputType;
    private List<ValidationType> validationTypeList;

    ValidationGroup(String inputType, List<ValidationType> validationTypeList) {
        this.inputType = inputType;
        this.validationTypeList = validationTypeList;
    }

    public List<ValidationType> getValidationTypeList() {
        return validationTypeList;
    }

    public static Boolean validate(List<Integer> numbers) {
        for (ValidationType validationType: LOTTO_NUMBERS.getValidationTypeList()) {
            if (!validationType.validateNumbers(numbers)) {
                return false;
            }
        }
        return true;
    }
}
