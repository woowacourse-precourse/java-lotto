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

        assertThat(Generator.purchasePrice()).isEqualTo(6000);
    }

    @Test
    @DisplayName("1,000원 단위 체크")
    void 천원단위_o() {
        assertThat(Generator.calculateLottoNum(22000)).isEqualTo(22);
    }

    @Test
    @DisplayName("1,000원 단위가 아닐 시 에러 발생")
    void 천원단위_x() {
        assertThrows(IllegalArgumentException.class, () -> Generator.calculateLottoNum(12345));
    }
}