package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class LottoProgramTest {

	LottoProgram lottoProgram = new LottoProgram();

	@Test
	public void checkBonus_테스트_성공() {
		List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
		lottoProgram.bonusNum = 6;
		assertThat(lottoProgram.checkBonus(lottoNumbers)).isEqualTo(true);
	}

	@Test
	public void checkBonus_테스트_실패() {
		List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
		lottoProgram.bonusNum = 7;
		assertThat(lottoProgram.checkBonus(lottoNumbers)).isEqualTo(false);
	}

	@Test
	public void checkCount() {
		List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
		List<Integer> randomNumbers = new ArrayList<>(List.of(3, 5, 6, 7, 8, 9));
		assertThat(lottoProgram.checkWinNum(randomNumbers, lottoNumbers)).isEqualTo(3);
	}

	@Test
	public void 수익률_계산() {
		StoreMap storeMap = new StoreMap();
		storeMap.pushStoreMap(Rank.FIFTH);
		storeMap.pushStoreMap(Rank.MISS);
		storeMap.pushStoreMap(Rank.MISS);
		storeMap.pushStoreMap(Rank.MISS);
		storeMap.pushStoreMap(Rank.MISS);
		storeMap.pushStoreMap(Rank.MISS);
		storeMap.pushStoreMap(Rank.MISS);
		storeMap.pushStoreMap(Rank.MISS);  //8장을 사고 1개 당첨 7개 낙첨
		int totalCount = 0;
		int totalPrize = 0;
		for (SortedMap.Entry<Rank, Integer> elem : storeMap.getStoreMap().entrySet()) {
			totalCount += elem.getValue() * 1000;
			totalPrize += (elem.getValue() * elem.getKey().getWinningMoney());
		}
		double total = (double)totalPrize / totalCount * 100;
		assertThat(total).isEqualTo(62.5);
	}
}
