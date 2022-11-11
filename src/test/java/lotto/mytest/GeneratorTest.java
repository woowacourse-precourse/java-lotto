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
		HashSet<Integer> randomLottoNumber = generator.lottery();
		assertEquals(6, randomLottoNumber.size());
	}

	@DisplayName("6개 번호 정렬 확인")
	@Test
	void sortSixNumber() {
		HashSet<Integer> randomLottoNumber = generator.lottery();
		List<Integer> sortedLottoNumber = generator.sortNumber(randomLottoNumber);
		for (int i = 0; i < sortedLottoNumber.size() - 1; i++) {
			assertTrue(sortedLottoNumber.get(i) < sortedLottoNumber.get(i + 1));
		}
	}
}
