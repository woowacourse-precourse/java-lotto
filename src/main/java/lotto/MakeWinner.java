package lotto;

import java.util.ArrayList;
import java.util.List;

public class MakeWinner {
	//List로 넣을까? 0에 몇개 맞춰야하는지, 1에 보너스 맞췄는지, 2에 value에 상금 이렇게?
	private static List<List<String>> winnerPrize;
	private static final String FIRST_PRIZE = "2,000,000,000";
	private static final String SECOND_PRIZE = "30,000,000";
	private static final String THIRD_PRIZE = "1,500,000";
	private static final String FOURTH_PRIZE = "50,000";
	private static final String FIFTH_PRIZE = "5,000";
	private static final String FIRST_MATCH_NUMBER ="6";
	private static final String SECOND_MATCH_NUMBER ="5";
	private static final String THIRD_MATCH_NUMBER ="5";
	private static final String FOURTH_MATCH_NUMBER ="4";
	private static final String FIFTH_MATCH_NUMBER ="3";
	private static final String MATCH_BONUS = "matchBonusNumber";
	private static final String NOT_MATCH_BONUS = "notMatchBonusNumber";


	private void initWinnerPrize() {
		winnerPrize = new ArrayList<>();

		winnerPrize.add(List.of(FIRST_MATCH_NUMBER, NOT_MATCH_BONUS, FIRST_PRIZE));
		winnerPrize.add(List.of(SECOND_MATCH_NUMBER, MATCH_BONUS, SECOND_PRIZE));
		winnerPrize.add(List.of(THIRD_MATCH_NUMBER, NOT_MATCH_BONUS, THIRD_PRIZE));
		winnerPrize.add(List.of(FOURTH_MATCH_NUMBER, NOT_MATCH_BONUS, FOURTH_PRIZE));
		winnerPrize.add(List.of(FIFTH_MATCH_NUMBER, NOT_MATCH_BONUS, FIFTH_PRIZE));
	}

}
