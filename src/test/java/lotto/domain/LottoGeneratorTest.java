package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

	@DisplayName("6개의 번호를 생성한다.")
	@Test
	void validateSixNumbers() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		assertThat(lottoGenerator.getLotto()).hasSize(6);
	}

	@DisplayName("번호가 중복이 아니다.")
	@Test
	void validateNoDuplication() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		assertThat(lottoGenerator.getLotto()).doesNotHaveDuplicates();
	}

	@DisplayName("오름차순으로 정렬되어 있다.")
	@Test
	void validateAscendingOrder() {
		LottoGenerator lottoGenerator = new LottoGenerator();
		assertThat(lottoGenerator.getLotto()).isSorted();
	}
}