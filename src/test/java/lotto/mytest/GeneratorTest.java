package lotto.mytest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Generator;

public class GeneratorTest {
	@DisplayName("로또 번호 6개 생성")
	@Test
	void hasSixNumber() {
		Generator generator = new Generator();
		HashSet<Integer> randomLottoNumber = generator.lottery();
		assertEquals(6, randomLottoNumber.size());
	}
}
