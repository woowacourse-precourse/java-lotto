package lotto.service;

import lotto.domain.Reward;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.assertj.core.api.Assertions;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 번호 매칭된 개수 테스트")
    void matchLottoNumberTest() {
        List<Integer> winningNumbers = List.of(30, 24, 13, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(30, 24, 13, 4, 1, 6);

        int matchCount = lottoService.matchLottoCount(winningNumbers, lottoNumbers);

        Assertions.assertThat(matchCount).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 결과 저장 테스트 3등 두개")
    void saveLottoResultTest() {

        User user = lottoService.getUserForTest();

        user.addLottoForTest(List.of(30, 24, 13, 4, 1, 6));
        user.addLottoForTest(List.of(30, 5, 13, 2, 24, 6));

        lottoService.saveWinningLotto("30,24,13,4,5,6");
        lottoService.initResultLotto();
        lottoService.saveResultLotto();

        Reward expectedReward = Reward.THIRD_REWARD;

        Assertions.assertThat(user.getLottiesResult().get(expectedReward)).isEqualTo(2);
    }

    @Test
    @DisplayName("로또 번호 결과 저장 테스트 2등 하나 3등 하나")
    void saveLottoResultTestWith2And3() {

        User user = lottoService.getUserForTest();

        user.addLottoForTest(List.of(30, 24, 13, 4, 1, 6));
        user.addLottoForTest(List.of(30, 5, 13, 2, 24, 1));
        user.addLottoForTest(List.of(30, 5, 13, 2, 24, 6));

        lottoService.saveWinningLotto("30,5,13,2,24,7");
        lottoService.saveBonusNumber("6");
        lottoService.initResultLotto();
        lottoService.saveResultLotto();

        Reward expectedRewardOne = Reward.THIRD_REWARD;
        Reward expectedRewardTwo = Reward.SECOND_REWARD;

        Assertions.assertThat(user.getLottiesResult().get(expectedRewardOne)).isEqualTo(1);
        Assertions.assertThat(user.getLottiesResult().get(expectedRewardTwo)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 번호 결과 저장 테스트 1등 하나")
    void saveLottoResultTestWithOneReward() {

        User user = lottoService.getUserForTest();

        user.addLottoForTest(List.of(30, 24, 13, 4, 1, 6));

        lottoService.saveWinningLotto("30,24,13,4,1,6");
        lottoService.saveBonusNumber("7");
        lottoService.initResultLotto();
        lottoService.saveResultLotto();

        Reward expectedReward = Reward.FIRST_REWARD;

        Assertions.assertThat(user.getLottiesResult().get(expectedReward)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 수익률 계산 테스트")
    void lottoProfitRateTest() {

        User user = lottoService.getUserForTest();
        user.setMoney(3000);

        user.addLottoForTest(List.of(2, 39, 13, 4, 1, 6));
        user.addLottoForTest(List.of(15, 5, 13, 2, 24, 30));
        user.addLottoForTest(List.of(39, 16, 35, 1, 10, 18));

        lottoService.saveWinningLotto("41,45,39,1,2,18");
        lottoService.initResultLotto();
        lottoService.saveResultLotto();

        lottoService.calculateReward();

        String profitRate = lottoService.getProfitRate();

        Assertions.assertThat(profitRate).isEqualTo("333.3");
    }

    @Test
    @DisplayName("로또 수익률 계산 테스트 2")
    void lottoProfitRateTest2() {

        User user = lottoService.getUserForTest();
        user.setMoney(3000);

        user.addLottoForTest(List.of(19, 39, 13, 4, 1, 6));
        user.addLottoForTest(List.of(15, 5, 13, 2, 24, 30));
        user.addLottoForTest(List.of(39, 16, 35, 1, 10, 18));

        lottoService.saveWinningLotto("41,45,39,1,2,18");
        lottoService.initResultLotto();
        lottoService.saveResultLotto();

        lottoService.calculateReward();

        String profitRate = lottoService.getProfitRate();

        Assertions.assertThat(profitRate).isEqualTo("166.7");
    }

    @Test
    @DisplayName("로또 수익률 계산 테스트 3")
    void lottoProfitRateTest3() {

        User user = lottoService.getUserForTest();
        user.setMoney(8000);

        user.addLottoForTest(List.of(19, 39, 13, 4, 1, 6));
        user.addLottoForTest(List.of(15, 5, 13, 2, 24, 30));
        user.addLottoForTest(List.of(39, 16, 35, 1, 10, 18));

        lottoService.saveWinningLotto("41,45,39,1,2,18");
        lottoService.initResultLotto();
        lottoService.saveResultLotto();

        lottoService.calculateReward();

        String profitRate = lottoService.getProfitRate();

        Assertions.assertThat(profitRate).isEqualTo("62.5");
    }

}
