package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class GenerateNumbersTest {
	private GenerateNumbers generateNumbers;
	
	@BeforeAll
	void setUp() {
		generateNumbers = new GenerateNumbers();
	}
	
	@Test
	void test1() {
		int result = generateNumbers.purchaseCount("8000");
		assertThat(result).isEqualTo(8);
	}
	
	@Test
	void test2() {
		int result = generateNumbers.purchaseCount("5000");
		assertThat(result).isEqualTo(5);
	}

}
