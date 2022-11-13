package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    InputManager inputManager = new InputManager();
    private final List<Integer> numbers; // 여기서부터

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) { // 여기까지는 당첨 번호들을 위한 것들
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void view() {
        createLotto(inputManager.getMoney());
        printLottoNumbers();
    }

    private void printLottoNumbers() {
        System.out.println(numbers);
    }

    private void createLotto(int playerMoney) {
        numbers.clear();
        List<Integer> a;
        checkMoneyInputException(playerMoney);
        a = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        for (int i = 0; i < numbers.size(); i++) {
            numbers.add(a.get(i));
        }
    }

    private void checkMoneyInputException(int playerMoney) {
        if (playerMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }
}
