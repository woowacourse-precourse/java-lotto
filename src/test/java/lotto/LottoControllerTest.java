package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

	MyModel model = new MyModel();
	MyView view = new MyView(model);
	LottoController controller = new LottoController(model, view);

	@DisplayName("오류 없이 하나의 로또가 생성되어야 한다.")
	@Test
	void generateLottoTest() {
		Assertions.assertThat(controller.generateLotto()).isInstanceOf(Lotto.class);
	}

	@DisplayName("두 로또 간 일치하는 숫자의 개수를 세야 한다.")
	@Test
	void getCorrectionsTest() {
		Lotto input = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto target1 = new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7));
		Lotto target2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
		Assertions.assertThat(controller.getCorrections(input, target1)).isEqualTo(5);
		Assertions.assertThat(controller.getCorrections(input, target2)).isEqualTo(0);
	}

	@DisplayName("두 로또 간 일치하는 숫자의 개수를 세야 한다.")
	@Test
	void isThereBonusTest() {
		Lotto input = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		int bonus1 = 5;
		int bonus2 = 7;
		assertTrue(controller.isThereBonus(input, bonus1));
		assertFalse(controller.isThereBonus(input, bonus2));
	}
}
