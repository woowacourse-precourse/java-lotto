package lotto.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class LottoFactoryTest {

	@DisplayName("로또 번호 6개를 발급했을 때 모두 중복이 안된다면 테스트 성공. 실패 시 로또 번호 길이가 6이 아닌 것")
	@Test
	void checkValidLengthLottoNumberTest() {
		// given : 로또번호를 생성하는 로또공장 인스턴스가 주어졌을 때
		LottoFactory factory = new LottoFactory();

		// when : 로또 공장에서 중복이 없는 6개의 숫자를 생성할 때
		List<Integer> uniqueLottoNumber = factory.createUniqueLottoNumber();
		Set<Integer> result = new HashSet<>(uniqueLottoNumber);

		// then : 중복없이 6개의 숫자를 생성했기에 정상적으로 Lotto 번호가 만들어진다.
		final int NON_DUPLICATED_LOTTO_LENGTH = 6;
		assertThat(result.size()).isEqualTo(NON_DUPLICATED_LOTTO_LENGTH);
	}
}