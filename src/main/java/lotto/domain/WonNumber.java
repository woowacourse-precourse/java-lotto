package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WonNumber {
    public List<Integer> wonNumber = new ArrayList<>();

    public InPutSystem inPutSystem = new InPutSystem();

    public WonNumber() {
        sixNumber();
        validate(wonNumber);
    }

    public void sixNumber() {
        for (String numbers : inPutSystem.inputNumber().split(",")) {
            wonNumber.add(Integer.parseInt(numbers));
        }
    }

    public void bonusNumber() {
        int bonusNumber = Integer.parseInt(inPutSystem.inputNumber());
        BonusNumber.BONUS_NUMBER.setNumber(bonusNumber);
    }

    public void validate(List<Integer> wonNumber) {

        if (wonNumber.size() != 6) {
            throw new IllegalArgumentException(PrintMessages.ERROR_SIZE.getMessage());
        }
        if (wonNumber.size() != wonNumber.stream().distinct().count()) {
            throw new IllegalArgumentException(PrintMessages.ERROR_DUPLICATE.getMessage());
        }
    }

    public List<Integer> getWonNumber() {
        return wonNumber;
    }
}
