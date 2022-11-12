package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {


	@Test
	void 금액만큼_로또발행(){
		int pay = 5000;
		Store store = new Store(pay);
		int count = store.count;
		assertEquals(count, pay/1000);
	}

}