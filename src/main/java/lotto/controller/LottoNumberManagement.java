package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberManagement {
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int LOTTO_NUMBERS_SIZE = 6;

    private List<Integer> numbers;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoNumberManagement() {

    }

    private void init(){
        numbers.clear();
    }
    public void setRandomNumbers() {
        this.numbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBERS_SIZE);
    }

    public List<Integer> getRandomNumbers(){
        return numbers;
    }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }


    private void validate(List<Integer> numbers) {
        checkNumbersRange(numbers);
        checkDuplicateNumbers(numbers);
    }

    private void validateBonusNumber(int bonusNumber) {
        checkBonusNumbersRange(bonusNumber);
        checkDuplicateBonusNumber(winningNumbers, bonusNumber);
    }

    private void checkNumbersRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (LOTTO_START_NUMBER > number || number > LOTTO_END_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void checkDuplicateNumbers(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호를 사용하지 않아야 합니다.");
        }
    }

    private void checkBonusNumbersRange(int number) {
        if (LOTTO_START_NUMBER > number || number > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private void checkDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 겹치지 않아야 합니다");
        }
    }

    private List<Integer> sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }
}
