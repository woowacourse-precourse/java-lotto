package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    InputManager inputManager = new InputManager();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void view() {
        int repeatCount = inputManager.getMoney()/1000;
        for (int i = 0; i < repeatCount; i++) {
            createLotto(inputManager.getMoney());
            printLottoNumbers();
        }

    }

    private void printLottoNumbers() {
        System.out.println(numbers);
    }

    private void createLotto(int playerMoney) {
        numbers.clear();
        List<Integer> a;
        checkMoneyInputException(playerMoney);
        a = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        numbers.addAll(a);
    }

    private void checkMoneyInputException(int playerMoney) {
        if (playerMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
