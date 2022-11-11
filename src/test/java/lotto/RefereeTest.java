package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RefereeTest {

    List<Lotto> lottos;
    Referee referee;

    @BeforeEach
    void init() {
        lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        referee = new Referee();
    }

    @DisplayName("로또 번호와 플레이어 번호가 몇 개 일치하는지 반환한다 - 3개 일치")
    @Test
    void countThreeMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);

        // when
        int result = referee.countThreeMatch(lottos, player);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("로또 번호와 플레이어 번호가 몇 개 일치하는지 반환한다 - 4개 일치")
    @Test
    void countFourMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 14);

        // when
        int result = referee.countFourMatch(lottos, player);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("로또 번호와 플레이어 번호가 몇 개 일치하는지 반환한다 - 5개 일치")
    @Test
    void countFiveMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);

        // when
        int result = referee.countFiveMatch(lottos, player);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("로또 번호와 플레이어 번호가 몇 개 일치하는지 반환한다 - 5개 그리고 보너스 번호 일치")
    @Test
    void countFiveWithBonusNumberMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 45;

        // when
        int result = referee.countFiveMatchWithBonusNumber(lottos, player, bonusNumber);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("로또 번호와 플레이어 번호가 몇 개 일치하는지 반환한다 - 6개 일치")
    @Test
    void countSixMatch() {
        // given
        List<Integer> player = List.of(1, 3, 5, 14, 22, 45);

        // when
        int result = referee.countSixMatch(lottos, player);

        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("당첨 통계를 반환한다. - 3개 일치")
    @Test
    void compare_three_match() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        List<WinningStat> compare = referee.compare(lottos, player, bonusNumber);
        WinningStat result = compare.stream()
                .filter(winningStat -> winningStat.getWinningType().equals(WinningType.THREE_MATCH))
                .findAny()
                .orElseThrow();

        // then
        assertThat(result.getWinningType()).isEqualTo(WinningType.THREE_MATCH);
        assertThat(result.getCount()).isEqualTo(1);
    }

    @DisplayName("당첨 통계를 반환한다. - 4개 일치")
    @Test
    void compare_four_match() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 14);
        int bonusNumber = 7;

        // when
        List<WinningStat> compare = referee.compare(lottos, player, bonusNumber);
        WinningStat result = compare.stream()
                .filter(winningStat -> winningStat.getWinningType().equals(WinningType.FOUR_MATCH))
                .findAny()
                .orElseThrow();

        // then
        assertThat(result.getWinningType()).isEqualTo(WinningType.FOUR_MATCH);
        assertThat(result.getCount()).isEqualTo(1);
    }

    @DisplayName("당첨 통계를 반환한다. - 5개 일치")
    @Test
    void compareWithFiveMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 7;

        // when
        List<WinningStat> compare = referee.compare(lottos, player, bonusNumber);
        WinningStat result = compare.stream()
                .filter(winningStat -> winningStat.getWinningType().equals(WinningType.FIVE_MATCH))
                .findAny()
                .orElseThrow();

        // then
        assertThat(result.getWinningType()).isEqualTo(WinningType.FIVE_MATCH);
        assertThat(result.getCount()).isEqualTo(1);
    }

    @DisplayName("당첨 통계를 반환한다. - 5개 그리고 보너스 번호 일치")
    @Test
    void compareWithFiveMatchAndBonusNumberMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 45;

        // when
        List<WinningStat> compare = referee.compare(lottos, player, bonusNumber);
        WinningStat result = compare.stream()
                .filter(winningStat -> winningStat.getWinningType().equals(WinningType.FIVE_WITH_BONUS_MATCH))
                .findAny()
                .orElseThrow();

        // then
        assertThat(result.getWinningType()).isEqualTo(WinningType.FIVE_WITH_BONUS_MATCH);
        assertThat(result.getCount()).isEqualTo(1);
    }

    @DisplayName("당첨 통계를 반환한다. - 6개 일치")
    @Test
    void compareWithSixMatch() {
        // given
        List<Integer> player = List.of(1, 3, 5, 14, 22, 45);
        int bonusNumber = 7;

        // when
        List<WinningStat> compare = referee.compare(lottos, player, bonusNumber);
        WinningStat result = compare.stream()
                .filter(winningStat -> winningStat.getWinningType().equals(WinningType.SIX_MATCH))
                .findAny()
                .orElseThrow();

        // then
        assertThat(result.getWinningType()).isEqualTo(WinningType.SIX_MATCH);
        assertThat(result.getCount()).isEqualTo(1);
    }
}