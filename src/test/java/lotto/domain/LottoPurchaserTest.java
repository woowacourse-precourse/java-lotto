package lotto.domain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LottoPurchaserTest {

    @Test
    void 로또_정상_구입(){
        String input = "8000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        LottoPurchaser lottoPurchaser = new LottoPurchaser();

        int expected = 8000;

        assertThat(lottoPurchaser.getPurchaseAmount()).isEqualTo(expected);
    }

    @Test
    void 숫자가_아닌_입력_예외처리(){
        String input = "abcd";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String expected = "[ERROR] 구입금액은 숫자여야 합니다.";

        try{
            LottoPurchaser lottoPurchaser = new LottoPurchaser();
        }catch (IllegalArgumentException e){
            assertThat(e.getMessage()).isEqualTo(expected);
        }
    }

    @Test
    void 로또금액으로_안나뉘는_경우_예외처리(){
        String input = "1500";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String expected = "[ERROR] 구입금액은 1000원 단위여야 합니다.";

        try{
            LottoPurchaser lottoPurchaser = new LottoPurchaser();
        }catch (IllegalArgumentException e){
            assertThat(e.getMessage()).isEqualTo(expected);
        }
    }

}