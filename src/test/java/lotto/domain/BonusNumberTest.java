package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

class BonusNumberTest {
    OutputStream out = new ByteArrayOutputStream();
    InputStream in = System.in;

    @BeforeEach
    private final void init() {
        System.setOut(new PrintStream(out));
    }

    @DisplayName("getBonusNumber 메소드 테스트")
    @Nested
    class GetBonusNumber {
        @ParameterizedTest(name = "{0}가 들어왔을 때")
        @CsvSource(value = {"1, 1", "2, 2", "35, 35", "40, 40", "45, 45"})
        void 입력된_보너스번호가_잘_반환되는지_테스트(String target, int expected) {
            ByteArrayInputStream in = new ByteArrayInputStream(target.getBytes());
            System.setIn(in);
            BonusNumber bonusNumber = new BonusNumber();

            assertThat(bonusNumber.getBonusNumber()).isEqualTo(expected);
        }
    }
}