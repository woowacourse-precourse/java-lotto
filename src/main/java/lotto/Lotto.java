package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int LOTTERY_START_NUMBER = 1;
    private static final int LOTTERY_END_NUMBER = 45;
    private static final int LOTTERY_NUMBER_LENGTH = 6;

    public static List<Lotto> generateLotteries(int size) {
        List<Lotto> Lotteries = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Lotteries.add(generateLottery());
        }
        return Lotteries;
    }

    private static Lotto generateLottery() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTERY_START_NUMBER, LOTTERY_END_NUMBER, LOTTERY_NUMBER_LENGTH);
        return new Lotto(numbers);
    }

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
