package lotto.filter;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserInputFilterTest {

	private final UserInputFilter filter = new UserInputFilter();

	@Test
	@DisplayName("정수범위의 양수가 아닌 사용자 입력시 예외 발생")
	void changeStringToIntegerTest() {
		long integer1 = filter.changeStringToLong("1234");
		long integer2 = filter.changeStringToLong("0");
		long integer3 = filter.changeStringToLong("2147483647");

		Assertions.assertThat(integer1).isEqualTo(1234);
		Assertions.assertThat(integer2).isEqualTo(0);
		Assertions.assertThat(integer3).isEqualTo(2147483647);

		assertThatThrownBy(() -> filter.changeStringToLong("12a1"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> filter.changeStringToLong("aaa"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> filter.changeStringToLong("12 34"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> filter.changeStringToLong("-123"))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> filter.changeStringToLong("-123"))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
