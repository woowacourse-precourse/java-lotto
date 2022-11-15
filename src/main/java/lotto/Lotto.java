package lotto;

import java.util.ArrayList;
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
    }

    // TODO: 추가 기능 구현
    // 당첨 번호와 사용자 추첨 번호 일치 결과 저장
    public int[] countWinningResult(List<List<Integer>> userRandomNumbers, int count, int[] matches, int bonusNumber) {
        for (int i = 0; i < count; i++) {
            int matchCount = checkWinningNumbers(userRandomNumbers.get(i));
            matches = countMatching(userRandomNumbers.get(i), bonusNumber, matchCount, matches);
        }

        return matches;
    }

    // 보너스 번호랑 일치하는지 체크
    public int[] countMatching(List<Integer> userRandomNumbers, int bonusNumber, int matchCount, int[] matches) {
        if (matchCount >= 5 && checkMatchWithBonusNumber(userRandomNumbers, bonusNumber)) {
            matches[3]++;
            return matches;
        }
        matches = returnWinningResult(matchCount, matches);
        return matches;
    }


    // 당첨 번호와 사용자 추첨 번호 일치 여부 확인
    public int checkWinningNumbers(List<Integer> userNumbers) {
        int matchCount = 0;

        for (int i = 0; i < userNumbers.size(); i++) {
            for (int j = 0; j < numbers.size(); j++) {
                if (numbers.get(j) == userNumbers.get(i)) {
                    matchCount++;
                    break;
                }
            }
        }

        return matchCount;
    }

    // 일치 결과 리턴
    public int[] returnWinningResult(int matchCount, int[] matches) {
        if (matchCount == 3) {
            matches[0]++;
        }

        if (matchCount == 4) {
            matches[1]++;
        }

        if (matchCount == 5) {
            matches[2]++;
        }

        if (matchCount == 6) {
            matches[4]++;
        }

        return matches;
    }

    // 보너스 번호 일치 여부 확인
    public boolean checkMatchWithBonusNumber(List<Integer> userRandomNumbers, int bonusNumber) {
        boolean isMatch = false;

        for (int i = 0; i < 6; i++) {
            isMatch = isMatchWithBonusNumber(userRandomNumbers.get(i), bonusNumber);
        }
        return isMatch;
    }

    // 해당 숫자가 보너스 번호와 일치하나요?
    public boolean isMatchWithBonusNumber(int userRandomNumber, int bonusNumber) {
        if (userRandomNumber == bonusNumber) {
            return true;
        }

        return false;
    }
}
