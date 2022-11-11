package lotto.mytest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Generator;

public class GeneratorTest {
	Generator generator = new Generator();
	@DisplayName("로또 번호 6개 생성")
	@Test
	void hasSixNumber() {
		assertEquals(generator.createLottery().size(), 6);
	}

	@DisplayName("6개 번호 정렬 확인")
	@Test
	void sortSixNumber() {
		List<Integer> lotto = generator.createLottery();
		for (int i = 0; i < lotto.size() - 1; i++) {
			assertTrue(lotto.get(i) < lotto.get(i + 1));
		}
	}
}
