package lotto;

import camp.nextstep.edu.missionutils.Randoms;

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

    public List<Integer> getNumbers(){
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return numbers;
    }

    public int isMatch(int number){
        if (numbers.contains(number)){
            return 1;
        }
        return 0;
    }

    public int howManyMatch(Lotto lotto){
        int countOfMatch = 0;

        for (int number : numbers){
            countOfMatch += Lotto.isMatch(number);
        }
        return countOfMatch;
    }
}
