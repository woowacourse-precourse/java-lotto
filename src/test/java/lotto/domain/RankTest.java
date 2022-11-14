package lotto.domain;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.util.RankConst;

class RankTest {

	private static Stream<Arguments> rankPriceProvideForResult() {
		return Stream.of(
			Arguments.of(2_000_000_000, Rank.firstRank),
			Arguments.of(30_000_000, Rank.secondRank),
			Arguments.of(1_500_000, Rank.thirdRank),
			Arguments.of(50_000, Rank.forthRank),
			Arguments.of(5_000, Rank.fifthRank)
		);
	}

	private static Stream<Arguments> rankDescriptionProvideForResult() {
		return Stream.of(
			Arguments.of(RankConst.FIRST_RANK_RESULT, Rank.firstRank),
			Arguments.of(RankConst.SECOND_RANK_RESULT, Rank.secondRank),
			Arguments.of(RankConst.THIRD_RANK_RESULT, Rank.thirdRank),
			Arguments.of(RankConst.FORTH_RANK_RESULT, Rank.forthRank),
			Arguments.of(RankConst.FIFTH_RANK_RESULT, Rank.fifthRank)
		);
	}

	@ParameterizedTest(name = "Rank 별 price 확인 테스트")
	@MethodSource("rankPriceProvideForResult")
	public void getPriceTest(int price, Rank rank) {
		//given
		Integer priceTest = rank.getPrice();

		//then
		Assertions.assertThat(price).isEqualTo(priceTest);
	}

	@ParameterizedTest(name = "Rank 별 rankCountDescription 확인 테스트")
	@MethodSource("rankDescriptionProvideForResult")
	public void getRankCountDescriptionTest(String rankCountDescription, Rank rank) {
		//given
		String rankCountDescriptionTest = rank.getRankCountDescription();

		//then
		Assertions.assertThat(rankCountDescription).isEqualTo(rankCountDescriptionTest);
	}

}
