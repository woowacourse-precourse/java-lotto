package lotto.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

	@Test
	void 금액만큼_로또발행(){
		int pay = 5000;
		Store store = new Store(pay);
		long count = store.count;
		assertEquals(count, pay/1000);
	}

	@Test
	void 금액만큼_로또발행2(){
		int pay = 21300000;
		Store store = new Store(pay);
		long count = store.count;
		assertEquals(count, pay/1000);
	}

}