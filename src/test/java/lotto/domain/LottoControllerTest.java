package lotto.domain;

import lotto.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


class LottoControllerTest {
    private static LottoController lottoController;
    @BeforeAll
    static void init(){
        lottoController = new LottoController();
    }

    @DisplayName("가격이 1000원 단위가 아니라면 예외가 발생한다.")
    @Test
    void inputPriceNotDividedBy1000() {
        assertThatThrownBy(() -> lottoController.calculateLottoNumber(1300))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("가격은 숫자 형식이 아니라면 예외가 발생한다.")
    @Test
    void inputMoneyNotDigit() {
        String inputMoney = "123F";
        InputStream in = new ByteArrayInputStream(inputMoney.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> lottoController.inputMoney())
                .isInstanceOf(IllegalArgumentException.class);
    }
}