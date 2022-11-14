package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

	@Test
	@DisplayName("로또 결과가 잘 생기는지 확인")
	void createLottoResult() {
		List<LottoRanking> lottoRank = new ArrayList<>();
		lottoRank.add(LottoRanking.findLottoRank(5, true));
		lottoRank.add(LottoRanking.findLottoRank(5, true));
		lottoRank.add(LottoRanking.findLottoRank(5, false));
		lottoRank.add(LottoRanking.findLottoRank(6, false));
		lottoRank.add(LottoRanking.findLottoRank(3, false));

		LottoResult lottoResult = new LottoResult(lottoRank);
		Map<LottoRanking, Integer> expect = new EnumMap<>(LottoRanking.class) {{
			put(LottoRanking.findLottoRank(3, false), 1);
			put(LottoRanking.findLottoRank(6, false), 1);
			put(LottoRanking.findLottoRank(5, true), 2);
			put(LottoRanking.findLottoRank(4, false), 0);
			put(LottoRanking.findLottoRank(5, false), 1);
			put(LottoRanking.findLottoRank(2, false), 0);
		}};

		assertEquals(expect, lottoResult.getLottoResult());
	}
}
