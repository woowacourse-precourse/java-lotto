package lotto.model;

import lotto.enums.Rank;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

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
	void 작은_사이즈_예외_테스트(){
		Assertions.assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 5, 6), 7))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 큰_사이즈_예외_테스트(){
		Assertions.assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 보너스_중복_숫자_예외_테스트(){
		Assertions.assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 6), 6))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 정답번호_중복_숫자_예외_테스트(){
		Assertions.assertThatThrownBy(() -> new AnswerLotto(List.of(1, 2, 3, 4, 5, 3), 6))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("getRank 함수 단위 테스트")
	@Nested
	class getRankTest{
		@DisplayName("일반숫자 6개가 맞는 경우 getRank 함수는 1을 리턴해야 한다.")
		@Test
		void getRankFirstTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(1,2,3,4,5,6))))
					.isEqualTo(Rank.FIRST.getRank());
		}

		@DisplayName("일반숫자 5개와 보너스가 맞는 경우 getRank 함수는 1을 리턴해야 한다.")
		@Test
		void getRankFirstBonusTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(1,2,3,4,5,7))))
					.isEqualTo(Rank.FIRST.getRank());
		}

		@DisplayName("일반숫자 4개와 보너스가 맞는 경우 getRank 함수는 2를 리턴해야 한다.")
		@Test
		void getRankSecondTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(1,2,3,4,7,10))))
					.isEqualTo(Rank.SECOND.getRank());
		}

		@DisplayName("일반숫자 5개가 맞는 경우 getRank 함수는 3을 리턴해야 한다.")
		@Test
		void getRankThirdTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(1,2,3,4,5,10))))
					.isEqualTo(Rank.THIRD.getRank());
		}

		@DisplayName("일반숫자 4개가 맞는 경우 getRank 함수는 4를 리턴해야 한다.")
		@Test
		void getRankFourthTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(1,2,3,4,9,10))))
					.isEqualTo(Rank.FORTH.getRank());
		}

		@DisplayName("일반숫자 3개가 맞는 경우 getRank 함수는 5를 리턴해야 한다.")
		@Test
		void getRankFifthTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(1,2,3,9,10,11))))
					.isEqualTo(Rank.FIFTH.getRank());
		}

		@DisplayName("일반숫자 2개와 보너스가 맞는 경우 getRank 함수는 5를 리턴해야 한다.")
		@Test
		void getRankFifthBonusTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(1,2,7,9,10,11))))
					.isEqualTo(Rank.FIFTH.getRank());
		}

		@DisplayName("일반숫자 2개가 맞는 경우 getRank 함수는 6을 리턴해야 한다.")
		@Test
		void getRankSixth2MatchTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(1,2,8,9,10,11))))
					.isEqualTo(Rank.SIXTH.getRank());
		}

		@DisplayName("일반숫자 1개가 맞는 경우 getRank 함수는 6을 리턴해야 한다.")
		@Test
		void getRankSixth1MatchTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(1,8,9,10,11,12))))
					.isEqualTo(Rank.SIXTH.getRank());
		}

		@DisplayName("일반숫자 0개가 맞는 경우 getRank 함수는 6을 리턴해야 한다.")
		@Test
		void getRankSixth0MatchTest(){
			AnswerLotto answerLotto = new AnswerLotto(List.of(1,2,3,4,5,6), 7);

			Assertions.assertThat(answerLotto.getRank(new Lotto(List.of(8,9,10,11,12, 13))))
					.isEqualTo(Rank.SIXTH.getRank());
		}
	}

}