package lotto;

import lotto.model.InputNumListValidator;
import lotto.model.InputNumValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputTest { // TODO : 클래스 이름 변경

	@DisplayName("당첨 번호 입력 테스트")
	@Nested
	class AnswerNumTest{
		@Test
		void 당첨_번호_입력_테스트_정상_케이스(){
			assertThatCode(() -> new InputNumListValidator("1,2,3,4,5,6").isValidate())
					.doesNotThrowAnyException();
		}

		@Test
		void 당첨_번호_입력_테스트_예외_케이스_쉼표가_아닌_경우(){
			assertThatThrownBy(() -> new InputNumListValidator("1 2 3 4 5 6").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		void 당첨_번호_입력_테스트_예외_케이스_숫자가_아닌_경우(){
			assertThatThrownBy(() -> new InputNumListValidator("what the hell").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}



		@Test
		void 당첨_번호_입력_테스트_예외_케이스3(){
			assertThatThrownBy(() -> new InputNumListValidator("").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@DisplayName("보너스 번호 입력 테스트")
	@Nested
	class BonusTest{
		@Test
		void 옳은_케이스_테스트(){
			assertThatCode(() -> new InputNumValidator("24"))
					.doesNotThrowAnyException();
		}

		@Test
		void 예외_케이스_테스트_빈문자열(){
			assertThatThrownBy(() -> new InputNumValidator("").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		void 예외_케이스_테스트_숫자가_아닌_경우(){
			assertThatThrownBy(() -> new InputNumValidator("this").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@DisplayName("로또 구입 금액 입력 테스트")
	@Nested
	class LottoBuyTest{
		@Test
		void 로또_구입_금액_옳은_케이스_테스트1(){
			assertThatCode(() -> new InputNumValidator("14000").isValidate())
					.doesNotThrowAnyException();
		}

		@Test
		void 로또_구입_금액_옳은_케이스_테스트2(){
			assertThatCode(() -> new InputNumValidator("2147484000").isValidate())
					.doesNotThrowAnyException();
		}

		@Test
		void 로또_구입_금액_예외_케이스_테스트_빈문자열(){
			assertThatThrownBy(() -> new InputNumValidator("").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		void 로또_구입_금액_예외_케이스_테스트_숫자가_아닌_경우(){
			assertThatThrownBy(() -> new InputNumValidator("this").isValidate())
					.isInstanceOf(IllegalArgumentException.class);
		}
	}
}
