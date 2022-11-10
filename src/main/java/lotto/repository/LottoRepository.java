package lotto.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.handler.CheckHandler;

public class LottoRepository {

	private static final LottoRepository instance = new LottoRepository();

	private LottoRepository() {
	}

	public static LottoRepository getInstance() {
		return instance;
	}

	public Lotto makeAutoLotto() {
		List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
		Collections.sort(lotto);
		return new Lotto(lotto);
	}

	public List<Integer> makeWinnerLotto(String inputLottoWinningNumber, String bonusNumber) {
		StringTokenizer st = new StringTokenizer(inputLottoWinningNumber, ",");
		Set<Integer> lottoNumber = new TreeSet<>();
		while (st.hasMoreTokens()) {
			int numbers = Integer.parseInt(st.nextToken());
			lottoNumber.add(numbers);
		}
		lottoNumber.add(Integer.parseInt(bonusNumber));
		CheckHandler.isNotLotto(lottoNumber);
		return new ArrayList<>(lottoNumber);
	}

}
