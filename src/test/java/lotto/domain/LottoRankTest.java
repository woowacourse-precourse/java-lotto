package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {

    @DisplayName("당첨 번호 일치 개수와 보너스 번호 포함 여부로 로또의 등수를 알 수 있다.")
    @Test
    void getRank() {
        // given
        int matchCount = 5;
        boolean hasBonusNumber = true;

        // when
        LottoRank rank = LottoRank.getRank(matchCount, hasBonusNumber);

        // then
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("상금을 출력할 때 천단위로 쉼표가 들어간다.")
    @Test
    void getPrizeMoney() {
        assertThat(LottoRank.FIFTH.getPrizeMoney()).isEqualTo("5,000");
    }
}
