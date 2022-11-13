package lotto.controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

	@Test
	@DisplayName("발행할 수 있는 수량만큼 로또를 발행한다.")
	void issueLotteries() {
		LottoController lottoController = new LottoController();
		System.setIn(new ByteArrayInputStream("43000".getBytes()));
		lottoController.control();
		assertThat(lottoController.getLotteries()).hasSize(43);
	}
}