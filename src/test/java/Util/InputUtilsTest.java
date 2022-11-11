package Util;

import org.junit.jupiter.api.Test;

import java.io.*;

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
}