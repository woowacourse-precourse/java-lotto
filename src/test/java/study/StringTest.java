package study;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {
	@DisplayName("1,2를 ,로 split했을 때 1과 2로 잘 분리되는지 확인")
	@Test
	void splitTest() {
		String[] splitString = {"1", "2"};
		assertThat("1,2".split(",")).containsExactly(splitString);
	}

	@DisplayName("1을 ,로 split했을 때 1만 반환되는지 확인")
	@Test
	void oneSplitTest() {
		String[] splitString = {"1"};
		assertThat("1".split(",")).contains(splitString);
	}

	@DisplayName("(1,2) 값을 substring 메소드를 이용하여 1,2만 반환하기")
	@Test
	void substringTest() {
		String inputResult = "1,2";
		String input = "(1,2)";
		assertThat(inputResult).isEqualTo(input.substring(1, input.length() - 1));
	}

	@DisplayName("charAt 메소드를 이용하여 특정 위치 문자를 가져오는 학습")
	@Test
	void charAtTest() {
		String input = "abc";
		assertAll(
			() -> assertThat(input.charAt(0)).isEqualTo('a'),
			() -> assertThat(input.charAt(1)).isEqualTo('b'),
			() -> assertThatThrownBy(() -> input.charAt(3))
				.isInstanceOf(StringIndexOutOfBoundsException.class)
		);
	}
}
