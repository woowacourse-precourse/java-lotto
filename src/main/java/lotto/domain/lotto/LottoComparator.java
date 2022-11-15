package lotto.domain.lotto;

import java.util.List;
import lotto.domain.machine.LottoMachine;

public class LottoComparator {

	LottoMachine lottoMachine;

	public LottoComparator(LottoMachine lottoMachine) {
		this.lottoMachine = lottoMachine;
	}


	public boolean hasBonusNumber(Lotto lotto) {
		List<Integer> numbers = lotto.getNumbers();
		Integer bonusNumber = Integer.parseInt(lottoMachine.getBonusNumber());
		if (numbers.contains(bonusNumber)) {
			return true;
		}
		return false;
	}


}
