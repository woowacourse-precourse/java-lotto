package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 들어올 수 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void generateBonusNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 45);
        for (Integer n : randomNumbers) {
            if (!this.numbers.contains(n)) {
                this.bonusNumber =  n;
                break;
            }
        }
    }

    public void generateBonusNumber(String number) {
        this.bonusNumber = Integer.parseInt(number);
    }

    public boolean isOverlappedNumbersAndBonusNumber() {
        return numbers.contains(bonusNumber);
    }

    public int getLottoNumber(int idx) {
        return numbers.get(idx);
    }

    public String getLottoNumbers() {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        Collections.sort(copiedNumbers);
        return copiedNumbers.toString();
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
