package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRandomNumberGeneratorTest {

	@Test
	@DisplayName("중복없는 6개의 난수만들기 테스트")
	void randomUniqueNumbersGenerateTest() {
		// given
		LottoRandomNumberGenerator randomGenerator = new LottoRandomNumberGenerator();
		// when
		for(int testCase=0; testCase<10000; testCase++) {
			//then
			assertDoesNotThrow(() -> randomGenerator.randomUniqueNumbersGenerate());
		}
	}

}