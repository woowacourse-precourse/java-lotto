package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoGameTest {

    @Test
    void translateNumbers() {

    }

    @Test
    void 당첨번호_입력받아_세팅하기() {
        LottoGame lottoGame = new LottoGame();
        List<Integer> integers = lottoGame.translateNumbers("1");
        List<Integer> result = Arrays.asList(1);

        assertThat(integers).isEqualTo(result);
    }

    @Test
    void 당첨번호_입력받아_세팅하기2() {
        LottoGame lottoGame = new LottoGame();
        List<Integer> integers = lottoGame.translateNumbers("1,2,3,4,5");
        List<Integer> result = Arrays.asList(1, 2, 3, 4, 5);

        assertThat(integers).isEqualTo(result);
    }

    @Test
    void 구매금액에_따른_로또개수_반환1(){
        LottoGame lottoGame = new LottoGame();
        try {
            int count = lottoGame.countLotto(5000);
            int result = 5;
            assertThat(count).isEqualTo(result);
        } catch (IllegalArgumentException illegalArgumentException) {
            String message = illegalArgumentException.getMessage();
            String result = "[ERROR] 금액을 1000원 단위로 입력해주세요.";
            assertThat(message).isEqualTo(result);
        }
    }

    @Test
    void 구매금액에_따른_로또개수_반환2(){
        LottoGame lottoGame = new LottoGame();
        try {
            int count = lottoGame.countLotto(5001);
            int result = 5;
            assertThat(count).isEqualTo(result);
        } catch (IllegalArgumentException illegalArgumentException) {
            String message = illegalArgumentException.getMessage();
            String result = "[ERROR] 금액을 1000원 단위로 입력해주세요.";
            assertThat(message).isEqualTo(result);
        }
    }

}