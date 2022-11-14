package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(){
        numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
    }
    public Lotto(List<Integer> numbers) {
        isValidList(numbers);
        this.numbers = numbers;
    }

    protected static boolean isBetween1And45(int num) {
        return (0 < num) && (num < 46);
    }

    protected static boolean containsOnce(List<Integer> numberList, int number) {
        return numberList.stream().filter(x -> {
            return x == number;
        }).count() == 1;
    }

    protected static void isValidList(List<Integer> numberList) {
        if (numberList.size() != 6)
            throw new IllegalArgumentException("[ERROR] Lottery Numbers size must be 6");
        if (!numberList.parallelStream().allMatch(x -> containsOnce(numberList, x)))
            throw new IllegalArgumentException("[ERROR] Number must be Once");
        if (!(numberList.parallelStream().allMatch(Lotto::isBetween1And45)))
            throw new IllegalArgumentException("[ERROR] Number must between 1 and 45");
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    @Override
    public String toString(){
        return numbers.toString();
    }

}
