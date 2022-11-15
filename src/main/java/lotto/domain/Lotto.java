package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        overlapCheck(numbers);
        List<Integer> sortNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            sortNumbers.add(numbers.get(i));
        }
        Collections.sort(sortNumbers);
        this.numbers = sortNumbers;
        show();
    }

    public static List<Lotto> createLotto(int number) {
        List<Lotto> allLotto = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            allLotto.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return allLotto;
    }

    public static int calculate(String input) {
        int money = Integer.valueOf(input);
        if (money % 1000 == 0) {
            return money / 1000;
        }
        throw new IllegalArgumentException("구입 금액은 1000원 단위만 가능합니다.");
    }

    public static void checkIsInt(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("구입 금액 입력은 숫자만 가능합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호의 개수는 6개여야 합니다.");
        }
    }

    private void overlapCheck(List<Integer> numbers) {
        Set<Integer> setNumber = new HashSet<>(numbers);
        if (numbers.size() != setNumber.size()) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    private void show() {
        System.out.println(this.numbers);
    }
}
