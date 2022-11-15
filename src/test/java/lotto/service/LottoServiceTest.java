package lotto.service;

import lotto.domain.Reward;
import lotto.domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {

    private LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 번호 매칭된 개수 테스트")
    void matchLottoNumberTest() {
        List<Integer> winningNumbers = List.of(30, 24, 13, 4, 5, 6);
        List<Integer> lottoNumbers = List.of(30, 24, 13, 4, 1, 6);

        int matchCount = lottoService.matchLottoCount(winningNumbers, lottoNumbers);

        assertThat(matchCount).isEqualTo(5);
    }

    @Test
    @DisplayName("로또 번호 결과 저장 테스트 2등 두개")
    void saveLottoResultTest() {

        User user = lottoService.getUserForTest();

        user.addLottoForTest(List.of(30, 24, 13, 4, 1, 6));
        user.addLottoForTest(List.of(30, 5, 13, 2, 24, 6));

        lottoService.saveWinningLotto("30,24,13,4,5,6");
        lottoService.saveResultLotto();

        Reward expectedReward = Reward.SECOND_REWARD;

        assertThat(user.getLottiesResult().get(expectedReward)).isEqualTo(2);
    }

}
