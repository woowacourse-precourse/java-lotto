package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GeneratorTest {

    Generator generator;

    public static InputStream getPlayerInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    void beforeEach() {
        generator = new Generator();
    }

    @ParameterizedTest
    @DisplayName("숫자 입력 테스트")
    @ValueSource(strings = {"6000"})
    void checkInput(String input) {
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        assertThat(generator.purchasePrice()).isEqualTo(6000);
    }

    @Test
    @DisplayName("1,000원 단위 체크")
    void correctInput() {
        assertThat(generator.checkValidation("22000")).isEqualTo(true);
    }

    @ParameterizedTest
    @DisplayName("1,000원 단위가 아닐 시 에러 발생")
    @ValueSource(strings = {"12345", "가나다", "", "1200"})
    void incorrectInput(String input) {
        assertThrows(IllegalArgumentException.class, () -> generator.checkValidation(input));
    }

    @ParameterizedTest
    @DisplayName("구입 금액에 따른 로또 개수 구하기")
    @ValueSource(strings = {"2000", "19000"})
    void countLottoNum(String input) {
        int n;
        InputStream in = getPlayerInput(input);
        System.setIn(in);

        n = generator.calculateLottoNum(generator.purchasePrice());
        Assertions.assertThat(n).isEqualTo(Integer.parseInt(input)/1000);
    }
}