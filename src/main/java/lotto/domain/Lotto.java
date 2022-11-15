package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    protected void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.stream().filter(n -> 1 <= n && n <= 45).count() != 6) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 자연수여야 합니다.");
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != 6) {
            System.out.println("[ERROR] 로또 번호는 중복이 없어야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public Score compareWithWinningNumbers(WinningNumbers winningNumbers) {
        List<Integer> winning = winningNumbers.getNumbers();
        int bonus = winningNumbers.getBonus();

        int count = countMatchingNumber(winning);
        return convertToScore(count, bonus);
    }

    public int countMatchingNumber(List<Integer> winning) {
        return (int) winning.stream()
                .filter(numbers::contains)
                .count();
    }

    private Score convertToScore(int count, int bonus) {
        if (count < 3) return Score.NOTHING;
        if (count == 3) return Score.THREE;
        if (count == 4) return Score.FOUR;
        if (count == 5) return compareWithBonus(bonus);

        return Score.SIX;
    }

    private Score compareWithBonus(int bonus) {
        if (this.numbers.contains(bonus)) {
            return Score.FIVE_BONUS;
        }
        return Score.FIVE;
    }

    public void printNumbers(){
        System.out.println(numbers);
    }
}
