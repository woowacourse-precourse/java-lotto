package lotto.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class LottoTicketsTest {

	@Test
	void 정확한_입력_값을_줬을때_확인() {
		LottoTickets lottoTickets = new LottoTickets("8000");
		assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(8);

		lottoTickets = new LottoTickets("0");
		assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(0);
	}

	@Test
	void 돈이_1000원_단위가_아닐때() {
		assertThatThrownBy(() -> new LottoTickets("1100"))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> new LottoTickets("1001"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 돈이_음수일_때() {
		assertThatThrownBy(() -> new LottoTickets("-1000"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 숫자_외의_다른_문자가_들어왔을_때() {
		assertThatThrownBy(() -> new LottoTickets("a1000"))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> new LottoTickets("1000a"))
			.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> new LottoTickets("10a0a0"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}