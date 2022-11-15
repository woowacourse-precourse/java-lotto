package lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.generator.FixedNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.lottery.BonusNumber;
import lotto.domain.lottery.LottoGroup;
import lotto.domain.lottery.WinningLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HitResultTest {

    private LottoGroup lottoGroup;

    @BeforeEach
    void setUp() {
        NumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        lottoGroup = new LottoGroup(3, fixedNumberGenerator); // [1, 2, 3, 4, 5, 6]
    }

    @Test
    @DisplayName("로또 번호들 중 당첨의 수를 카운트합니다 - 6개 매칭")
    void calculateMatchResults_6_hits() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,6");
        BonusNumber bonusNumber = new BonusNumber("7", winningLotto);

        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);
        List<Integer> results = new ArrayList<>(result.getHitResultExceptNone().values());

        assertThat(results)
                .isEqualTo(List.of(0, 0, 0, 0, 3));
    }

    @Test
    @DisplayName("로또 번호들 중 당첨의 수를 카운트합니다 - 5개 매칭 & 보너스 매칭")
    void calculateMatchResults_5_hits_with_bonus() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,10");
        BonusNumber bonusNumber = new BonusNumber("6", winningLotto);

        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);
        List<Integer> results = new ArrayList<>(result.getHitResultExceptNone().values());

        assertThat(results)
                .isEqualTo(List.of(0, 0, 0, 3, 0));
    }

    @Test
    @DisplayName("로또 번호들 중 당첨의 수를 카운트합니다 - 5개 매칭")
    void calculateMatchResults_5_hits() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,5,10");
        BonusNumber bonusNumber = new BonusNumber("7", winningLotto);

        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);
        List<Integer> results = new ArrayList<>(result.getHitResultExceptNone().values());

        assertThat(results)
                .isEqualTo(List.of(0, 0, 3, 0, 0));
    }

    @Test
    @DisplayName("로또 번호들 중 당첨의 수를 카운트합니다 - 4개 매칭")
    void calculateMatchResults_4_hits() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,4,10,11");
        BonusNumber bonusNumber = new BonusNumber("7", winningLotto);

        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);
        List<Integer> results = new ArrayList<>(result.getHitResultExceptNone().values());

        assertThat(results)
                .isEqualTo(List.of(0, 3, 0, 0, 0));
    }

    @Test
    @DisplayName("로또 번호들 중 당첨의 수를 카운트합니다 - 3개 매칭")
    void calculateMatchResults_3_hits() {
        WinningLotto winningLotto = new WinningLotto("1,2,3,10,11,12");
        BonusNumber bonusNumber = new BonusNumber("7", winningLotto);

        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);
        List<Integer> results = new ArrayList<>(result.getHitResultExceptNone().values());

        assertThat(results)
                .isEqualTo(List.of(3, 0, 0, 0, 0));
    }

    @Test
    @DisplayName("로또 번호들 중 당첨의 수를 카운트합니다 - 상금 없음")
    void calculateMatchResults_0_hits() {
        WinningLotto winningLotto = new WinningLotto("1,2,10,11,12,13");
        BonusNumber bonusNumber = new BonusNumber("7", winningLotto);

        HitResult result = new HitResult(lottoGroup, winningLotto, bonusNumber);
        List<Integer> results = new ArrayList<>(result.getHitResultExceptNone().values());

        assertThat(results)
                .isEqualTo(List.of(0, 0, 0, 0, 0));
    }
}