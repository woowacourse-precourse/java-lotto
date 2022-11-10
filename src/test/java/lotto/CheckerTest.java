package lotto;

import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import camp.nextstep.edu.missionutils.test.NsTest;

public class CheckerTest extends NsTest {

	@Test
	void checkNumberOnlyException_메서드로_숫자외의_입력_예외처리() {

		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("ㅁ"))
				.isInstanceOf(IllegalArgumentException.class)
		);

	}

	@Test
	void checkMaxPrice_메서드로_10만원이상_구매시_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("1000000"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void checkSameNumberException_메서드로_중복된_숫자_입력시_예외처리() {

		boolean isSameNumberExist = List.of(1,2,3,4,4,4).stream()
			.distinct()
			.count() != List.of(1,2,3,4,4,4).size();

		assertThat(isSameNumberExist).isTrue();
	}

	@Test
	void checkLength_메서드로_당첨_번호_6자리_이상이면_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("5000","1,2,3,4,5,6,7"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	void checkNumberRangeException_메서드로_당첨_번호_범위_넘어가면_예외처리() {
		assertSimpleTest(() ->
			assertThatThrownBy(() -> runException("5000","1,2,3,4,5,99"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
