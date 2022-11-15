package view;

import model.Lotto;

public class LottoOutputView {

	public void showLotto(Lotto lotto) {
		System.out.println(lotto.getNumbers());
	}
	
	public void showLottoCount(long totalLottoCount) {
		System.out.println("\n" + totalLottoCount + "개를 구매했습니다.");
	}
}