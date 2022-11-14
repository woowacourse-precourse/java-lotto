package lotto;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

class LottoTest extends NsTest {
	private static final String ERROR_MESSAGE = "[ERROR]";

	@DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
	@Test
	void createLottoByOverSize() {
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
	@Test
	void createLottoByDuplicatedNumber() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
			.isInstanceOf(IllegalArgumentException.class);
	}

	// 아래에 추가 테스트 작성 가능

	@Test
	void 당첨번호_비교_후_맞은_개수_세기() {
		Service service = new Service();
		List<Integer> onePurchaseLotto = new ArrayList<>(List.of(1, 2, 3, 4, 5, 7));
		Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
		int bonusNumber = 7;
		for (int i = 0; i < Constant.LOTTO_LENGTH; i++) {
			service.checkNumberSame(lotto.getNumbers().get(i), onePurchaseLotto);
		}
		service.checkBonusNumberSame(bonusNumber, onePurchaseLotto);

		assertThat(5).isEqualTo(service.numberCount.guess);
		assertThat(1).isEqualTo(service.numberCount.bonusGuess);
	}

	@Test
	void 당첨된_로또의_개수_금액_저장() {
		Service service = new Service();
		service.setPrize();
		service.checkRank(5, 1);//2등 2번 저장
		service.checkRank(5, 1);

		assertThat(2).isEqualTo(service.prize.get(30000000));

	}

	@Test
	void 총_당첨금_계산() {
		Service service = new Service();
		service.setPrize();
		service.checkRank(5, 1);//2등 2번 저장
		service.checkRank(5, 1);

		assertThat(60000000).isEqualTo(service.totalPrize());

	}

	@Test
	void 수익률_계산() {
		Service service = new Service();
		service.money = 8000;
		service.setPrize();
		service.checkRank(3, 0);

		assertThat(62.5).isEqualTo(service.yield());

	}

	@Test
	void 금액_1000원_단위_검사() {
		assertSimpleTest(() -> {
			runException("1500");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void 입력금액_범위_검사() {
		assertSimpleTest(() -> {
			runException("0");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void 입력한_금액_자연수_검사() {
		assertSimpleTest(() -> {
			runException("1000k");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void 당첨번호_6개_검사() {
		assertSimpleTest(() -> {
			runException("1000", "1,2,3,4,5,6,7");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void 당첨번호_중복_검사() {
		assertSimpleTest(() -> {
			runException("1000", "1,2,3,4,5,5");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void 당첨번호_자연수_검사() {
		assertSimpleTest(() -> {
			runException("1000", "1,2,3,4,5,a");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void 보너스번호_자연수_검사() {
		assertSimpleTest(() -> {
			runException("1000", "1,2,3,4,5,6", "a");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void 당첨번호_범위_검사() {
		assertSimpleTest(() -> {
			runException("1000", "1,2,3,4,5,46");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void 보너스번호_범위_검사() {
		assertSimpleTest(() -> {
			runException("1000", "1,2,3,4,5,6", "46");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Test
	void 보너스번호_중복_검사() {
		assertSimpleTest(() -> {
			runException("1000", "1,2,3,4,5,45", "45");
			assertThat(output()).contains(ERROR_MESSAGE);
		});
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}

}
