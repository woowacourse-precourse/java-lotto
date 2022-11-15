package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatchTest {

    @DisplayName("로또 추첨 결과가 1등인 경우의 Match.SIX_MATCH 반환")
    @Test
    void check1stMatch() {
        int matchCount = 6;
        boolean isMatchBonus = false;
        // isMatchBonus의 값은 2등인 경우를 제외하고는 영향을 주지 않는다.

        Match match = Match.findByMatchCountAndIsMatchBonus(matchCount, isMatchBonus);

        assertThat(match).isEqualTo(Match.SIX_MATCH);
    }

    @DisplayName("로또 추첨 결과가 2등인 경우의 Match.FIVE_BONUS_MATCH 반환")
    @Test
    void check2ndMatch() {
        int matchCount = 5;
        boolean isMatchBonus = true;
        // isMatchBonus의 값은 2등인 경우를 제외하고는 영향을 주지 않는다.

        Match match = Match.findByMatchCountAndIsMatchBonus(matchCount, isMatchBonus);

        assertThat(match).isEqualTo(Match.FIVE_BONUS_MATCH);
    }

    @DisplayName("로또 추첨 결과가 3등인 경우의 Match.FIVE_MATCH 반환")
    @Test
    void check3rdMatch() {
        int matchCount = 5;
        boolean isMatchBonus = false;
        // isMatchBonus의 값은 2등인 경우를 제외하고는 영향을 주지 않는다.

        Match match = Match.findByMatchCountAndIsMatchBonus(matchCount, isMatchBonus);

        assertThat(match).isEqualTo(Match.FIVE_MATCH);
    }

    @DisplayName("로또 추첨 결과가 4등인 경우의 Match.FOUR_MATCH 반환")
    @Test
    void check4thMatch() {
        int matchCount = 4;
        boolean isMatchBonus = false;
        // isMatchBonus의 값은 2등인 경우를 제외하고는 영향을 주지 않는다.

        Match match = Match.findByMatchCountAndIsMatchBonus(matchCount, isMatchBonus);

        assertThat(match).isEqualTo(Match.FOUR_MATCH);
    }

    @DisplayName("로또 추첨 결과가 5등인 경우의 Match.THREE_MATCH 반환")
    @Test
    void check5thMatch() {
        int matchCount = 3;
        boolean isMatchBonus = false;
        // isMatchBonus의 값은 2등인 경우를 제외하고는 영향을 주지 않는다.

        Match match = Match.findByMatchCountAndIsMatchBonus(matchCount, isMatchBonus);

        assertThat(match).isEqualTo(Match.THREE_MATCH);
    }

    @DisplayName("여러 로또들에 대한 추첨 결과에 대해 총 상금을 계산한다.")
    @Test
    void calculatePrizeMoney() {
        List<Match> matches = Arrays.asList(Match.SIX_MATCH, Match.FIVE_MATCH, Match.FOUR_MATCH);

        long prizeMoney = Match.calculateTotalPrizeMoney(matches);

        assertThat(prizeMoney)
                .isEqualTo(Match.SIX_MATCH.getPrizeMoney() + Match.FIVE_MATCH.getPrizeMoney() + Match.FOUR_MATCH.getPrizeMoney());
    }


}