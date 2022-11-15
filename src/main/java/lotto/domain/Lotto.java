package lotto.domain;

import lotto.validator.Validator;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Validator.checkLottoNumbers(numbers);
    }

    public void printNumbers() {
        System.out.println(numbers);
    }

    public int compareWithWinningNumber(List<Integer> winningNumber) {
        int sameNumberCount = 0;

        for (int i=1; i<46; i++) {
            if (numbers.contains(i) && winningNumber.contains(i)) {
                sameNumberCount++;
            }
        }

        return sameNumberCount;
    }

    public boolean checkBonusNumber(int bonusNumber) {
        boolean containBonusNumber = false;

        if (numbers.contains(bonusNumber) == true) {
            containBonusNumber = true;
        }

        return containBonusNumber;
    }

    public Rank calculateRank(List<Integer> winningNumber, int bonusNumber) {
        int sameNumberCount = compareWithWinningNumber(winningNumber); // 같은 번호 카운트 결과
        boolean hasBonusNumber = checkBonusNumber(bonusNumber); // 보너스 번호 포함 여부

        if (sameNumberCount==6) {
            return Rank.FIRST_PLACE;
        } else if (sameNumberCount==5 && hasBonusNumber==true) {
            return Rank.SECOND_PLACE;
        } else if (sameNumberCount==5 && hasBonusNumber==false) {
            return Rank.THIRD_PLACE;
        } else if (sameNumberCount==4) {
            return Rank.FOURTH_PLACE;
        } else if (sameNumberCount==3) {
            return Rank.FIFTH_PLACE;
        }
        return Rank.NO_PLACE; // 그 외 경우 6등 이하 (NO_PLACE) 반환
    }
}
