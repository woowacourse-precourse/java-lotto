package lotto.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoManagerTest {
    private LottoManager lottoManager;

    @BeforeEach
    void setUp() {
        lottoManager = new LottoManager();
    }

    @Test
    void 숫자_판단_테스트() {
        try {
            lottoManager.checkNumber("1000j");
        } catch (IllegalArgumentException e) {
            assertThat("숫자가 아닌 문자 입력").isEqualTo(e.getMessage());
        }
    }

    @Test
    void 천원_단위_확인_메서드() {
        try {
            lottoManager.checkAdequateMoney(5500);
        } catch (IllegalArgumentException e) {
            assertThat("1000원 단위로 입력하세요").isEqualTo(e.getMessage());
        }
    }
}