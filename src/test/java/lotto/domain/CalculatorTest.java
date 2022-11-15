package lotto.domain;

import static lotto.domain.Lottery.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import lotto.domain.Calculator.Result;

class CalculatorTest {

	@Nested
	class Calculate {

		@Test
		@DisplayName("6개 번호가 일치하면 1등")
		void case1() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
			final LotteryMachine machine = LotteryMachine.of(numbers);
			machine.setBonusNumber(7);
			final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
			final List<Lotto> tickets = List.of(lotto);
			final Lottery expected = FIRST_PLACE;

			// when
			final Result result = Calculator.calculate(machine, tickets);

			// then
			assertThat(result.getCounts().containsKey(expected)).isTrue();
		}

		@Test
		@DisplayName("5개 번호와 보너스 번호가 일치하면 2등")
		void case2() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
			final LotteryMachine machine = LotteryMachine.of(numbers);
			machine.setBonusNumber(7);
			final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
			final List<Lotto> tickets = List.of(lotto);
			final Lottery expected = SECOND_PLACE;

			// when
			final Result result = Calculator.calculate(machine, tickets);

			// then
			assertThat(result.getCounts().containsKey(expected)).isTrue();
		}

		@Test
		@DisplayName("5개 번호가 일치하면 3등")
		void case3() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
			final LotteryMachine machine = LotteryMachine.of(numbers);
			machine.setBonusNumber(7);
			final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
			final List<Lotto> tickets = List.of(lotto);
			final Lottery expected = THIRD_PLACE;

			// when
			final Result result = Calculator.calculate(machine, tickets);

			// then
			assertThat(result.getCounts().containsKey(expected)).isTrue();
		}

		@Test
		@DisplayName("4개 번호가 일치하면 4등")
		void case4() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
			final LotteryMachine machine = LotteryMachine.of(numbers);
			machine.setBonusNumber(7);
			final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 9, 8));
			final List<Lotto> tickets = List.of(lotto);
			final Lottery expected = FOURTH_PLACE;

			// when
			final Result result = Calculator.calculate(machine, tickets);

			// then
			assertThat(result.getCounts().containsKey(expected)).isTrue();
		}

		@Test
		@DisplayName("3개 번호가 일치하면 5등")
		void case5() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
			final LotteryMachine machine = LotteryMachine.of(numbers);
			machine.setBonusNumber(7);
			final Lotto lotto = new Lotto(List.of(1, 2, 10, 4, 9, 8));
			final List<Lotto> tickets = List.of(lotto);
			final Lottery expected = FOURTH_PLACE;

			// when
			final Result result = Calculator.calculate(machine, tickets);

			// then
			assertThat(result.getCounts().containsKey(expected)).isTrue();
		}

		@Test
		@DisplayName("2개 이하 번호가 일치하면 꽝")
		void case6() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
			final LotteryMachine machine = LotteryMachine.of(numbers);
			machine.setBonusNumber(7);
			final Lotto lotto = new Lotto(List.of(1, 22, 10, 4, 9, 8));
			final List<Lotto> tickets = List.of(lotto);
			final Lottery expected = BANG;

			// when
			final Result result = Calculator.calculate(machine, tickets);

			// then
			assertThat(result.getCounts().containsKey(expected)).isTrue();
		}

	}

	@Nested
	class GetRateOfReturn {

		@Test
		@DisplayName("복권 8개 구매해서 5등 1번 당첨된 경우 수익률은 62.5%")
		void case1() throws Exception {
			// given
			final List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
			final LotteryMachine machine = LotteryMachine.of(numbers);
			machine.setBonusNumber(7);
			final Lotto lotto = new Lotto(List.of(8, 21, 23, 41, 42, 43));
			final Lotto lotto2 = new Lotto(List.of(3, 5, 11, 16, 32, 38));
			final Lotto lotto3 = new Lotto(List.of(7, 11, 16, 35, 36, 44));
			final Lotto lotto4 = new Lotto(List.of(1, 8, 11, 31, 41, 42));
			final Lotto lotto5 = new Lotto(List.of(13, 14, 16, 38, 42, 45));
			final Lotto lotto6 = new Lotto(List.of(7, 11, 30, 40, 42, 43));
			final Lotto lotto7 = new Lotto(List.of(2, 13, 22, 32, 38, 45));
			final Lotto lotto8 = new Lotto(List.of(1, 3, 5, 14, 22, 45));
			final List<Lotto> tickets = List.of(lotto, lotto2, lotto3, lotto4, lotto5, lotto6, lotto7, lotto8);
			final Double expected = 62.5;

			// when
			final Result result = Calculator.calculate(machine, tickets);

			// then
			assertThat(result.getRateOfReturn()).isEqualTo(expected);
		}

	}

}