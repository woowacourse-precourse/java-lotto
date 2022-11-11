package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GradeTest {
	@Test
	@DisplayName("1등일때 FIRST를 반환한다.")
	void findGradeTest1() {
		int winningNumberCount = 6;
		boolean hasBonusNumber = false;
		Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
		Grade result = Grade.FIRST;

		assertThat(grade).isEqualTo(result);
	}

	@Test
	@DisplayName("2등일때 SECOND를 반환한다.")
	void findGradeTest2() {
		int winningNumberCount = 5;
		boolean hasBonusNumber = true;
		Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
		Grade result = Grade.SECOND;

		assertThat(grade).isEqualTo(result);
	}

	@Test
	@DisplayName("3등일때 THIRD를 반환한다.")
	void findGradeTest3() {
		int winningNumberCount = 5;
		boolean hasBonusNumber = false;
		Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
		Grade result = Grade.THIRD;

		assertThat(grade).isEqualTo(result);
	}

	@Test
	@DisplayName("4등일때(보너스 당첨번호 있을때) FORTH를 반환한다.")
	void findGradeTest4() {
		int winningNumberCount = 4;
		boolean hasBonusNumber = true;
		Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
		Grade result = Grade.FORTH;

		assertThat(grade).isEqualTo(result);
	}

	@Test
	@DisplayName("5등일때 FIFTH를 반환한다.")
	void findGradeTest5() {
		int winningNumberCount = 3;
		boolean hasBonusNumber = false;
		Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
		Grade result = Grade.FIFTH;

		assertThat(grade).isEqualTo(result);
	}

	@Test
	@DisplayName("아무것도 당첨되지 않았을때 DEFAULT를 반환한다.")
	void findGradeTest6() {
		int winningNumberCount = 2;
		boolean hasBonusNumber = false;
		Grade grade = Grade.findGrade(winningNumberCount, hasBonusNumber);
		Grade result = Grade.DEFAULT;

		assertThat(grade).isEqualTo(result);
	}
}
