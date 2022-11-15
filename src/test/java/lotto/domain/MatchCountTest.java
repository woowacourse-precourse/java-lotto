package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchCountTest {

    @DisplayName("당첨 번호 3개일치와 당첨번호3개일치+보너스1개일치의 등수는 같아야 한다.")
    @Test
    void isSameResultTest_threeMatch() {
        MatchCount matchCount1 = new MatchCount(3, 0);
        MatchCount matchCount2 = new MatchCount(3, 1);

        assertTrue(matchCount1.isSameResult(matchCount2));
    }

    @DisplayName("당첨 번호 4개일치와 당첨번호4개일치+보너스1개일치의 등수는 같아야 한다.")
    @Test
    void isSameResultTest_fourMatch() {
        MatchCount matchCount1 = new MatchCount(4, 0);
        MatchCount matchCount2 = new MatchCount(4, 1);

        assertTrue(matchCount1.isSameResult(matchCount2));
    }

    @DisplayName("당첨 번호 5개일치와 당첨번호5개일치+보너스1개일치의 등수는 달라야 한다.")
    @Test
    void isSameResultTest_fiveMatch() {
        MatchCount matchCount1 = new MatchCount(5, 0);
        MatchCount matchCount2 = new MatchCount(5, 1);

        assertFalse(matchCount1.isSameResult(matchCount2));
    }

    @DisplayName("당첨 번호 당첨번호5개일치+보너스1개일치와 당첨번호6개일치의 등수는 달라야 한다.")
    @Test
    void isSameResultTest_sixMatch() {
        MatchCount matchCount1 = new MatchCount(5, 1);
        MatchCount matchCount2 = new MatchCount(6, 0);

        assertFalse(matchCount1.isSameResult(matchCount2));
    }

    @DisplayName("보너스 개수가 2개 이상일 경우 에러가 발생한다.")
    @Test
    void createMatchCountError_bonus() {
        assertThatThrownBy(() -> new MatchCount(2, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결과 생성 오류 테스트 당첨 개수과 보너스 개수는 합해서 6개를 넘을 수 없다.")
    @Test
    void createMatchCountError_over() {
        assertThatThrownBy(() -> new MatchCount(6, 1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new MatchCount(5, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}