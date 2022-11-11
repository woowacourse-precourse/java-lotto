package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
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

    /**
     * 로또번호의 길이와 중복을 체크해 유효한지 검사하는 함수 <br/>
     * 유효하지 않은경우 IllegalArgumentException 발생
     *
     * @param numbers 로또번호
     */
    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTERY_NUMBER_LENGTH || hasDuplicated(numbers)) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 중복되지 않는 %d ~ %d의 숫자 %d개로 구성되어야 합니다.", LOTTERY_START_NUMBER, LOTTERY_END_NUMBER, LOTTERY_NUMBER_LENGTH));
        }

    }


    /**
     * numbers가 중복되는 값을 가지고 있는지 판단하는 함수
     *
     * @return 중복된 값이 있으면 true, 없으면 false
     */
    public boolean hasDuplicated(List<Integer> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    // TODO: 추가 기능 구현
}
