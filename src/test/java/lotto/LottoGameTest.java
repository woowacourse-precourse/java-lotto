package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottoGameTest {

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