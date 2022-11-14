package lotto;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {
	private final List<Lotto> userLottoes = new ArrayList<>();

	public UserLotto(Integer lottoCount) {
		Numbers numbers = new Numbers();
		for (int i = 0; i < lottoCount; i++) {
			List<Integer> lottoNumbers = numbers.generateLottoNumbers();
			userLottoes.add(new Lotto(lottoNumbers));
		}
	}

	public List<Lotto> getUserLottoes() {
		return this.userLottoes;
	}
}
