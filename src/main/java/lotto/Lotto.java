package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // 5.로또 번호 출력
    public void getLottoNumbers() {
        System.out.println(this.numbers);
    }

    // 6.당첨 결과 (보너스 미포함)
    public int getLottoResult(List<Integer>winningNums, int countResult) {

        for (int idx = 0; idx < this.numbers.size(); idx++) {
            if (winningNums.contains(this.numbers.get(idx))) {
                countResult += 1;
            }
        }

        return countResult;
    }

    // 7.당첨 결과 (보너스 포함)
    public int getIncludingBonus(int bonusNum) {

        if(this.numbers.contains(bonusNum)) {
            return 1;
        }

        return 0;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
