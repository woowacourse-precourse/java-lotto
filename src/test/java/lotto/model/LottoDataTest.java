package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoDataTest {
    LottoData lottoData;

    @BeforeEach
    void initAll() {
        lottoData = new LottoData(12000d);
    }

    @DisplayName("12000으로 LottoData 객체를 생성하면 lottoAmount 에 12가 저장된다.")
    @Test
    void constructorTest() {
        assertThat(lottoData.lottoAmount).isEqualTo(12);
    }

    @DisplayName("12000으로 LottoData 객체 생성 후 makeLotto 호출하면 allLotto 에 12개의 Lotto 객체가 담긴다.")
    @Test
    void makeLottoTest() {
        lottoData.makeLotto();
        assertThat(lottoData.allLotto.size()).isEqualTo(12);
    }

    @DisplayName("로또가 절대 당첨될 수 없는 상황일 때 누적 상금이 lottoData 의 prizeMoneySum 에 저장된다.")
    @Test
    void putDataToLottoTest1() {
        lottoData.winNumbers = new ArrayList<>(Arrays.asList(46, 47, 48, 49, 50, 51));
        lottoData.bonusNumber = 52;

        lottoData.makeLotto();
        lottoData.calculateAllLotto();

        assertThat(lottoData.prizeMoneySum).isEqualTo(0d);
    }

    @DisplayName("로또가 무조건 1등 당첨되는 상황일 때 누적 상금이 lottoData 의 prizeMoneySum 에 저장된다.")
    @Test
    void putDataToLottoTest2() {
        lottoData.winNumbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));
        lottoData.bonusNumber = 52;

        lottoData.makeLotto();
        lottoData.calculateAllLotto();

        assertThat(lottoData.prizeMoneySum).isEqualTo(24000000000d);
    }

    @DisplayName("로또가 절대 당첨될 수 없는 상황일 때 prize 의 0에 12개, prizeMoneySum 에 0이 저장된다.")
    @Test
    void countPrizeAndSumPrizeMoneyTest1() {
        lottoData.winNumbers = new ArrayList<>(Arrays.asList(46, 47, 48, 49, 50, 51));
        lottoData.bonusNumber = 52;

        lottoData.makeLotto();
        lottoData.calculateAllLotto();
        assertThat(lottoData.prizeCount.getPrizeCount().get(0)).isEqualTo(12);
        assertThat(lottoData.prizeMoneySum).isEqualTo(0);
    }

    @DisplayName("로또가 무조건 1등 당첨되는 상황일 때 prize 의 1에 12, prizeMoneySum 에 240억이 저장된다.")
    @Test
    void countPrizeAndSumPrizeMoneyTest2() {
        lottoData.winNumbers = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25,
                        26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45));
        lottoData.bonusNumber = 52;

        lottoData.makeLotto();
        lottoData.calculateAllLotto();
        assertThat(lottoData.prizeCount.getPrizeCount().get(1)).isEqualTo(12);
        assertThat(lottoData.prizeMoneySum).isEqualTo(24000000000d);
    }
}