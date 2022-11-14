package lotto;

import static org.junit.jupiter.api.Assertions.*;

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
}
