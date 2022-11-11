package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
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
            throw new IllegalArgumentException(ErrMsg.VALIDATE_LOTTO_NUM);
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_LOTTO_NUM);
        }
    }

    // TODO: 추가 기능 구현
    //로또 발행
    public static List<Lotto> getLotto(String budget) {
        List<Lotto> lottos = new ArrayList<>();
        int publishNum = getPublishNum(budget);

        while (lottos.size() < publishNum) {
            lottos.add(new Lotto(getLottoNum()));
        }

        validateLotto(lottos, publishNum);

        return lottos;
    }

    private static int parseBudget(String budget) {
        return Integer.parseInt(budget);
    }

    public static int getPublishNum(String budget) {
        return parseBudget(budget) / 1000;
    }

    private static List<Integer> getLottoNum() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

        return sortNumbers(numbers);
    }

    public static List<Integer> sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());

        return numbers;
    }

    public static void validateLotto(List<Lotto> lotto, int publishNum) {
        if (lotto.size() != publishNum) {
            throw new IllegalArgumentException(ErrMsg.VALIDATE_LOTTO_SIZE);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
