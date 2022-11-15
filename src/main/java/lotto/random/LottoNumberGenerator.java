package lotto.random;

import java.util.List;

public interface LottoNumberGenerator {
    int LOTTO_NUMBER_COUNT = 6;
    int RANDOM_START_NUMBER = 1;
    int RANDOM_END_NUMBER = 45;

    List<Integer> generate();
}
