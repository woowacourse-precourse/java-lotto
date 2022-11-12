package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_GAME_START_NUMBER = 1;
    private static final int LOTTO_GAME_END_NUMBER = 45;
    private static final int LOTTO_GAME_NUMBER_SIZE = 6;
    private final List<Integer> randomNumbers;

    public LottoMachine() {
        this.randomNumbers = sortRandomNumbers(generateRandomNumbers());
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_GAME_START_NUMBER,
                LOTTO_GAME_END_NUMBER, LOTTO_GAME_NUMBER_SIZE);
    }

    private List<Integer> sortRandomNumbers(List<Integer> numbers) {
        return numbers.stream().sorted().collect(Collectors.toList());
    }
}
