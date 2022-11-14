package lotto;

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
    // 당첨 번호와 사용자 추첨 번호 일치 여부 확인
    private int checkWinningNumbers(List<Integer> userNumbers) {
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

    // 당첨 내역 출력
    public void printWinningResult(List<List<Integer>> randomNumber, int count) {
        for (int i = 0; i < count; i++) {
            int matchCount = checkWinningNumbers(randomNumber.get(i));
            System.out.println(matchCount);
        }
    }
}
