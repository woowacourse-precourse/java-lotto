package controller;

import model.Lotto;
import model.LottoRandomNumberGenerator;
import view.OutputLotto;

public class LottoCreate {

	public void createLotto(long price) {
		long totalLottoCount = countTotalLotto(price);
		OutputLotto outputLotto = new OutputLotto();
		outputLotto.showLottoCount(totalLottoCount);
		
		for (int count = 0; count < totalLottoCount; count++) {
			Lotto lotto = new Lotto(new LottoRandomNumberGenerator().randomUniqueNumbersGenerate());
			outputLotto.showLotto(lotto);
		}
	}

	private long countTotalLotto(long price) {
		long totalCount = price / 1000L;
		return totalCount;
	}
}