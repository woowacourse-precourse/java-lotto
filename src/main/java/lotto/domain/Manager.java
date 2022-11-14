package lotto.domain;

import lotto.domain.enums.Number;
import lotto.util.ExceptionHandler;
import java.util.ArrayList;
import java.util.List;

public class Manager {

    private List<Integer> winningNumbers = new ArrayList<>();
    private int bonusNumber;

    public void setWinningNumbers(String input) {
        String[] numbers = input.split(ExceptionHandler.COMMA);
        for (String number : numbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public void setBonusNumber(String input) {
        int bonusNumber = Integer.parseInt(input);
        this.bonusNumber = bonusNumber;
    }

    public int countCorrect(Lotto userLotto) {
        List<Integer> lottoNumbers = userLotto.getNumbers();

        int correctCount = 0;
        for (int index = 0; index < lottoNumbers.size(); index++) {
            Integer userLottoNumber = lottoNumbers.get(index);
            if (isCorrectNumber(userLottoNumber)) {
                correctCount++;
            }
        }
        return correctCount;
    }

    private boolean isCorrectNumber(Integer userLottoNumber) {
        return winningNumbers.contains(userLottoNumber);
    }

    public boolean isCorrectBonus(Lotto userLotto) {
        List<Integer> numbers = userLotto.getNumbers();
        return numbers.contains(bonusNumber);
    }
}
