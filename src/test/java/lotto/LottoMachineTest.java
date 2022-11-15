package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoMachine;


public class LottoMachineTest {

	@DisplayName("issueLottoNumber는 랜덤한 6개의 로또 번호를 생성한다")
	@Test
	void issueLottoNumber() {
		List<Integer> results = LottoMachine.issueLottoNumber();
		assertThat(results).hasSize(6);
	}
}
