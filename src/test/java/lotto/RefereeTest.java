package lotto;

import static lotto.constant.MatchingType.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.MatchingType;
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
        MatchingType matchingType = FIVE_MATCH;
        Lotto lotto = lottos.get(7);
        int bonusNumber = 45;

        // when
        boolean checkBonusNumber = referee.checkBonusNumber(matchingType, lotto, bonusNumber);

        // then
        assertThat(checkBonusNumber).isTrue();
    }

    @DisplayName("플레이어가 로또 번호를 5개 맞췄으며 보너스 번호도 로또 번호와 일치하는지 반환 - 5개를 못 맞춘 경우")
    @Test
    void checkBonusNumberNotFiveMatch() {
        // given
        MatchingType matchingType = FOUR_MATCH;
        Lotto lotto = lottos.get(7);
        int bonusNumber = 45;

        // when
        boolean checkBonusNumber = referee.checkBonusNumber(matchingType, lotto, bonusNumber);

        // then
        assertThat(checkBonusNumber).isFalse();
    }

    @DisplayName("플레이어가 로또 번호를 5개 맞췄으며 보너스 번호도 로또 번호와 일치하는지 반환 - 보너스 번호를 못 맞춘 경우")
    @Test
    void checkBonusNumberNotBonusMatch() {
        // given
        MatchingType matchingType = FIVE_MATCH;
        Lotto lotto = lottos.get(7);
        int bonusNumber = 44;

        // when
        boolean checkBonusNumber = referee.checkBonusNumber(matchingType, lotto, bonusNumber);

        // then
        assertThat(checkBonusNumber).isFalse();
    }

    @DisplayName("플레이어가 로또 번호를 5개 맞췄으며 보너스 번호도 로또 번호와 일치하는지 반환 - 5개와 보너스 번호 둘 다 못 맞춘 경우")
    @Test
    void checkBonusNumberNoneMatch() {
        // given
        MatchingType matchingType = FOUR_MATCH;
        Lotto lotto = lottos.get(7);
        int bonusNumber = 44;

        // when
        boolean checkBonusNumber = referee.checkBonusNumber(matchingType, lotto, bonusNumber);

        // then
        assertThat(checkBonusNumber).isFalse();
    }

    @DisplayName("로또를 맞췄는지 반환 - 3개 일치")
    @Test
    void createMatchingTypeWithThreeMatch() {
        // given
        Lotto lotto = lottos.get(7);
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        MatchingType result = referee.createMatchingType(lotto, player, bonusNumber);

        // then
        assertThat(result).isEqualTo(THREE_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 4개 일치")
    @Test
    void createMatchingTypeWithFourMatch() {
        // given
        Lotto lotto = lottos.get(7);
        List<Integer> player = List.of(1, 2, 3, 4, 5, 14);
        int bonusNumber = 7;

        // when
        MatchingType result = referee.createMatchingType(lotto, player, bonusNumber);

        // then
        assertThat(result).isEqualTo(FOUR_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 5개 일치")
    @Test
    void createMatchingTypeWithFiveMatch() {
        // given
        Lotto lotto = lottos.get(7);
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 7;

        // when
        MatchingType result = referee.createMatchingType(lotto, player, bonusNumber);

        // then
        assertThat(result).isEqualTo(FIVE_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 5개 그리고 보너스 번호 일치")
    @Test
    void createMatchingTypeWithFiveMatchAndBonusNumberMatch() {
        // given
        Lotto lotto = lottos.get(7);
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 45;

        // when
        MatchingType result = referee.createMatchingType(lotto, player, bonusNumber);

        // then
        assertThat(result).isEqualTo(FIVE_WITH_BONUS_MATCH);
    }

    @DisplayName("로또를 맞췄는지 반환. - 6개 일치")
    @Test
    void createMatchingTypeWithSixMatch() {
        // given
        Lotto lotto = lottos.get(7);
        List<Integer> player = List.of(1, 3, 5, 14, 22, 45);
        int bonusNumber = 7;

        // when
        MatchingType result = referee.createMatchingType(lotto, player, bonusNumber);

        // then
        assertThat(result).isEqualTo(SIX_MATCH);
    }

    @Test
    void calculateStatWithThreeMatch() {
        // given
        Lotto lotto = lottos.get(lottos.size() - 1);
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        MatchingType matchingType = referee.createMatchingType(lotto, player, bonusNumber);

        // when
        referee.calculateStat(matchingType);
        List<WinningStat> result = referee.getResult();

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(1, 0, 0, 0, 0);
    }

    @Test
    void calculateStatWithFourMatch() {
        // given
        Lotto lotto = lottos.get(lottos.size() - 1);
        List<Integer> player = List.of(1, 2, 3, 4, 5, 14);
        int bonusNumber = 7;
        MatchingType matchingType = referee.createMatchingType(lotto, player, bonusNumber);

        // when
        referee.calculateStat(matchingType);
        List<WinningStat> result = referee.getResult();

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 1, 0, 0, 0);
    }

    @Test
    void calculateStatWithFiveMatch() {
        // given
        Lotto lotto = lottos.get(lottos.size() - 1);
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 7;
        MatchingType matchingType = referee.createMatchingType(lotto, player, bonusNumber);

        // when
        referee.calculateStat(matchingType);
        List<WinningStat> result = referee.getResult();

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 0, 1, 0, 0);
    }

    @Test
    void calculateStatWithFiveMatchAndBonusMatch() {
        // given
        Lotto lotto = lottos.get(lottos.size() - 1);
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 45;
        MatchingType matchingType = referee.createMatchingType(lotto, player, bonusNumber);

        // when
        referee.calculateStat(matchingType);
        List<WinningStat> result = referee.getResult();

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 0, 0, 1, 0);
    }

    @Test
    void calculateStatWithSixMatch() {
        // given
        Lotto lotto = lottos.get(lottos.size() - 1);
        List<Integer> player = List.of(1, 3, 5, 14, 22, 45);
        int bonusNumber = 7;
        MatchingType matchingType = referee.createMatchingType(lotto, player, bonusNumber);

        // when
        referee.calculateStat(matchingType);
        List<WinningStat> result = referee.getResult();

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 0, 0, 0, 1);
    }

    @Test
    void calculateStatWithNoneMatch() {
        // given
        Lotto lotto = lottos.get(lottos.size() - 1);
        List<Integer> player = List.of(1, 2, 3, 4, 12, 37);
        int bonusNumber = 7;
        MatchingType matchingType = referee.createMatchingType(lotto, player, bonusNumber);

        // when
        referee.calculateStat(matchingType);
        List<WinningStat> result = referee.getResult();

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 0, 0, 0, 0);
    }

    @DisplayName("당첨 통계를 반환. - 3개 일치")
    @Test
    void compareWithThreeMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        // when
        List<WinningStat> result = referee.compare(lottos, player, bonusNumber);

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(1, 0, 0, 0, 0);
    }

    @DisplayName("당첨 통계를 반환. - 4개 일치")
    @Test
    void compareWithFourMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 5, 14);
        int bonusNumber = 7;

        // when
        List<WinningStat> result = referee.compare(lottos, player, bonusNumber);

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 1, 0, 0, 0);
    }

    @DisplayName("당첨 통계를 반환. - 5개 일치")
    @Test
    void compareWithFiveMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 7;

        // when
        List<WinningStat> result = referee.compare(lottos, player, bonusNumber);

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 0, 1, 0, 0);
    }

    @DisplayName("당첨 통계를 반환. - 5개 일치 그리고 보너스 번호 일치")
    @Test
    void compareWithFiveMatchAndBonusNumberMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 5, 14, 22);
        int bonusNumber = 45;

        // when
        List<WinningStat> result = referee.compare(lottos, player, bonusNumber);

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 0, 0, 1, 0);
    }

    @DisplayName("당첨 통계를 반환. - 6개 일치")
    @Test
    void compareWithSixMatch() {
        // given
        List<Integer> player = List.of(1, 3, 5, 14, 22, 45);
        int bonusNumber = 7;

        // when
        List<WinningStat> result = referee.compare(lottos, player, bonusNumber);

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 0, 0, 0, 1);
    }

    @DisplayName("당첨 통계를 반환. - 일치하지 않음")
    @Test
    void compareWithNoneMatch() {
        // given
        List<Integer> player = List.of(1, 2, 3, 4, 12, 37);
        int bonusNumber = 7;

        // when
        List<WinningStat> result = referee.compare(lottos, player, bonusNumber);

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(0, 0, 0, 0, 0);
    }

    @DisplayName("당첨 통계를 반환. - 각각 2번씩 당첨")
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
        List<WinningStat> result = referee.compare(lottos, player, bonusNumber);

        List<MatchingType> matchingTypes = result.stream()
                .map(WinningStat::getMatchingType)
                .collect(Collectors.toList());
        List<Integer> counts = result.stream()
                .map(WinningStat::getCount)
                .collect(Collectors.toList());

        // then
        assertThat(matchingTypes).containsExactly(THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_WITH_BONUS_MATCH,
                SIX_MATCH);
        assertThat(counts).containsExactly(2, 2, 2, 2, 2);
    }
}