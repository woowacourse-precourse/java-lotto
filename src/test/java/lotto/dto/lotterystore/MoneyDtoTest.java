package lotto.dto.lotterystore;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyDtoTest {
	@DisplayName("돈이 입력한 대로 들어왔는지 확인한다.") @Test void equalToInputTest() {
		MoneyDto moneyDto = new MoneyDto("5000");
		Assertions.assertThat(moneyDto.getMoney()).isEqualTo("5000");
	}

	@DisplayName("돈이 입력한 대로 들어왔는지 확인한다.") @Test void notEqualToInputTest1() {
		MoneyDto moneyDto = new MoneyDto("5000");
		Assertions.assertThat(moneyDto.getMoney()).isNotEqualTo("4253");
	}

	@DisplayName("돈이 입력한 대로 들어왔는지 확인한다.") @Test void notEqualToInputTest2() {
		MoneyDto moneyDto = new MoneyDto("5000");
		Assertions.assertThat(moneyDto.getMoney()).isNotEqualTo("!@$#%");
	}
}
