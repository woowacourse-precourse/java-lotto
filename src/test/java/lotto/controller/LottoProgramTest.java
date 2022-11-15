package lotto.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.controller.LottoProgram;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class LottoProgramTest extends NsTest {
    LottoProgram lottoProgram = new LottoProgram();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("중복된 당첨번호를 입력하면 예외가 발생한다.")
    @Test
    void inputWinningNumberByDuplicatedNumber() {
        Assertions.assertThatThrownBy(
                () -> assertRandomUniqueNumbersInRangeTest(
                        () -> {
                            run("8000", "1,2,3,4,5,5", "7");
                            assertThat(output()).contains();
                        },
                        List.of(8, 21, 23, 41, 42, 43))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개가 아닌 당첨번호를 입력하면 예외가 발생한다.")
    @Test
    void inputWinningNumberBySizeOver() {
        Assertions.assertThatThrownBy(
                () -> assertRandomUniqueNumbersInRangeTest(
                        () -> {
                            run("1000", "1,2,3,4", "7");
                            assertThat(output()).contains();
                        },
                        List.of(8, 21, 23, 41, 42, 43))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 보너스 번호를 입력하면 예외가 발생한다.")
    @Test
    void inputBonusNumberOverRange() {
        Assertions.assertThatThrownBy(
                () -> assertRandomUniqueNumbersInRangeTest(
                        () -> {
                            run("8000", "47,2,3,4,5,5", "7");
                            assertThat(output()).contains();
                        },
                        List.of(8, 21, 23, 41, 42, 43))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        lottoProgram.run();
    }
}