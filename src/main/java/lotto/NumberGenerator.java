package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public List<Integer> createWinningNumbers(String inputNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] splitNumbers = inputNumbers.split(",");
        for (String number : splitNumbers) {
            checkNumber(number);
            int winningNumber = Integer.parseInt(number);
            winningNumbers.add(winningNumber);
        }
        return winningNumbers;
    }

    public int createBonusNumbers(List<Integer> numbers, String inputNumber) {
        checkNumber(inputNumber);
        int bonusNumber = Integer.parseInt(inputNumber);
        checkScope(bonusNumber);
        checkOverlap(numbers, bonusNumber);
        return bonusNumber;
    }

    public void checkNumber(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("당첨 번호에 문자가 포함되어있습니다.");
        }
    }

    public void checkScope(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("1부터 45 사이 숫자를 입력하세요.");
        }
    }

    public void checkOverlap(List<Integer> numbers, int inputNumber) {
        if (numbers.contains(inputNumber)) {
            throw new IllegalArgumentException("당첨번호와 중복됩니다.");
        }
    }

    public List<Integer> createLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

}
