package lotto.views;

import lotto.constants.Constant;
import lotto.models.Lotto;
import lotto.models.LottoResult;
import lotto.models.Rank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PrinterTest {
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	void setUpStreams() {
		System.setOut(new PrintStream(outputStream)); // 테스트용 output stream 으로 교체
	}

	@AfterEach
	void restoreStreams() {
		System.setOut(System.out); // 원상복구
		outputStream.reset();
	}

	@DisplayName("사용자가 구매한 로또 번호들이 정상적으로 출력되는지 테스트")
	@Test
	void checkUserLotteriesPrintTest() {
		// given : 사용자가 구매한 로또 목록
		final List<Lotto> lotteries = List.of(
				new Lotto(List.of(1, 2, 3, 4, 5, 6)),
				new Lotto(List.of(3, 4, 5, 6, 7, 8)),
				new Lotto(List.of(6, 2, 42, 9, 29, 13))
		);

		// when : 사용자가 가진 로또 번호들을 출력했을 때
		Printer.showUserLottoNumbers(lotteries);

		// then : 출력 결과가 정상적으로 나오는지 확인
		final String expected = "[1, 2, 3, 4, 5, 6]\n" +
				"[3, 4, 5, 6, 7, 8]\n" +
				"[6, 2, 42, 9, 29, 13]\n";
		assertThat(outputStream.toString()).isEqualTo(expected);
	}

	@DisplayName("사용자가 구매한 로또 개수를 출력하는 기능 테스트")
	@Test
	void checkUserLottoCountPrintTest() {
		final int purchaseAmount = 3000;

		Printer.showUserPurchasedLottoCount(purchaseAmount);

		final String expected = (purchaseAmount / Constant.LOTTO_PRICE) + "개를 구매했습니다.\n";
		assertThat(outputStream.toString()).isEqualTo(expected);
	}

	@DisplayName("사용자가 구매한 로또 결과를 출력하는 기능 테스트")
	@Test
	void checkUserLotteriesResultTest() {
		// given : 사용자가 구매한 로또들의 결과가 5등 5번, 3등 2번, 2등 1번으로 주어질 때
		Map<Rank, Long> lotteriesCountingResult = new HashMap<>() {{
			put(Rank.FIFTH, 5L); // 5등 5번
			put(Rank.THIRD, 2L); // 3등 2번
			put(Rank.SECOND, 1L);// 2등 1번
		}};
		LottoResult lottoResult = new LottoResult(lotteriesCountingResult);

		// when : 사용자 로또들의 랭크 결과들을 출력한다.
		Printer.showLotteriesResult(lottoResult);

		// then : 의도한대로 출력이 잘 되었는지 확인
		final String expected = "3개 일치 (5,000원) - 5개\n" +
				"4개 일치 (50,000원) - 0개\n" +
				"5개 일치 (1,500,000원) - 2개\n" +
				"5개 일치, 보너스 볼 일치 (30,000,000원) - 1개\n" +
				"6개 일치 (2,000,000,000원) - 0개\n";
		assertThat(outputStream.toString()).isEqualTo(expected);
	}
}