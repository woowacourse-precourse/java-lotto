package lotto.view;

import java.util.List;

public class OutputView {
	public static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
	public static final String PURCHASE_NOTIFICATION = "개를 구매했습니다.";
	public static final String WIN_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
	public static final String BONUS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
	public static final String WIN_COUNT = "개";

	public static void printLotto(List<List<Integer>> lottoGames) {
		for (List<Integer> lottoGame : lottoGames) {
			System.out.println(lottoGame);
		}
	}
}