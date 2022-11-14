package lotto;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public void sellLotto() {
    }

    private void validateInputMoney() {
    }

    // 로또를 발행한다.
    private Lotto issueLotto() {
        List<Integer> numbers = Lotto.generateRandomNumbers();
        return new Lotto(numbers);
    }

    private void sortLotto() {
    }

    private void printLottoInform() {
    }

    public void checkPrize() {
    }
}