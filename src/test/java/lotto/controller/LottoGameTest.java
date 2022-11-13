package lotto.controller;

import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다.")
    @Test
    void purchaseLottoByUnit() {
        LottoGame lottoGame = new LottoGame();
        assertThatThrownBy(() -> lottoGame.validateUnit(5100))
                .isInstanceOf(IllegalArgumentException.class);
    }

}