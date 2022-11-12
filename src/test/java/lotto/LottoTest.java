package lotto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import lotto.controller.MainController;
import lotto.model.Lotto;
import lotto.model.LottoCompany;
import lotto.model.LottoMachine;
import lotto.model.LottoRanking;
import lotto.model.PrizeChecker;
import lotto.model.Wallet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

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
	@DisplayName("지불 금액에 맞는 로또를 구매한다")
	@Test
	void createLottoMachine() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		Wallet wallet = new LottoMachine(8532).buyLotto();

		assertThat(wallet.getMyLotto().size()).isEqualTo(8);
	}

	@DisplayName("지불 금액에 맞는 로또를 구매한다 (지불 금액이 없는 경우)")
	@Test
	void createLottoMachineNoMoney() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		assertThatThrownBy(() ->  new LottoMachine(532).buyLotto())
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("로또 금액 확인")
	@Test
	void LottoInformationViewTest() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		MainController mainController = new MainController();
		Wallet wallet = new LottoMachine(8000).buyLotto();
		mainController.viewLotto(wallet.getMyLotto().size(), wallet.getMyLotto());
	}

    @DisplayName("당첨번호와 일치 갯수 확인")
    @Test
    void matchCountingtest() throws NoSuchMethodException {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        LottoCompany lottoCompany = new LottoCompany(
            "8,21,23,41,42,43",
            "22");
		Wallet wallet = new LottoMachine(8000).buyLotto();
        PrizeChecker prizeChecker = new PrizeChecker(lottoCompany, wallet.getMyLotto());
		Method method = prizeChecker.getClass().getDeclaredMethod("countingMatch", List.class, List.class);
		method.setAccessible(true);
		int matchCount = 0;

		try {
			matchCount = (int) method.invoke(prizeChecker, List.of(11, 12, 13, 14), List.of(11, 12, 13, 14));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} finally {
			assertThat(matchCount).isEqualTo(4);
		}
    }



	@DisplayName("로또 보너스(2등) 당첨 확인")
	@Test
	void secondPrizeCheck() throws NoSuchMethodException {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성\
		//given
		LottoCompany lottoCompany = new LottoCompany(
			"8,21,23,41,42,43",
			"22"
		);
		List<Lotto> lottos = new ArrayList<>();
		PrizeChecker prizeChecker = new PrizeChecker(lottoCompany, lottos);
		Method method = prizeChecker.getClass().getDeclaredMethod("checkBonus", int.class, List.class, int.class);
		method.setAccessible(true);
		int bonusNumber = 0;

		try {
			bonusNumber = (int) method.invoke(prizeChecker, 5, List.of(11, 12, 13, 14, 15, 16), 16);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} finally {
			assertThat(bonusNumber).isEqualTo(22);
		}
	}

	@DisplayName("로또 당첨기 확인")
	@Test
	void PrizeCheckerTest() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		LottoCompany lottoCompany = new LottoCompany(
			"8,21,23,41,42,43",
			"22"
		);
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43))); //1등
		lottos.add(new Lotto(List.of(8, 21, 22, 41, 42, 43))); //2등
		lottos.add(new Lotto(List.of(8, 21, 2, 41, 42, 43))); //3등
		lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43))); //1등

		PrizeChecker prizeChecker = new PrizeChecker(lottoCompany, lottos);

		assertThat(prizeChecker.getPrizeResult().get(LottoRanking.FIRST)).isEqualTo(2);
	}

}
