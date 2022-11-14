package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StoreMapTest {

	StoreMap storeMap = new StoreMap();

	@Test
	public void pushStatisticTest(){
		int before = storeMap.getStoreMap().get(Rank.FIRST);
		storeMap.pushStoreMap(Rank.FIRST);
		int after = storeMap.getStoreMap().get(Rank.FIRST);

		assertThat(after-before).isEqualTo(1);
	}
}
