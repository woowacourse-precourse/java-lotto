package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Grade 클래스")
class GradeTest {
	@Nested
	@DisplayName("findGrade 메소드는")
	class Describe_findGarde {
		@Nested
		@DisplayName("만약 당첨번호 6개를 맞춘다면")
		class Context_winning_number_count_six {
			private final int winningNumberCount = 6;
			private final boolean hasBonusNumber = false;

			@Test
			@DisplayName("FIRST를 반환한다.")
			void it_returns_first() {
				Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
				Grade result = Grade.FIRST;

				assertThat(grade).isEqualTo(result);
			}
		}

		@Nested
		@DisplayName("만약 당첨번호 5개와 보너스 번호를 맞춘다면")
		class Context_winning_number_count_five_and_has_bonus_number {
			private final int winningNumberCount = 5;
			private final boolean hasBonusNumber = true;

			@Test
			@DisplayName("SECOND를 반환한다.")
			void it_returns_second() {
				Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
				Grade result = Grade.SECOND;

				assertThat(grade).isEqualTo(result);
			}
		}

		@Nested
		@DisplayName("만약 당첨번호 5개를 맞춘다면")
		class Context_winning_number_count_five {
			private final int winningNumberCount = 5;
			private final boolean hasBonusNumber = false;

			@Test
			@DisplayName("THIRD를 반환한다.")
			void it_returns_third() {
				Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
				Grade result = Grade.THIRD;

				assertThat(grade).isEqualTo(result);
			}
		}

		@Nested
		@DisplayName("만약 당첨번호 4개를 맞춘다면")
		class Context_winning_number_count_four {
			private final int winningNumberCount = 4;
			private final boolean hasBonusNumber = false;

			@Test
			@DisplayName("FORTH를 반환한다.")
			void it_returns_forth() {
				Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
				Grade result = Grade.FORTH;

				assertThat(grade).isEqualTo(result);
			}
		}

		@Nested
		@DisplayName("만약 당첨번호 3개를 맞춘다면")
		class Context_winning_number_count_three {
			private final int winningNumberCount = 3;
			private final boolean hasBonusNumber = false;

			@Test
			@DisplayName("FIFTH를 반환한다.")
			void it_returns_fifth() {
				Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
				Grade result = Grade.FIFTH;

				assertThat(grade).isEqualTo(result);
			}
		}

		@Nested
		@DisplayName("만약 당첨번호를 2개이하로 맞춘다면")
		class Context_winning_number_count_under_two {
			private final int winningNumberCount = 2;
			private final boolean hasBonusNumber = false;

			@Test
			@DisplayName("DEFAULT를 반환한다.")
			void it_returns_default() {
				Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
				Grade result = Grade.DEFAULT;

				assertThat(grade).isEqualTo(result);
			}
		}
	}
}
