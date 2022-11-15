package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

	@DisplayName("구입 금액만큼 로또를 발행할 수 있다.")
	@Test
	void publish_구입_금액만큼_로또를_발행할_수_있다() {
		List<Lotto> tickets = LottoGenerator.publish(8);
		assertThat(tickets.size()).isEqualTo(8);
	}
}
