package lotto.reward;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import lotto.lotto.Lotto;
import lotto.setting.LottoReward;
import lotto.winningnumber.WinningNumber;
import org.junit.jupiter.api.Test;
import java.util.List;

public class RewardCoordinatorTest {

    @Test
    void getRewardResultTest() {
        WinningNumber winningNumber = mock(WinningNumber.class);
        List<LottoReward> rewards = mockLottoRewards();
        List<Lotto> lottos = mockLottos();
        String excepted = "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n6개 일치 (2,000,000,000원) - 1개\n";

        String result = new RewardCoordinator(winningNumber, rewards).getRewardResult(mockLottos());

        assertThat(result).isEqualTo(excepted);
    }

    List<LottoReward> mockLottoRewards() {
        LottoReward mockLottoReward = mock(LottoReward.class);
        when(mockLottoReward.isSatisfyMatchingCondition(anyInt(), anyInt())).thenReturn(false, true, true);
        when(mockLottoReward.getRewardInfo()).thenReturn( "5개 일치, 보너스 볼 일치 (30,000,000원)", "6개 일치 (2,000,000,000원)");
        return List.of(mockLottoReward, mockLottoReward);
    }

    List<Lotto> mockLottos() {
        Lotto mock1 = mock(Lotto.class);
        Lotto mock2 = mock(Lotto.class);
        return List.of(mock1, mock2);
    }
}
