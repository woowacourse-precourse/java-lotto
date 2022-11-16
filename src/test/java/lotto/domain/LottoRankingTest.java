package lotto.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoRankingTest {

	@ParameterizedTest
	@CsvSource(value = {"2,true", "6,false", "5,true", "3,false", "4,false"})
	@DisplayName("")
	void lottoRankTest(int winCount, boolean matchBonus) {
		String prizeName = LottoRanking.findLottoRank(winCount, matchBonus).name();
		Map<Integer, String> prizeMap = new HashMap<>() {{
			put(2, "noWin");
			put(3, "winThree");
			put(4, "winFour");
			put(5, "winFiveBonus");
			put(6, "winSix");
		}};
		String expect = "";
		for (int i = 0; i < prizeMap.size(); i++) {
			expect = prizeMap.get(winCount);
			assertEquals(expect, prizeName);
		}
	}

}
