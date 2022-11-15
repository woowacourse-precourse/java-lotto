package lotto;

import java.util.List;

public class WinningLotto extends Lotto {

    private final Integer bonusNumber;

    public WinningLotto(List<Integer> numbers, Integer bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> numbers, Integer bonusNumber) {
        super.validate(numbers);

        validateBonusNumber(bonusNumber);
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBonusNumber(Integer bonusNumber) {

        if (bonusNumber <= 0) {
            throw new IllegalArgumentException("0이하의 숫자는 당첨번호가 될 수 없습니다.");
        }

        if (bonusNumber > 45) {
            throw new IllegalArgumentException("45보다 큰 숫자는 당첨번호가 될 수 없습니다.");
        }
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public CorrectType compareNumber(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();
        int correct = countCorrectNumber(lottoNumbers);

        CorrectType correctType = getCorrectType(lottoNumbers, correct);

        return correctType;
    }

    private int countCorrectNumber(List<Integer> lottoNumbers) {

        int count = 0;
        for (Integer num : lottoNumbers) {
            if (getNumbers().contains(num)) {
                count++;
            }
        }

        return count;
    }

    private CorrectType getCorrectType(List<Integer> lottoNumbers, int correct) {
        if (correct < 3) {
            return CorrectType.NOTHING;
        }

        if (correct == 3) {
            return CorrectType.TREE_CORRECT;
        }

        if (correct == 4) {
            return CorrectType.FOUR_CORRECT;
        }

        if (correct == 5 && isCorrectBonusNumber(lottoNumbers)) {
            return CorrectType.FIVE_AND_BONUS_CORRECT;
        }

        if (correct == 5) {
            return CorrectType.FIVE_CORRECT;
        }

        return CorrectType.ALL_CORRECT;
    }

    private Boolean isCorrectBonusNumber(List<Integer> lottoNumbers) {
        if (lottoNumbers.contains(this.bonusNumber)) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }


}
