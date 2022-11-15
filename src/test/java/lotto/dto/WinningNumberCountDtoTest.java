package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningNumberCountDtoTest {

    @Test
    @DisplayName("WinningNumberCountDto 인스턴스 생성 테스트")
    void of() {
        // given
        int winningCount = 10;
        boolean isMatchBonusNumber = true;

        // when
        WinningNumberCountDto result = WinningNumberCountDto.of(winningCount, isMatchBonusNumber);

        // then
        assertThat(winningCount).isEqualTo(result.getWinningCount());
        assertThat(isMatchBonusNumber).isEqualTo(result.isMatchBonusNumber());
    }
}