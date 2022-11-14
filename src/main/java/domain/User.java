package domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class User {

    private final int inputUserMoney;

    private final int totalLotto;
    private final List<Lotto> totalLottoNumbers;

    public User(int inputUserMoney, int totalLotto, List<Lotto> totalLottoNumbers) {
        validateInputUserMoney(inputUserMoney);
        this.inputUserMoney = inputUserMoney;
        this.totalLotto = totalLotto;
        this.totalLottoNumbers = totalLottoNumbers;
    }

    public int getInputUserMoney() {
        return inputUserMoney;
    }

    public List<Lotto> getTotalLottoNumbers() {
        return totalLottoNumbers;
    }

    public int getTotalLotto() {
        return totalLotto;
    }

    private void validateInputUserMoney(int inputUserMoney) {
        if (inputUserMoney % 1000 != 0) throw new IllegalArgumentException(ErrorMessage.NOT_UNIT.getErrorMessage());
    }
}
