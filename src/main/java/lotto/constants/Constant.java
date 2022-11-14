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
}
