package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BonusNumberTest {
    OutputStream out = new ByteArrayOutputStream();
    InputStream in = System.in;

    @BeforeEach
    private final void init() {
        System.setOut(new PrintStream(out));
    }

    @DisplayName("보너스 번호 입력이 들어왔을 때")
    @Nested
    class GetBonusNumber {
        @ParameterizedTest(name = "{0}가 들어왔을 때")
        @CsvSource(value = {"1, 1", "2, 2", "35, 35", "40, 40", "45, 45"})
        void getBonusNumber(String target, int expected) {
            ByteArrayInputStream in = new ByteArrayInputStream(target.getBytes());
            System.setIn(in);
            BonusNumber bonusNumber = new BonusNumber();

            assertThat(bonusNumber.getBonusNumber()).isEqualTo(expected);
        }
    }
}