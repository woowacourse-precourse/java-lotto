package lotto.domain.person;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PersonTest {
	Person person;

	@BeforeEach
	void setUp() {
		person = new Person("5000");
	}

	@DisplayName("로또 구매 5000원 입력시 5개 구매")
	@Test
	void buyLotto() {
		person.buyLotto();
		assertEquals(5,person.getLottos().size());
	}
}