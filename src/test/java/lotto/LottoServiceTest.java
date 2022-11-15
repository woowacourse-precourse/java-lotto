package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoService;
import lotto.reward.Reward;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    private LottoService service;

    @BeforeEach
    void init() {
        service = new LottoService();
    }

    @Test
    void getLottoAmount() {
        assertThat(service.getLottoAmount("3000")).isEqualTo(3);
        assertThat(service.getLottoAmount("6000")).isEqualTo(6);

        assertThatThrownBy(() -> service.getLottoAmount("0"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getLottoAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getLottoAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getLottoAmount("300"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getLottoAmount("1037"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getMatchNumbers() {
        assertThat(service.getMatchNumbers("1,2,3,4,5,6"))
                .isEqualTo(List.of(1, 2, 3, 4, 5, 6));
        assertThat(service.getMatchNumbers("11,21,31,41,15,16"))
                .isEqualTo(List.of(11, 21, 31, 41, 15, 16));

        assertThatThrownBy(() -> service.getMatchNumbers(""))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getMatchNumbers(",,,,,"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getMatchNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getMatchNumbers("111,222,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getMatchNumbers("1,-2,3,4,5,6"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getMatchNumbers("3,3,1,2,3,4"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> service.getMatchNumbers("a,b,c,d,e,1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculateMatched() {
        int result1 = service.calculateMatched(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                List.of(1, 2, 3, 4, 5, 6));
        int result2 = service.calculateMatched(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                List.of(1, 2, 3, 4, 5, 7));
        int result3 = service.calculateMatched(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                List.of(11, 2, 13, 4, 5, 7));

        assertThat(result1).isEqualTo(6);
        assertThat(result2).isEqualTo(5);
        assertThat(result3).isEqualTo(3);
    }

    @Test
    void calculateReward() {
        int result1 = service.calculateReward(6, false);
        int result2 = service.calculateReward(5, true);
        int result3 = service.calculateReward(5, false);
        int result4 = service.calculateReward(4, true);

        assertThat(result1).isEqualTo(Reward.FIRST.getRewardIndex());
        assertThat(result2).isEqualTo(Reward.SECOND.getRewardIndex());
        assertThat(result3).isEqualTo(Reward.THIRD.getRewardIndex());
        assertThat(result4).isEqualTo(Reward.FOURTH.getRewardIndex());
    }

    @Test
    void getProfitRate() {
        double result1 = service.getProfitRate(new int[]{1, 0, 0, 0, 0}, 5);
        double result2 = service.getProfitRate(new int[]{0, 0, 1, 0, 0}, 1_500);
        double result3 = service.getProfitRate(new int[]{0, 2, 1, 0, 0}, 1_600);
        double result4 = service.getProfitRate(new int[]{1, 0, 0, 0, 1}, 2_000_001);

        assertThat(String.format("%.2f", result1)).isEqualTo("1.00");
        assertThat(String.format("%.2f", result2)).isEqualTo("1.00");
        assertThat(String.format("%.2f", result3)).isEqualTo("1.00");
        assertThat(String.format("%.2f", result4)).isEqualTo("1.00");
    }
}