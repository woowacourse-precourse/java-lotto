package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MatchCountTest {
    @Test
    void equalsTest() {
        MatchCount matchCount1 = new MatchCount(1, 1);
        MatchCount matchCount2 = new MatchCount(1, 1);
        MatchCount matchCount3 = new MatchCount(1, 0);

        assertThat(matchCount1).isEqualTo(matchCount2);
        assertThat(matchCount1).isNotEqualTo(matchCount3);
    }

}