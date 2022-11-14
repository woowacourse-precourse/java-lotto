package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.LottoMachine;
import lotto.utils.Notice;

public class LottoMachineTest {

	@DisplayName("보너스 번호가 1 ~ 45 범위를 벗어난 경우 예외가 발생한다.")
	@Test
	void createBonusByOverRange() {
		assertThatThrownBy(() -> new LottoMachine(List.of(1,2,3,4,5,6), 46))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Notice.ERROR.getNoticeMessage());
	}

	@DisplayName("보너스 번호가 로또 번호에 중복해서 있을 경우 예외가 발생한다.")
	@Test
	void createBonusByDuplication() {
		assertThatThrownBy(() -> new LottoMachine(List.of(1,2,3,4,5,6), 4))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(Notice.ERROR.getNoticeMessage());
	}

}
