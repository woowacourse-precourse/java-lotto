package lotto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoCompany;
import lotto.model.LottoMachine;
import lotto.model.LottoRanking;
import lotto.model.PrizeChecker;
import lotto.model.Wallet;
import lotto.view.OutputView;
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
		Wallet wallet = new LottoMachine(8000).buyLotto();
		OutputView outputView = OutputView.getInstance();
		outputView.LottoInformation(wallet.getMyLotto().size(), wallet.getMyLotto());
	}

    @DisplayName("당첨번호와 일치 갯수 확인")
    @Test
    void matchCountingtest() throws NoSuchMethodException {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        LottoCompany lottoCompany = new LottoCompany(
            List.of(8,21,23,41,42,43),
            22);
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
			List.of(8,21,23,41,42,43),
			22
		);
		List<Lotto> lottos = new ArrayList<>();
		PrizeChecker prizeChecker = new PrizeChecker(lottoCompany, lottos);
		Method method = prizeChecker.getClass().getDeclaredMethod("checkBonus", int.class, List.class, int.class);
		method.setAccessible(true);
		boolean isBonus = false;

		try {
			isBonus = (boolean) method.invoke(prizeChecker, 5, List.of(11, 12, 13, 14, 15, 16), 15);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} finally {
			assertThat(isBonus).isEqualTo(true);
		}
	}

	@DisplayName("상금 계산 테스트")
	@Test
	void sumPrizeTest() throws NoSuchMethodException {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성\
		//given
		LottoCompany lottoCompany = new LottoCompany(
			List.of(8,21,23,41,42,43),
			22
		);
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(new Lotto(List.of(8, 21, 22, 41, 42, 43))); //2등
		lottos.add(new Lotto(List.of(8, 21, 2, 41, 42, 43))); //3등
		PrizeChecker prizeChecker = new PrizeChecker(lottoCompany, lottos);
		Method method = prizeChecker.getClass().getDeclaredMethod("sumPrize", null);
		method.setAccessible(true);
		int totalPrizeMoney = 0;

		try {
			totalPrizeMoney = (int) method.invoke(prizeChecker);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} finally {
			assertThat(totalPrizeMoney).isEqualTo(31500000);
		}
	}

	@DisplayName("로또 당첨기 확인")
	@Test
	void PrizeCheckerTest() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		LottoCompany lottoCompany = new LottoCompany(
			List.of(8,21,23,41,42,43),
			22
		);
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43))); //1등
		lottos.add(new Lotto(List.of(8, 21, 22, 41, 42, 43))); //2등
		lottos.add(new Lotto(List.of(8, 21, 2, 41, 42, 43))); //3등
		lottos.add(new Lotto(List.of(8, 21, 23, 41, 42, 43))); //1등

		PrizeChecker prizeChecker = new PrizeChecker(lottoCompany, lottos);

		assertThat(prizeChecker.getPrizeResult().get(LottoRanking.FIRST)).isEqualTo(2);
	}


	@DisplayName("수익률 테스트")
	@Test
	void calculationYieldTest() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		LottoCompany lottoCompany = new LottoCompany(
			List.of(8,21,23,41,42,43),
			22
		);
		List<Lotto> lottos = new ArrayList<>();
		lottos.add(new Lotto(List.of(8, 21, 2, 3, 4, 43))); //5등

		PrizeChecker prizeChecker = new PrizeChecker(lottoCompany, lottos);
		double Yield = prizeChecker.calculationYield(8000);

		assertThat(Yield).isEqualTo(62.5);
	}

	@DisplayName("로또 결고 출력 테스트")
	@Test
	void lottoResultTest() {
		// TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
		Map<LottoRanking, Integer> prizeResult = new EnumMap<>(LottoRanking.class);
		prizeResult.put(LottoRanking.FIRST, 2);
		prizeResult.put(LottoRanking.SECOND, 3);
		prizeResult.put(LottoRanking.FIFTH, 5);
		prizeResult.put(LottoRanking.FOURTH, 0);
		prizeResult.put(LottoRanking.THIRD, 0);
		prizeResult.put(LottoRanking.EMPTY, 0);

		OutputView outputView = OutputView.getInstance();
		outputView.lottoResult(prizeResult);
		outputView.yield(3.555);
	}



}
