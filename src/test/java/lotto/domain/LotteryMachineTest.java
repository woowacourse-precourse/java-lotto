package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LotteryMachineTest {

	@Nested
	class Of {

		@Test
		@DisplayName("로또 번호 개수가 6개 초과인 경우, IllegalArgumentException 발생")
		void case1() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);

			// when
			final ThrowingCallable throwingCallable = () -> LotteryMachine.of(numbers);

			// then
			assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		@DisplayName("로또 번호가 1 이상 45 이하에 속하지 않는 경우, IllegalArgumentException 발생")
		void case2() throws Exception {
			// given
			final List<Integer> numbers = List.of(0, 2, 46, 4, 5, 6);

			// when
			final ThrowingCallable throwingCallable = () -> LotteryMachine.of(numbers);

			// then
			assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		@DisplayName("로또 번호가 중복되는 경우, IllegalArgumentException 발생")
		void case3() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 1, 3, 4, 5, 6);

			// when
			final ThrowingCallable throwingCallable = () -> LotteryMachine.of(numbers);

			// then
			assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		@DisplayName("정상적인 로또 번호인 경우 LotteryMachine 객체 반환")
		void case4() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

			// when
			final LotteryMachine machine = LotteryMachine.of(numbers);

			// then
			assertThat(machine.getClass()).isEqualTo(LotteryMachine.class);
		}

	}

	@Nested
	class CheckResult {

		@Test
		@DisplayName("로또 복권이 주어지면 Lottery 객체 반환")
		void case1() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
			final Lotto lotto = new Lotto(numbers);
			final LotteryMachine machine = LotteryMachine.of(numbers);
			final int bonusNumber = 7;
			machine.setBonusNumber(bonusNumber);

			// when
			final Lottery result = machine.checkResult(lotto);

			// then
			assertThat(result.getClass()).isEqualTo(Lottery.class);
		}

	}

	@Nested
	class SetBonusNumber {

		@Test
		@DisplayName("보너스 번호가 1 이상 45 이하에 속하지 않는 경우, IllegalArgumentException 발생")
		void case1() throws Exception {
			// given
			final LotteryMachine machine = LotteryMachine.of(List.of(1, 2, 3, 4, 5, 6));
			final int bonusNumber = 46;

			// when
			final ThrowingCallable throwingCallable = () -> machine.setBonusNumber(bonusNumber);

			// then
			assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		@DisplayName("보너스 번호가 중복되는 경우, IllegalArgumentException 발생")
		void case2() throws Exception {
			// given
			final LotteryMachine machine = LotteryMachine.of(List.of(1, 2, 3, 4, 5, 6));
			final int bonusNumber = 2;

			// when
			final ThrowingCallable throwingCallable = () -> machine.setBonusNumber(bonusNumber);

			// then
			assertThatThrownBy(throwingCallable).isInstanceOf(IllegalArgumentException.class);
		}

		@Test
		@DisplayName("정상적인 보너스 번호가 주어지는 경우, 로또 기계에 보너스 번호가 설정된다.")
		void case3() throws Exception {
			// given
			final LotteryMachine machine = LotteryMachine.of(List.of(1, 2, 3, 4, 5, 6));
			final int bonusNumber = 7;

			// when
			machine.setBonusNumber(bonusNumber);

			// then
			assertThat(machine.getBonusNumber()).isEqualTo(bonusNumber);
		}

	}

}