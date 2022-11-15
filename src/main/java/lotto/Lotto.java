package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private static WinningNumber winningNumber;

    public Lotto(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 개수가 6개가 아닙니다.");
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public Rank lottoRank() {
        int matchWinningNumberCount = matchWinningNumbers();
        int matchBonusNumberCount = matchBonusNumber();
        int matchCount = matchWinningNumberCount + matchBonusNumberCount;

        if (matchCount == 6) {
            return Rank.FIRST;
        }
        if (matchCount == 5 && matchBonusNumberCount == 1) {
            return Rank.SECOND;
        }
        if (matchCount == 5) {
            return Rank.THIRD;
        }
        if (matchCount == 4) {
            return Rank.FOURTH;
        }
        if (matchCount == 3) {
            return Rank.FIFTH;
        }
        return Rank.MISS;
    }

    public int matchWinningNumbers() {

        return (int) numbers.stream()
                .filter(winningNumber.getWinningNumbers()::contains)
                .count();
    }

    public int matchBonusNumber() {
        return (int) numbers.stream().filter(number -> number == winningNumber.getBonusNumber()).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setWinningNumber(WinningNumber winningNumberWithUserInput) {
        winningNumber = winningNumberWithUserInput;
    }

}
