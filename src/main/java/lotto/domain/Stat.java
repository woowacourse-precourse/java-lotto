package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stat {
	private Map<LottoType, Integer> stat = new HashMap<>();

	public Stat(List<LottoType> grade) {
		initStat();
		for (LottoType lottoType : grade) {
			putStat(lottoType);
		}
	}

	private void initStat() {
		for (LottoType lottoType : LottoType.values()) {
			stat.put(lottoType, 0);
		}
	}

	private void putStat(LottoType lottoType) {
		stat.put(lottoType, stat.get(lottoType) + 1);
	}

	public Map<LottoType, Integer> getStat() {
		return stat;
	}
}
