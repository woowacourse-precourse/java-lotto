package Util;

import lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputUtilsTest {
    @Test
    public void 금액_반환_확인() throws Exception {
        //given
        String input = "5000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        int money = InputUtils.StringToMoney();

        //then
        assertThat(money).isEqualTo(5000);
    }

    @Test
    public void 당첨_로또_생성() throws Exception {
        //given
        String input = "1,2,3,4,5,6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        Lotto winningLotto = InputUtils.StringToWinningLottoNumber();

        //then
        assertThat(winningLotto.getNumbers()).isEqualTo(List.of(1,2,3,4,5,6));
    }
}