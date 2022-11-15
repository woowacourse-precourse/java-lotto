package lotto.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoSystemTest2 extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final LottoSystem lottoSystem = new LottoSystem();

    @Test
    @DisplayName("예외 - 로또 추첨하기")
    void drawLottoTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    runException("8000", "1, 2, 삼, 4, 5, 6", "7");
                    assertThat(output()).contains(ERROR_MESSAGE);

                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    protected void runMain() {
        lottoSystem.purchaseLotto();
        lottoSystem.drawLotto();
    }
}