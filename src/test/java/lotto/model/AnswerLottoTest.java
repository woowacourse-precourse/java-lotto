package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnswerLottoTest {
	@Test
	void 정상_테스트1(){
		assertDoesNotThrow(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 7));
	}

	@Test
	void 정상_테스트2(){
		assertDoesNotThrow(() -> new AnswerLotto(List.of(45, 44, 43, 42, 31, 41), 40));
	}

	@Test
	void 사이즈_예외_테스트1(){
		Assertions.assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 5, 6), 7))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 사이즈_예외_테스트2(){
		Assertions.assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 중복_숫자_예외_테스트1(){
		Assertions.assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 6))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 중복_숫자_예외_테스트2(){
		Assertions.assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 3), 6))
				.isInstanceOf(IllegalArgumentException.class);
	}
}