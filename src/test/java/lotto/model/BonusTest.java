package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusTest {
    //@ParameterizedTest
    @ValueSource(strings = {"46"})
    void 보너스_번호_범위_아님_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(Bonus::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

    //@ParameterizedTest
    @ValueSource(strings = {"hibabe"})
    void 보너스_번호_숫자_아님_테스트(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(Bonus::new)
                .isInstanceOf(IllegalArgumentException.class);
    }

}