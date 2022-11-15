package lotto.core;

import lotto.models.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LottoMachineBuilderTest {

	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	public static InputStream generateInputStream(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}

	@BeforeEach
	void setUpStream() {
		System.setOut(new PrintStream(outputStream));
	}

	@AfterEach
	void restoreStream() {
		System.setOut(System.out);
		outputStream.reset();
	}

	@DisplayName("로또 기계 통합 테스트")
	@Test
	void lottoMachineBuilderTest() {
		/*
		===== given =====
		lottoFactory Mock 객체 주어짐 => 4000원을 넣으면 아래와 같은 로또 번호 생성. 테스트 난수 생성 역할
		lottoMachineBuilder => 통합 테스트하려는 객체
		purchaseAmount : 사용자가 구매할 로또 금액 입력
		winningLottoNumber : 당첨로또 번호 입력
		winningLottoBonusNumber : 당첨로또 보너스 번호 입력
		 */
		final LottoFactory lottoFactory = mock(LottoFactory.class);
		when(lottoFactory.issueLottoNumbersByPurchaseAmount(4000)).thenReturn(List.of(
				new Lotto(List.of(11, 12, 3, 4, 5, 6)),
				new Lotto(List.of(4, 12, 33, 45, 25, 36)),
				new Lotto(List.of(5, 31, 27, 1, 9, 11)),
				new Lotto(List.of(7, 8, 30, 10, 15, 45))
		));

		LottoMachineBuilder lottoMachineBuilder = new LottoMachineBuilder();

		final String purchaseAmount = "4000";
		final String winningLottoNumber = "1,2,3,4,5,6";
		final String winningLottoBonusNumber = "7";
		generateTestInput(purchaseAmount, winningLottoNumber, winningLottoBonusNumber);

		// when : 통합 테스트
		lottoMachineBuilder.init(lottoFactory)
				.purchaseLotteries()
				.setWinningLotto()
				.showResult();

		// then
		assertThat(outputStream.toString()).contains("구입금액을 입력해 주세요")
				.contains("4개를 구매했습니다")
				.contains("[11, 12, 3, 4, 5, 6]\n" +
						"[4, 12, 33, 45, 25, 36]\n" +
						"[5, 31, 27, 1, 9, 11]\n" +
						"[7, 8, 30, 10, 15, 45]")
				.contains("당첨 통계\n" +
						"---\n" +
						"3개 일치 (5,000원) - 0개\n" +
						"4개 일치 (50,000원) - 1개\n" +
						"5개 일치 (1,500,000원) - 0개\n" +
						"5개 일치, 보너스 볼 일치 (30,000,000원) - 0개\n" +
						"6개 일치 (2,000,000,000원) - 0개\n" +
						"총 수익률은 1250.0%입니다.\n");
	}

	private static void generateTestInput(String... inputs) {
		StringBuilder inputBuilder = new StringBuilder();
		for (String input : inputs) {
			inputBuilder.append(input).append("\n");
		}
		inputBuilder.deleteCharAt(inputBuilder.length() - 1);

		InputStream inputStream = generateInputStream(inputBuilder.toString());
		System.setIn(inputStream);
	}
}