package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class JudgementTest {

    private Lotto wonLotto;
    private int bonusNumber;
    private List<Lotto> userLottos;

    @BeforeEach
    void setUp() {
        wonLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = 7;
        userLottos = List.of(
                new Lotto(List.of(1, 7, 42, 43, 44, 45)),
                new Lotto(List.of(1, 41, 42, 43, 44, 45)),
                new Lotto(List.of(1, 2, 42, 43, 44, 45)),
                new Lotto(List.of(1, 2, 3, 43, 44, 45)),
                new Lotto(List.of(1, 2, 3, 4, 44, 45)),
                new Lotto(List.of(1, 2, 3, 4, 5, 45)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(7, 41, 42, 43, 44, 45)),
                new Lotto(List.of(40, 41, 42, 43, 44, 45))
        );
    }

    @Test
    @DisplayName("순위 결정 테스트 1")
    void judgeRankTest1() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(0), wonLotto, bonusNumber)).isEqualTo(0);
    }

    @Test
    @DisplayName("순위 결정 테스트 2")
    void judgeRankTest2() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(1), wonLotto, bonusNumber)).isEqualTo(0);
    }

    @Test
    @DisplayName("순위 결정 테스트 3")
    void judgeRankTest3() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(2), wonLotto, bonusNumber)).isEqualTo(0);
    }

    @Test
    @DisplayName("순위 결정 테스트 4")
    void judgeRankTest4() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(3), wonLotto, bonusNumber)).isEqualTo(5);
    }

    @Test
    @DisplayName("순위 결정 테스트 5")
    void judgeRankTest5() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(4), wonLotto, bonusNumber)).isEqualTo(4);
    }

    @Test
    @DisplayName("순위 결정 테스트 6")
    void judgeRankTest6() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(5), wonLotto, bonusNumber)).isEqualTo(3);
    }

    @Test
    @DisplayName("순위 결정 테스트 7")
    void judgeRankTest7() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(6), wonLotto, bonusNumber)).isEqualTo(2);
    }

    @Test
    @DisplayName("순위 결정 테스트 8")
    void judgeRankTest8() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(7), wonLotto, bonusNumber)).isEqualTo(1);
    }

    @Test
    @DisplayName("순위 결정 테스트 9")
    void judgeRankTest9() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(8), wonLotto, bonusNumber)).isEqualTo(0);
    }

    @Test
    @DisplayName("순위 결정 테스트 10")
    void judgeRankTest10() {
        Judgement judgement = new Judgement();
        Assertions.assertThat(judgement.judgeRank(userLottos.get(9), wonLotto, bonusNumber)).isEqualTo(0);
    }
}