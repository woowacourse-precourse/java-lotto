package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {

    @Test
    @DisplayName("금액에 따라 1000원으로 나눠진 값을 구한다.")
    void getLottoCountTest() {
        LottoService lottoService = new LottoService();
        assertThat(lottoService.getLottoCount("5000")).isEqualTo(5);
    }

    @Test
    @DisplayName("1000으로 안나눠 떨어지면 예외가 발생한다.")
    void createoPurchaseAmountUnexpected() {
        LottoService lottoService = new LottoService();
        assertThatThrownBy(()->lottoService.getLottoCount("5001"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->lottoService.getLottoCount("-5001"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->lottoService.getLottoCount("ㅁㅁㄴㅇㄹㄷ33"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("랜덤의 복권 번호를 생성한다.")
    void drawLottosTest() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    LottoService lottoService = new LottoService();
                    List<Lotto> lottos = lottoService.getLottos();
                    lottoService.drawLottos(8);
                    assertThat(lottos.get(0).getNumbers())
                            .contains(8, 21, 23, 41, 42, 43);
                    assertThat(lottos.get(7).getNumbers())
                            .contains(1, 3, 5, 14, 22, 45);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    @DisplayName("당첨 갯수를 구한다.")
    void findNumbersOfWinTest() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    LottoService lottoService = new LottoService();
                    List<Lotto> lottos = lottoService.getLottos();
                    lottoService.drawLottos(8);
                    List<Integer> numbersOfWin =
                            lottoService.findNumbersOfWin("1,2,3,4,5,6", "7");
                    assertThat(numbersOfWin)
                            .contains(1,0)
                            .doesNotContain(2,3,4,5,6,7);

                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );

    }

    @Test
    @DisplayName("당첨번호에 올바른 값을 입력하지 않으면 예외가 발생한다.")
    void createStringToWinNumber() {
        assertThatThrownBy(()->
                new LottoService().findNumbersOfWin("1,2,3,4,5,6,a", "7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->
                new LottoService().findNumbersOfWin("1,2,3,4,5,", "7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->
                new LottoService().findNumbersOfWin("1,2,3,4,", "7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->
                new LottoService().findNumbersOfWin("ㅇㅁㄴㅇㅁ", "7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->
                new LottoService().findNumbersOfWin("1,2,3,4,5,6,7", "7"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->
                new LottoService().findNumbersOfWin("", "7"))
                .isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    @DisplayName("보너스 번호에 올바른 값을 입력하지 않으면 예외가 발생한다.")
    void createBonusNumberUnexpected() {
        assertThatThrownBy(()->
                new LottoService().findNumbersOfWin("1,2,3,4,5,6", "0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->
                new LottoService().findNumbersOfWin("1,2,3,4,5,6", "46"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->
                new LottoService().findNumbersOfWin("1,2,3,4,5,6", "ㅁ"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("총 수익률을 가져온다.")
    void getTotalReturnTest() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    LottoService lottoService = new LottoService();
                    List<Lotto> lottos = lottoService.getLottos();
                    lottoService.drawLottos(8);
                    List<Integer> numbersOfWin =
                            lottoService.findNumbersOfWin("1,2,3,4,5,6", "7");
                    assertThat(lottoService.getTotalReturn("8000")).isEqualTo(62.5);
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    @DisplayName("LotterService의 lottos 필드를 가져온다.")
    void getLottosTest() {
        LottoService lottoService = new LottoService();
        assertThat(lottoService.getLottos()).isInstanceOf(new ArrayList<Lotto>().getClass());
    }

}