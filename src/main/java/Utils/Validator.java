package Utils;

import domain.Message;

import java.util.HashSet;
import java.util.List;

public class Validator {

    public void sizeValidator(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Message.LOTTO_SIZE_ERROR.getMessage());
        }
    }

    public void checkNumberRange(int n) {
        if (n < 1 || n > 45) {
            throw new IllegalArgumentException(Message.NUMBER_RANGE_ERROR.getMessage());
        }
    }

    public void checkDuplication(List<Integer> lottoNumbers) {
        HashSet<Integer> hashSet = new HashSet<>(lottoNumbers);

        if (hashSet.size() != 6) {
            throw new IllegalArgumentException(Message.DUPLICATION_ERROR.getMessage());
        }
    }

    public void checkIfTheInputIsInteger(String digit) {
        if (!digit.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(Message.NUMBER_INPUT_ERROR.getMessage());
        }
    }

    public void validatePayment(String payment) {

        checkIfTheInputIsInteger(payment);

        if (Integer.parseInt(payment) % 1000 != 0) {
            throw new IllegalArgumentException(Message.PAYMENT_VALIDATION_ERROR.getMessage());
        }
    }
}
