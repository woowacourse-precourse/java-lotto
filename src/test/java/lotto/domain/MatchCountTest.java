package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MatchCountTest {

    @DisplayName("같은 등수 반환 테스트")
    @Test
    void 같은_등수_반환_테스트() {
        MatchCount matchCount1 = new MatchCount(3, 0);
        MatchCount matchCount2 = new MatchCount(3, 1);
        MatchCount matchCount3 = new MatchCount(4, 0);
        MatchCount matchCount4 = new MatchCount(5, 0);
        MatchCount matchCount5 = new MatchCount(5, 1);
        MatchCount matchCount6 = new MatchCount(6, 0);

        assertTrue(matchCount1.isSameResult(matchCount2));
        assertFalse(matchCount1.isSameResult(matchCount3));
        assertFalse(matchCount3.isSameResult(matchCount4));
        assertFalse(matchCount4.isSameResult(matchCount5));
        assertFalse(matchCount5.isSameResult(matchCount6));
    }

    @DisplayName("결과 생성 오류 테스트")
    @Test
    void 결과_생성_오류_테스트() {
        assertThatThrownBy(() -> new MatchCount(2, 2))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new MatchCount(6, 1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new MatchCount(5, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}