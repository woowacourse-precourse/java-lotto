package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

class PaidLottoTest {

    @Test
    void 정답로또와_비교시_당첨여부_설정_성공() throws Exception {
        PaidLotto paidLotto = new PaidLotto(new Lotto(List.of(5, 1, 2, 42, 7, 35)));
        AnswerLotto answer = new AnswerLotto(List.of(5, 1, 2, 42, 3, 35), 7);
        paidLotto.compareWith(answer);

        assertAll(
            () -> assertThat(paidLotto.getLottoReward()).isEqualTo(LottoReward.SECOND),
            () -> assertThat(paidLotto.isRewarded()).isTrue()
        );
    }

    @Test
    void 로또와_동일한_당첨순위를_가지고있는지_확인_성공() throws Exception {
        PaidLotto paidLotto = new PaidLotto(new Lotto(List.of(5, 1, 2, 42, 7, 35)));
        AnswerLotto answer = new AnswerLotto(List.of(5, 1, 2, 42, 3, 35), 7);
        paidLotto.compareWith(answer);

        assertThat(paidLotto.hasSameLottoReward(LottoReward.SECOND));
    }
}