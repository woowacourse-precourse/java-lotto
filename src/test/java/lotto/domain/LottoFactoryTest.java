package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("lottoFactory는 Lotto 객체를 생성한다.")
    void createLotto() {
        LottoFactory lottoFactory = new LottoFactory();

        assertThat(lottoFactory.createLotto())
                .isInstanceOf(Lotto.class);
    }
}