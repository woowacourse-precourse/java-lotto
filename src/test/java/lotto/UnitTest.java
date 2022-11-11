package lotto;

import jdk.jshell.execution.Util;
import lotto.model.LottoNumsValidator;
import lotto.model.NumberValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class UnitTest { // TODO : 클래스 이름 변경

//	@Test
//	void 랜덤_숫자_추출_테스트(){
//		int randomNum = Util.getRandomNum(1, 45);
//		assertThat(randomNum)
//				.isGreaterThanOrEqualTo(1)
//				.isLessThanOrEqualTo(45);
//	}
//
//	@Test
//	void 로또_발행_테스트(){
//		List<Integer> randomNums = Util.getDistinctRandomNums(6);
//		List<Integer> filtered = randomNums.stream()
//				.distinct()
//				.collect(Collectors.toList());
//		assertThat(filtered.size()).isEqualTo(6);
//	}

	@DisplayName("당첨 번호 입력 테스트")
	@Nested
	class AnswerNumTest{
		@Test
		void 당첨_번호_입력_테스트_정상_케이스(){
			assertThatCode(() -> new LottoNumsValidator("1,2,3,4,5,6").isValidate())
					.doesNotThrowAnyException();
		}

		@Test
		void 당첨_번호_입력_테스트_예외_케이스1(){
			assertThatThrownBy(() -> new LottoNumsValidator("1 2 3 4 5 6").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		void 당첨_번호_입력_테스트_예외_케이스2(){
			assertThatThrownBy(() -> new LottoNumsValidator("what the hell").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}



		@Test
		void 당첨_번호_입력_테스트_예외_케이스3(){
			assertThatThrownBy(() -> new LottoNumsValidator("").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@DisplayName("로또 구입 금액 테스트")
	@Nested
	class LottoBuyTest{
		@Test
		void 로또_구입_금액_옳은_케이스_테스트1(){
			assertThatCode(() -> new NumberValidator("14000").isValidate())
					.doesNotThrowAnyException();
		}

		@Test
		void 로또_구입_금액_옳은_케이스_테스트2(){
			assertThatCode(() -> new NumberValidator("2147484000").isValidate())
					.doesNotThrowAnyException();
		}

//		@Test
//		void 로또_구입_금액_예외_케이스_테스트1(){
//			assertThatThrownBy(() -> new NumberValidator("100").isValidate())
//					.isInstanceOf(IllegalArgumentException.class);
//		}

		@Test
		void 로또_구입_금액_예외_케이스_테스트2(){
			assertThatThrownBy(() -> new NumberValidator("").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}
	}
}
