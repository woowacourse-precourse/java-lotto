package lotto;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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

	@DisplayName("정답에 따른 통계를 저장해야 한다.")
	@Test
	void addToAnalysisTest() {
		List<Integer> analysis = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
		int corrections = 3;
		boolean hasBonus = false;
		controller.addToAnalysis(analysis, corrections, hasBonus);
		Assertions.assertThat(analysis).isEqualTo(Arrays.asList(1, 0, 0, 0, 0));

		corrections = 4;
		controller.addToAnalysis(analysis, corrections, hasBonus);
		Assertions.assertThat(analysis).isEqualTo(Arrays.asList(1, 1, 0, 0, 0));

		corrections = 5;
		controller.addToAnalysis(analysis, corrections, hasBonus);
		Assertions.assertThat(analysis).isEqualTo(Arrays.asList(1, 1, 1, 0, 0));
	}

	@DisplayName("입력에 따른 수익률 메시지를 반환해야 한다.")
	@Test
	void getProfitMsgTest() {
		Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
		Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7));
		List<Lotto> lottos = Arrays.asList(lotto1, lotto2);

		List<Integer> analysis = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
		controller.addToAnalysis(analysis, 3, false);
		String profitMsg = controller.getProfitMsg(lottos, analysis);
		String expectedMsg = "총 수익률은 250.0%입니다.";
		Assertions.assertThat(profitMsg).isEqualTo(expectedMsg);
	}
}
