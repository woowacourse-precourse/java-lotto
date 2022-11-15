package lotto;

import camp.nextstep.edu.missionutils.Randoms;

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
    public int[] countWinningResult(List<List<Integer>> userRandomNumber, int count, int[] matches) {
        for (int i = 0; i < count; i++) {
            int matchCount = checkWinningNumbers(userRandomNumber.get(i));
            matches = returnWinningResult(matchCount, matches);
        }

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

    // n개 일치 저장하기
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
            matches[3]++;
        }

        return matches;
    }

    public List<Integer> saveWinningNumbers(String[] tempWinningNumbers, int maxLottoLength) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < maxLottoLength; i++) {
            numbers.add(Integer.parseInt(tempWinningNumbers[i]));
        }

        return numbers;
    }
}
