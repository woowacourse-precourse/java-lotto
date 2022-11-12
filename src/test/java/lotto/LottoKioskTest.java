package lotto;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoKioskTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("[오류 테스트] 입력에 숫자가 아닌 것이 존재")
    @Test
    void inputNotNum() {
        //입력값 정의
        String input = "10000c";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.moneyInserted();
        //when then
        assertThatThrownBy(() -> lottoKiosk.validateMoneyInput())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("[오류 테스트] 돈이 1000으로 나누어지지 않음")
    @Test
    void chargedMoneyNotDivideBy1000() {
        //입력값 정의
        String input = "1000023";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        lottoKiosk.moneyInserted();
        lottoKiosk.moneyCharged();
        //when then
        assertThatThrownBy(() -> lottoKiosk.validateMoney())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("올바른 입력시 금액 조회")
    @Test
    void showInsertedMoney() {
        //입력값 정의
        String input = "210000";
        ByteArrayInputStream byteInput = new ByteArrayInputStream(input.getBytes());
        System.setIn(byteInput);
        //given
        LottoKiosk lottoKiosk = new LottoKiosk();
        //when
        lottoKiosk.insertMoney();
        long chargedMoney = lottoKiosk.showInsertedMoney();
        //then
        assertThat(chargedMoney).isEqualTo(Long.parseLong(input));
    }
}