package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers){
        validateNumberLength(numbers);
        validateNumberReplicate(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return this.numbers;
    }

    public void validateNumberLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 당첨 번호는 6개여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberReplicate(List<Integer> numbers) {
        Set<Integer> independentNumbers = new HashSet<>(numbers);

        if (independentNumbers.size() != numbers.size()) {
            System.out.println("[ERROR] 로또 번호는 중복될 수 없습니다.");
            throw new IllegalArgumentException();
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                System.out.println("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public int compareWithWinNumber(WinNumber WinNumber) {

        ArrayList<Integer> correctNumbers = new ArrayList<>(WinNumber.getWinNumber().getLotto());
        correctNumbers.retainAll(this.numbers);

        return correctNumbers.size();
    }

    public boolean compareWithBonusNumber(BonusNumber bonusNumber) {

        boolean containBonusNumber = this.numbers.contains(bonusNumber.getBonusNumber());

        return containBonusNumber;
    }
}
