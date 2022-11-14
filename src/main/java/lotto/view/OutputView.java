package lotto.view;

public class OutputView {
	private static final String OUTPUT_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

	public void printLottoCount(int lottoCount) {
		System.out.println(lottoCount + OUTPUT_LOTTO_COUNT_MESSAGE);
	}
}
