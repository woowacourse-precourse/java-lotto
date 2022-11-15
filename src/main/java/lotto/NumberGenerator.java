package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private static final int COUNT = 6;

    public List<Integer> createWinningNumbers(List<String> inputNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : inputNumbers) {
            checkNumber(number);
            int winningNumber = Integer.parseInt(number);
            winningNumbers.add(winningNumber);
        }
        return winningNumbers;
    }

    public int createBonusNumbers(List<Integer> numbers, int inputNumber) {
        checkScope(inputNumber);
        checkOverlap(numbers, inputNumber);
        return inputNumber;
    }

    public void checkNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("당첨 번호에 문자가 포함되어있습니다.");
        }
    }

    public void checkScope(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException("1부터 45 사이 숫자를 입력하세요.");
        }
    }

    public void checkOverlap(List<Integer> numbers, int inputNumber) {
        if (numbers.contains(inputNumber)) {
            throw new IllegalArgumentException("당첨번호와 중복됩니다.");
        }
    }

    public List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN, MAX, COUNT);
    }
}
