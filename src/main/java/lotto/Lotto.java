package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Constant.MIN_NUMBER, Constant.MAX_NUMBER, Constant.SIZE);
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sorted = new ArrayList<>(numbers);
        Collections.sort(sorted);
        System.out.println(sorted);
        this.numbers = sorted;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> distinct = Set.copyOf(numbers);

        if (numbers.size() != Constant.SIZE) {
            throw new IllegalArgumentException(Constant.ERROR + " 서로 다른 " + Constant.SIZE + "가지 번호를 입력해 주세요");
        }

        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(
                        Constant.ERROR + " " + Constant.MIN_NUMBER + "과 "
                                + Constant.MAX_NUMBER + " 사이의 번호를 입력해 주세요.");
            }
        }

        if (distinct.size() != Constant.SIZE) {
            throw new IllegalArgumentException(Constant.ERROR + " 서로 다른 " + Constant.SIZE + "가지 번호를 입력해 주세요");
        }
    }
}
