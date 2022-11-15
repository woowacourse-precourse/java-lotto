package lotto.controller;

import static lotto.domain.LottoRanking.FIVE_AND_BONUS_RIGHT;
import static lotto.domain.LottoRanking.FIVE_RIGHT;
import static lotto.domain.LottoRanking.ONE_RIGHT;
import static lotto.domain.LottoRanking.THREE_RIGHT;
import static lotto.domain.LottoRanking.ZERO_RIGHT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoSystemTest {
    LottoSystem lottoSystem = new LottoSystem();

    @DisplayName("수익률 구하기")
    @Test
    public void calculateYieldTest() {
        //given
        int prizeMoney = 5000;
        int userMoney = 8000;
        //when
        double expected = lottoSystem.calculateYield(prizeMoney, userMoney);
        //then
        assertThat(expected).isEqualTo(62.5);
    }

    @DisplayName("당첨금액 구하기")
    @Test
    public void calculatePrizeMoneyTest() {
        //given
        List<LottoRanking> lottoResult = Arrays.asList(FIVE_RIGHT, FIVE_AND_BONUS_RIGHT, ZERO_RIGHT, ONE_RIGHT, THREE_RIGHT);
        //when
        int expected = lottoSystem.calculatePrizeMoey(lottoResult);
        //then
        assertThat(expected).isEqualTo(31505000);
    }

    @DisplayName("로또 번호 당첨 개수 구하기")
    @Test
    public void createResultTest() {
        //given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto (Arrays.asList(1, 2, 3, 4, 5, 7)), 6);
        //when
        int expected = lottoSystem.calculateLotto(lotto, winningLotto);
        //then
        assertThat(expected).isEqualTo(5);
    }

    @DisplayName("입력 받은 금액만큼 로또 수량 출력")
    @Test
    public void createLottoQuantityTest() {
        //given
        int userMoney = 5000;
        //when
        int quantity = lottoSystem.LottoQuantityCalculation(userMoney);
        //then
        assertThat(quantity).isEqualTo(5);
    }
    
    @DisplayName("로또 수량만큼 로또가 생성되는지 확인")
    @Test
    public void createLottosTest() {
        //given
        int quantity = 5;
        //when
        UserLotto userLotto = lottoSystem.makeUserLottos(quantity);
        //then
        assertThat(userLotto.getSize()).isEqualTo(5);
    }

}