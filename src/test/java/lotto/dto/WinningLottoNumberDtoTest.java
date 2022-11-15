package lotto.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoNumberDtoTest {

    @Test
    @DisplayName("WinningLottoNumberDto 인스턴스 생성 테스트")
    void createWinningLottoNumber() {
        // given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        int bonusNumber = 7;

        // when
        WinningLottoNumberDto result = WinningLottoNumberDto.createWinningLottoNumber(winningNumbers, bonusNumber);

        // then
        assertThat(winningNumbers).isEqualTo(result.getWinningNumbers());
        assertThat(bonusNumber).isEqualTo(result.getBonusNumber());
    }
}