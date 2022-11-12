package lotto;

import static lotto.WinningType.*;
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

    @DisplayName("보너스 번호가 로또 번호와 일치하는지 반환 - 일치")
    @Test
    void isBonusNumberMatch() {
        // given
        Lotto lotto = lottos.get(7);
        int bonusNumber = 45;

        // when
        boolean bonusNumberMatch = referee.isBonusNumberMatch(lotto, bonusNumber);

        // then
        assertThat(bonusNumberMatch).isTrue();
    }

    @DisplayName("보너스 번호가 로또 번호와 일치하는지 반환 - 불일치")
    @Test
    void isBonusNumberNotMatch() {
        // given
        Lotto lotto = lottos.get(7);
        int bonusNumber = 44;

        // when
        boolean bonusNumberMatch = referee.isBonusNumberMatch(lotto, bonusNumber);

        // then
        assertThat(bonusNumberMatch).isFalse();
    }

    @DisplayName("플레이어가 로또 번호를 5개 맞췄으며 보너스 번호도 로또 번호와 일치하는지 반환")
    @Test
    void checkBonusNumber() {
        // given
        WinningType winningType = FIVE_MATCH;
        Lotto lotto = lottos.get(7);
        int bonusNumber = 45;

        // when
        boolean checkBonusNumber = referee.checkBonusNumber(winningType, lotto, bonusNumber);

        // then
        assertThat(checkBonusNumber).isTrue();
    }

    @DisplayName("플레이어가 로또 번호를 5개 맞췄으며 보너스 번호도 로또 번호와 일치하는지 반환 - 5개를 못 맞춘 경우")
    @Test
    void checkBonusNumberNotFiveMatch() {
        // given
        WinningType winningType = FOUR_MATCH;
        Lotto lotto = lottos.get(7);
        int bonusNumber = 45;

        // when
        boolean checkBonusNumber = referee.checkBonusNumber(winningType, lotto, bonusNumber);

        // then
        assertThat(checkBonusNumber).isFalse();
    }

    @DisplayName("플레이어가 로또 번호를 5개 맞췄으며 보너스 번호도 로또 번호와 일치하는지 반환 - 보너스 번호를 못 맞춘 경우")
    @Test
    void checkBonusNumberNotBonusMatch() {
        // given
        WinningType winningType = FIVE_MATCH;
        Lotto lotto = lottos.get(7);
        int bonusNumber = 44;

        // when
        boolean checkBonusNumber = referee.checkBonusNumber(winningType, lotto, bonusNumber);

        // then
        assertThat(checkBonusNumber).isFalse();
    }

    @DisplayName("플레이어가 로또 번호를 5개 맞췄으며 보너스 번호도 로또 번호와 일치하는지 반환 - 5개와 보너스 번호 둘 다 못 맞춘 경우")
    @Test
    void checkBonusNumberNoneMatch() {
        // given
        WinningType winningType = FOUR_MATCH;
        Lotto lotto = lottos.get(7);
        int bonusNumber = 44;

        // when
        boolean checkBonusNumber = referee.checkBonusNumber(winningType, lotto, bonusNumber);

        // then
        assertThat(checkBonusNumber).isFalse();
    }

    @DisplayName("로또를 맞췄는지 반환 - 3개 일치")
    @Test
    void compareWithThreeMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        List<WinningType> compare = referee.compare(lottos, player, bonusNumber);
        WinningType result = compare.stream()
                .filter(winningType -> winningType == THREE_MATCH)
                .findAny()
                .orElseThrow();

        // then
        assertThat(result).isEqualTo(THREE_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 4개 일치")
    @Test
    void compareWithFourMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 14);
        int bonusNumber = 7;

        // when
        List<WinningType> compare = referee.compare(lottos, player, bonusNumber);
        WinningType result = compare.stream()
                .filter(winningType -> winningType == FOUR_MATCH)
                .findAny()
                .orElseThrow();

        // then
        assertThat(result).isEqualTo(FOUR_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 5개 일치")
    @Test
    void compareWithFiveMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 7;

        // when
        List<WinningType> compare = referee.compare(lottos, player, bonusNumber);
        WinningType result = compare.stream()
                .filter(winningType -> winningType == FIVE_MATCH)
                .findAny()
                .orElseThrow();

        // then
        assertThat(result).isEqualTo(FIVE_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 5개 그리고 보너스 번호 일치")
    @Test
    void compareWithFiveMatchAndBonusNumberMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 45;

        // when
        List<WinningType> compare = referee.compare(lottos, player, bonusNumber);
        WinningType result = compare.stream()
                .filter(winningType -> winningType == FIVE_WITH_BONUS_MATCH)
                .findAny()
                .orElseThrow();

        // then
        assertThat(result).isEqualTo(FIVE_WITH_BONUS_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 6개 일치")
    @Test
    void compareWithSixMatch() {
        // given
        List<Integer> player = List.of(1, 3, 5, 14, 22, 45);
        int bonusNumber = 7;

        // when
        List<WinningType> compare = referee.compare(lottos, player, bonusNumber);
        WinningType result = compare.stream()
                .filter(winningType -> winningType == SIX_MATCH)
                .findAny()
                .orElseThrow();

        // then
        assertThat(result).isEqualTo(SIX_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 일치하지 않음")
    @Test
    void compareWithNoneMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 12, 37);
        int bonusNumber = 7;

        // when
        List<WinningType> compare = referee.compare(lottos, player, bonusNumber);

        WinningType resultThreeMatch = compare.stream()
                .filter(winningType -> winningType == THREE_MATCH)
                .findAny()
                .orElse(NOT_MATCH);

        WinningType resultFourMatch = compare.stream()
                .filter(winningType -> winningType == FOUR_MATCH)
                .findAny()
                .orElse(NOT_MATCH);

        WinningType resultFiveMatch = compare.stream()
                .filter(winningType -> winningType == FIVE_MATCH)
                .findAny()
                .orElse(NOT_MATCH);

        WinningType resultFiveMatchWithBonus = compare.stream()
                .filter(winningType -> winningType == FIVE_WITH_BONUS_MATCH)
                .findAny()
                .orElse(NOT_MATCH);

        WinningType resultSixMatch = compare.stream()
                .filter(winningType -> winningType == SIX_MATCH)
                .findAny()
                .orElse(NOT_MATCH);

        // then
        assertThat(resultThreeMatch).isEqualTo(NOT_MATCH);
        assertThat(resultFourMatch).isEqualTo(NOT_MATCH);
        assertThat(resultFiveMatch).isEqualTo(NOT_MATCH);
        assertThat(resultFiveMatchWithBonus).isEqualTo(NOT_MATCH);
        assertThat(resultSixMatch).isEqualTo(NOT_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 2번씩 당첨")
    @Test
    void compareWithAllTwoMatch() {
        // given
        lottos = List.of(
                new Lotto(List.of(1, 2, 3, 40, 41, 42)),
                new Lotto(List.of(4, 5, 6, 40, 41, 42)),
                new Lotto(List.of(1, 2, 3, 4, 40, 41)),
                new Lotto(List.of(3, 4, 5, 6, 40, 41)),
                new Lotto(List.of(1, 2, 3, 4, 5, 40)),
                new Lotto(List.of(2, 3, 4, 5, 6, 40)),
                new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                new Lotto(List.of(2, 3, 4, 5, 6, 7)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        List<WinningType> compare = referee.compare(lottos, player, bonusNumber);

        WinningType resultThreeMatch = compare.stream()
                .filter(winningType -> winningType == THREE_MATCH)
                .findAny()
                .orElseThrow();

        WinningType resultFourMatch = compare.stream()
                .filter(winningType -> winningType == FOUR_MATCH)
                .findAny()
                .orElseThrow();

        WinningType resultFiveMatch = compare.stream()
                .filter(winningType -> winningType == FIVE_MATCH)
                .findAny()
                .orElseThrow();

        WinningType resultFiveMatchWithBonus = compare.stream()
                .filter(winningType -> winningType == FIVE_WITH_BONUS_MATCH)
                .findAny()
                .orElseThrow();

        WinningType resultSixMatch = compare.stream()
                .filter(winningStat -> winningStat == SIX_MATCH)
                .findAny()
                .orElseThrow();

        // then
        assertThat(resultThreeMatch).isEqualTo(THREE_MATCH);
        assertThat(resultFourMatch).isEqualTo(FOUR_MATCH);
        assertThat(resultFiveMatch).isEqualTo(FIVE_MATCH);
        assertThat(resultFiveMatchWithBonus).isEqualTo(FIVE_WITH_BONUS_MATCH);
        assertThat(resultSixMatch).isEqualTo(SIX_MATCH);
    }
}