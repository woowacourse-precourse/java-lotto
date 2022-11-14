package lotto.constants;

import lotto.models.Rank;

import java.util.HashMap;
import java.util.Map;

public class Constant {
	private Constant() {}

	public static final int LOTTO_START_NUMBER = 1;
	public static final int LOTTO_END_NUMBER = 45;
	public static final int LOTTO_NUMBER_LENGTH = 6;
	public static final int LOTTO_PRICE = 1_000;

	public static final String SPLIT_LOTTO_DELIMITER = ",";

	public static final int LOTTO_FIRST_RANK_MATCHED_COUNT = 6;
	public static final int LOTTO_THIRD_RANK_MATCHED_COUNT = 5;
	public static final int LOTTO_FOURTH_RANK_MATCHED_COUNT = 4;
	public static final int LOTTO_FIFTH_RANK_MATCHED_COUNT = 3;
	public static final Map<Integer, Rank> ranks = new HashMap<>() {{
		put(LOTTO_FIRST_RANK_MATCHED_COUNT, Rank.FIRST);
		put(LOTTO_THIRD_RANK_MATCHED_COUNT, Rank.THIRD);
		put(LOTTO_FOURTH_RANK_MATCHED_COUNT, Rank.FOURTH);
		put(LOTTO_FIFTH_RANK_MATCHED_COUNT, Rank.FIFTH);
	}};

	public static final long NOT_COUNTED = 0L;
	protected static final int FIRST_RANK_WINNING_AMOUNT = 2_000_000_000;
	protected static final int SECOND_RANK_WINNING_AMOUNT = 30_000_000;
	protected static final int THIRD_RANK_WINNING_AMOUNT = 1_500_000;
	protected static final int FOURTH_RANK_WINNING_AMOUNT = 50_000;
	protected static final int FIFTH_RANK_WINNING_AMOUNT = 5_000;
	public static final Map<Rank, Integer> WINNING_AMOUNTS = new HashMap<>() {{
		put(Rank.FIRST, FIRST_RANK_WINNING_AMOUNT);
		put(Rank.SECOND, SECOND_RANK_WINNING_AMOUNT);
		put(Rank.THIRD, THIRD_RANK_WINNING_AMOUNT);
		put(Rank.FOURTH, FOURTH_RANK_WINNING_AMOUNT);
		put(Rank.FIFTH, FIFTH_RANK_WINNING_AMOUNT);
	}};

	public static final int PERCENT_UNIT_MULTIPLIER = 100;
	public static final int ROUND_TO_SECOND_DECIMAL_PLACE_FACTOR = 10;
}
