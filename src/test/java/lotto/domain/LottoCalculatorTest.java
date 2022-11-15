package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("로또 계산 테스트")
@TestMethodOrder(OrderAnnotation.class)
class LottoCalculatorTest {

    private LottoCalculator calculator ;

    @BeforeEach
    void testSetting(){
        this.calculator = new LottoCalculator();
    }

    @Order(1)
    @Test
    void getLottoQuantity() {
        //given
        long playerMoney = 1_800_000 ;

        //when
        long lottoQuantity = calculator.getLottoQuantity(playerMoney);

        //then
        assertThat(lottoQuantity).isEqualTo(1800);
    }

    @Order(2)
    @Test
    void getRate() {
        //given
        long rewardMoney = 5_000;
        long playerMoney = 8_000;

        //when
        double rate = calculator.getRate(rewardMoney, playerMoney);

        //then
        assertThat(rate).isEqualTo(62.5);
    }

    @Order(3)
    @Test
    void getEqualsCount() {
        //given
        List<Integer> winningNumbers = List.of(1, 10, 23, 26, 35, 42);
        int bonusNumber = 6;
        Lotto playerLotto = new Lotto(List.of(1, 10, 23, 26, 35, 42));

        //when
        int equalsCount = calculator.getEqualsCount(winningNumbers, bonusNumber, playerLotto);

        //then
        assertThat(equalsCount).isEqualTo(7);
    }

    @Order(4)
    @Test
    void getRank() {
        //given
        int equalsCountOfRankTwo = 6;
        int equalsCountOfRankOne = 7;

        //when
        int rankTwoTest = calculator.getRank(equalsCountOfRankTwo);
        int rankOneTest = calculator.getRank(equalsCountOfRankOne);

        //then
        assertThat(rankOneTest).isEqualTo(1);
        assertThat(rankTwoTest).isEqualTo(2);
    }

    @Order(5)
    @Test
    void getRewardMoney() {
        //given
        Map<Integer, Integer> resultBoard = Map
                .of(1, 0,
                        2, 0,
                        3, 2,
                        4, 1,
                        5, 2);

        //when
        long rewardMoney = calculator.getRewardMoney(resultBoard);

        //then
        assertThat(rewardMoney).isEqualTo(3_060_000);

    }
}