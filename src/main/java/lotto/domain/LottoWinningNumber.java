package lotto.domain;

import static lotto.view.InputView.inputBonusNumber;
import static lotto.view.InputView.inputWinningNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoWinningNumber {
    private final Lotto winningNumbers;
    private final int bonusNumber;

    LottoWinningNumber() {
        List<Integer> winningNumbers = generateWinningNumbers();
        this.winningNumbers = new Lotto(winningNumbers);

        int bonusNumber = inputBonusNumber();
        hasBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers.getNumbers();
    }

    private List<Integer> generateWinningNumbers() {
        String inputWinningNumbers = inputWinningNumbers();
        List<String> separatedInputString = separateStringByComma(inputWinningNumbers);
        isDigit(separatedInputString);
        List<Integer> winningNumbers = convertStringToInteger(separatedInputString);
        validateFittingInRange(winningNumbers);
        return winningNumbers;
    }

    private List<String> separateStringByComma(String inputWinningNumbers) {
        List<String> separatedString = Arrays.asList(inputWinningNumbers.split(","));
        if (separatedString.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구분자를 확인해주세요.");
        }
        return separatedString;
    }

    private List<Integer> convertStringToInteger(List<String> inputWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();

        for (String number : inputWinningNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    private void isDigit(List<String> winningNumbers) {
        for (String number : winningNumbers) {
            if (!number.matches("-?\\d+")) {
                throw new IllegalArgumentException("[ERROR] 정수를 입력해 주세요.");
            }
        }
    }

    private void validateFittingInRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 숫자는 1~45 사이 숫자여야 합니다.");
            }
        }
    }

    private void hasBonusNumber(int bonusNumber) {
        if (this.winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 보너스 번호가 있습니다.");
        }
    }

}
