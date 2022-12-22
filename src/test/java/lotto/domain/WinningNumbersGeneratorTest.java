package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class WinningNumbersGeneratorTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private WinningNumbersGenerator winningNumbersGenerator;

    @BeforeEach
    void setUp() {
        winningNumbersGenerator = new WinningNumbersGenerator();
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7", // ""은 어떻게 하지?
                            "1.2.3.4.5.6",
                            "a,2,3,4,5,b",
                            "1,1,2,3,4,5"})
    @DisplayName("입력 받은 당첨 번호를 검증한다.")
    void 당첨번호의_입력을_검증한다(String input) {
        assertThatThrownBy(() -> {
            run(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:abc", "1,2,3,4,5,6:46",
                        "1,2,3,4,5,6:-1"}, delimiter = ':')
    @DisplayName("입력 받은 보너스 번호를 검증한다.")
    void 보너스번호를_검증한다(String winning, String bonus) {
        assertThatThrownBy(() -> {
            run(winning, bonus);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_MESSAGE);
    }

    @Override
    public void runMain() {
        winningNumbersGenerator.generate();
    }
}
