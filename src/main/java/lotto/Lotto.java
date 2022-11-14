package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    InputManager inputManager = new InputManager();
    int matchCount;
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

    public void buyLotto() {
        int repeatCount = inputManager.getMoney()/1000;
        matchCount = 0;
        for (int i = 0; i < repeatCount; i++) {
            createLotto(inputManager.getMoney());
            printLottoNumbers();
        }
        for (int i = 0; i < 6; i++) {
            calculateMatchCount(inputManager.getAnswerNumbers().get(i));
        }
    }

    private void calculateMatchCount(Integer a) {
        if(numbers.contains(a)){
            matchCount++;
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
