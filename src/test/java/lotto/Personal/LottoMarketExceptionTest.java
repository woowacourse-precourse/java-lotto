package lotto.Personal;

import lotto.LottoMarket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoMarketTest {

    @DisplayName("구입 금액에 숫자가 아닌 문자가 포함되어 있으면 예외를 발생시킨다.")
    @Test
    void 구입금액에_숫자가_아닌_문자가_포함된_경우() {
        LottoMarket lottoMarket = new LottoMarket();
        assertThatThrownBy(() -> lottoMarket.validateInputPrice("avc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 1000으로 나뉘어 떨어지지 않는 경우 예외를 발생시킨다.")
    @Test
    void 구입금액이_1000으로_나뉘어지지_않는경우() {
        LottoMarket lottoMarket = new LottoMarket();
        assertThatThrownBy(() -> lottoMarket.validateInputPrice("3500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}