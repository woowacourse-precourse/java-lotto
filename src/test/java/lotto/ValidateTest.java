package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class ValidateTest {

	@Test
	void 로또_번호_갯수_검열(){
		assertThat(Validate.isInValidSize(List.of(1,2,3,4,5,6,7))).isEqualTo(true);
		assertThat(Validate.isInValidSize(List.of(1,2,3))).isEqualTo(true);
		assertThat(Validate.isInValidSize(List.of(1,2,3,4,5,6))).isEqualTo(false); // 올바른 입력
	}

	@Test
	void 로또_번호_중복_검열(){
		assertThat(Validate.isDuplicated(List.of(1,1,2,3,4,5))).isEqualTo(true);
		assertThat(Validate.isDuplicated(List.of(1,6,2,3,4,5))).isEqualTo(false); // 올바른 입력
	}

	@Test
	void 로또_번호_숫자_범위_검열(){
		assertThat(Validate.isOutOfRange(List.of(0,1,2,3,4,5))).isEqualTo(true);
		assertThat(Validate.isOutOfRange(List.of(46,1,2,3,4,5))).isEqualTo(true);
		assertThat(Validate.isOutOfRange(List.of(1,2,3,4,5,45))).isEqualTo(false);
	}
}
