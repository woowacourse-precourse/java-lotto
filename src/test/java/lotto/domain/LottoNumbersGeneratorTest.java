package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersGeneratorTest {

	@DisplayName("6개의 번호를 생성한다.")
	@Test
	void validateSixNumbers() {
		LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
		assertThat(lottoNumbersGenerator.getLottoNumbers()).hasSize(6);
	}

	@DisplayName("번호가 중복이 아니다.")
	@Test
	void validateNoDuplication() {
		LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
		assertThat(lottoNumbersGenerator.getLottoNumbers()).doesNotHaveDuplicates();
	}

	@DisplayName("오름차순으로 정렬되어 있다.")
	@Test
	void validateAscendingOrder() {
		LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator();
		assertThat(lottoNumbersGenerator.getLottoNumbers()).isSorted();
	}
}