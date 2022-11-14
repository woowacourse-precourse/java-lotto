package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoGameTest {
    @Test
    void 로또_세트_결과_확인(){
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        Lotto lotto1 = new Lotto(List.of(8, 9, 10, 11, 12, 13));
        Lotto lotto2 = new Lotto(List.of(7, 15, 16, 17, 18, 19));
        Lotto lotto3 = new Lotto(List.of(4, 5, 6, 3, 7, 2));
        Lotto lotto4 = new Lotto(List.of(26, 27, 28, 29, 1, 2));
        Lotto lotto5 = new Lotto(List.of(1, 2, 3, 20, 12, 11));
        Lotto lotto6 = new Lotto(List.of(1, 2, 3, 4, 5, 11));
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3, lotto4, lotto5, lotto6);
        LottoSet lottoSet = new LottoSet(lottos);
        List<Integer> output = lottoSet.checkWinning(winningNumbers, bonusNumber);
        List<Integer> result = List.of(0, 1, 1, 0, 1);
        assertThat(output).isEqualTo(result);
    }

    @Test
    void 당첨번호_입력받아_세팅하기() {
        LottoGame lottoGame = new LottoGame();
        List<Integer> integers = lottoGame.convertNumbers("1");
        List<Integer> result = Arrays.asList(1);

        assertThat(integers).isEqualTo(result);
    }

    @Test
    void 당첨번호_입력받아_세팅하기2() {
        LottoGame lottoGame = new LottoGame();
        List<Integer> integers = lottoGame.convertNumbers("1,2,3,4,5");
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
            String result = "금액을 1000원 단위로 입력해주세요.";
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
            String result = "금액을 1000원 단위로 입력해주세요.";
            assertThat(message).isEqualTo(result);
        }
    }
    @Test
    void 구매금액에_따른_로또개수_반환3(){
        LottoGame lottoGame = new LottoGame();
        try {
            int count = lottoGame.countLotto(0);
            int result = 5;
            assertThat(count).isEqualTo(result);
        } catch (IllegalArgumentException illegalArgumentException) {
            String message = illegalArgumentException.getMessage();
            String result = "금액을 1000원 단위로 입력해주세요.";
            assertThat(message).isEqualTo(result);
        }
    }

}