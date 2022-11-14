package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    private final List<Integer> numbers;
    private int bonusNumber;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateNumbersAreUnique(numbers);

        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 숫자만 들어올 수 있습니다.");
        }
    }

    // TODO: 추가 기능 구현
    public void generateBonusNumber() {
        this.bonusNumber = lottoNumberGenerator.generateBonusNumber(numbers);
    }
    public void generateBonusNumber(String number) {
        this.bonusNumber = Integer.parseInt(number);
    }

    public String getLottoNumbers() {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        Collections.sort(copiedNumbers);
        return copiedNumbers.toString();
    }

    public void validateNumbersAreUnique(List<Integer> numbers) {
        int originalNumberLength = numbers.size();
        HashSet<Integer> uniqueNumberLength = new HashSet<>(numbers);
        if (originalNumberLength != uniqueNumberLength.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자는 들어올 수 없습니다.");
        }
    }

    public int getLottoNumber(int idx) {
        return numbers.get(idx);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
