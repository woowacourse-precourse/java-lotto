package lotto;

import lotto.service.LottoService;
import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.IgnoreForBinding;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import java.io.*;
import java.util.List;

class LottoServiceTest {

    /*
    LottoService lottoService;

    @BeforeEach
    void setUp() {
        String purchasingAmountInput = "8000";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(purchasingAmountInput.getBytes());
        System.setIn(in);
        lottoService = new LottoService();

        String winningNumber = "1,2,3,4,5,6";
        OutputStream out2 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out2));
        InputStream in2 = new ByteArrayInputStream(winningNumber.getBytes());
        System.setIn(in2);
        lottoService.createWinningNumber();

        String bonusNumber = "7";
        OutputStream out3 = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out3));
        InputStream in3 = new ByteArrayInputStream(bonusNumber.getBytes());
        System.setIn(in3);
        lottoService.createBonusNumber();

        lottoService.drawForWinner();
    }



    @Test
    @DisplayName("서비스 객체 내 랜덤 로또 숫자 생성 여부 확인")
    void makeRandomLottoNum() {
        assertThat(8).isEqualTo(lottoService.randomLottoNumber.size());
    }

    @Test
    @DisplayName("서비스 객체 내 당첨 번호 생성 여부 확인")
    void makeWinningNum() {
        assertThat(lottoService.winningNumber.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("서비스 객체 내 보너스 번호 생성 여부 확인")
    void makeBonusNum() {
        assertThat(lottoService.bonusNumber).isEqualTo(7);
    }

    @Test
    @DisplayName("랜덤 숫자와 당첨 번호 비교 과정 검증")
    void makeWinner() {
        assertThat(lottoService.randomLottoNumber.get(0).winner.isBonusNum()).isEqualTo(false);
    }

     */
}