package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개 입니다.");
            throw new IllegalArgumentException();
        }

        if (hasSameNumber(numbers)) {
            System.out.println("[ERROR] 로또 번호는 중복되지 않는 수로 구성되어 있습니다.");
            throw new IllegalArgumentException();
        }

        if (!isInRange(numbers)) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private List<Integer> sort() {
        List<Integer> result = new ArrayList<>(this.numbers);

        Collections.sort(result, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2)
                    return -1;
                else if (o1 > o2)
                    return 1;
                return 0;
            }
        });

        return result;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        String result = "";
        result += sort().toString();
        return result;
    }

    public Rank countSameNumber(Lotto winningLotto, int bonusNumber) {
        int count = 0;
        List<Integer> winningNumbers = winningLotto.getNumbers();

        for (int number : numbers) {
            if (winningNumbers.contains(number))
                count++;
        }

        if (count == 5 && numbers.contains(bonusNumber))
            count += 2;

        return getRank(count);
    }

    private Rank getRank(int count) {
        if (count == Rank.FIRST.getCount())
            return Rank.FIRST;
        else if (count == Rank.SECOND.getCount())
            return Rank.SECOND;
        else if (count == Rank.THIRD.getCount())
            return Rank.THIRD;
        else if (count == Rank.FOURTH.getCount())
            return Rank.FOURTH;
        else if (count == Rank.FIFTH.getCount())
            return Rank.FIFTH;
        return Rank.NONE;
    }

    private boolean hasSameNumber(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.indexOf(numbers.get(i)) != i)
                return true;
        }

        return false;
    }

    private boolean isInRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number > 45 || number < 1)
                return false;
        }

        return true;
    }
}
