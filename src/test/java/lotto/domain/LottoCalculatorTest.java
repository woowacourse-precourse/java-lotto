package lotto.domain;

import lotto.input.Input;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class LottoCalculatorTest {

    @Test
    void 계산_테스트() {
        Input input = new Input(10000, Arrays.asList(1, 2, 5, 7, 8, 15), 20);
        LottoCalculator lottoCalculator = new LottoCalculator(input);

    }

}