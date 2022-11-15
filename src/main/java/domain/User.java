package domain;


import view.ErrorMessage;

import java.util.List;

public class User {

    private final int inputMoney;

    private final int totalCount;
    private final List<Lotto> totalNumbers;

    public User(int inputMoney, int totalCount, List<Lotto> totalNumbers) {
        validateInputMoney(inputMoney);
        this.inputMoney = inputMoney;
        this.totalCount = totalCount;
        this.totalNumbers = totalNumbers;
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public List<Lotto> getTotalNumbers() {
        return totalNumbers;
    }

    public int getTotalCount() {
        return totalCount;
    }

    private void validateInputMoney(int inputMoney) {
        if (inputMoney % 1000 != 0) throw new IllegalArgumentException(ErrorMessage.NOT_UNIT.getErrorMessage());
    }
}
