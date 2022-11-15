package lotto.dto.lotterystore;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersDtoTest {
	@DisplayName("입력한 로또 당첨번호가 제대로 들어왔는지") @Test void equalToInputTest() {
		WinningNumbersDto winningNumbersDto = new WinningNumbersDto("1,2,3,4,5,6", "7");
		Assertions.assertThat(winningNumbersDto.getWinningNumbers()).isEqualTo("1,2,3,4,5,6");
		Assertions.assertThat(winningNumbersDto.getBonusNumber()).isEqualTo("7");
	}

	@DisplayName("입력한 로또 당첨번호가 제대로 들어왔는지") @Test void notEqualToInputTest() {
		WinningNumbersDto winningNumbersDto = new WinningNumbersDto("1,2,3,4,5,6", "7");
		Assertions.assertThat(winningNumbersDto.getWinningNumbers())
			.isNotEqualTo("35,34,33,32,31,30");
		Assertions.assertThat(winningNumbersDto.getBonusNumber()).isNotEqualTo("22");
	}
}
