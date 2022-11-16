package lotto.model;

import java.util.*;

public class LottosResult {
    private static final int FIRST_PRIZE_COUNT_POSITION = 0;
    private static final int SECOND_PRIZE_COUNT_POSITION = 1;
    private static final int THIRD_PRIZE_COUNT_POSITION = 2;
    private static final int FOURTH_PRIZE_COUNT_POSITION = 3;
    private static final int FIFTH_PRIZE_COUNT_POSITION = 4;
    private static final int LOSE_COUNT_POSITION = 5;
    private static final Map<LottoPrize, Integer> positions = new HashMap<>();
    private final List<Integer> lottosResult;

    static {
        positions.put(LottoPrize.FIRST, FIRST_PRIZE_COUNT_POSITION);
        positions.put(LottoPrize.SECOND, SECOND_PRIZE_COUNT_POSITION);
        positions.put(LottoPrize.THIRD, THIRD_PRIZE_COUNT_POSITION);
        positions.put(LottoPrize.FOURTH, FOURTH_PRIZE_COUNT_POSITION);
        positions.put(LottoPrize.FIFTH, FIFTH_PRIZE_COUNT_POSITION);
        positions.put(LottoPrize.LOSE, LOSE_COUNT_POSITION);
    }

    public LottosResult() {
        lottosResult = new ArrayList<>();

        for (int index = 0; index < positions.size(); index++) {
            lottosResult.add(0);
        }
    }

    public void winLotto(LottoPrize lottoPrize) {
        int position = positions.get(lottoPrize);

        lottosResult.set(position, lottosResult.get(position) + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottosResult other = (LottosResult) o;
        return Objects.equals(lottosResult, other.lottosResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottosResult);
    }

    @Override
    public String toString() {
        String result = Formats.HEAD +
                String.format(Formats.FIFTH_LOTTO_PRIZE_MESSAGE, lottosResult.get(FIFTH_PRIZE_COUNT_POSITION)) +
                String.format(Formats.FOURTH_LOTTO_PRIZE_MESSAGE, lottosResult.get(FOURTH_PRIZE_COUNT_POSITION)) +
                String.format(Formats.THIRD_LOTTO_PRIZE_MESSAGE, lottosResult.get(THIRD_PRIZE_COUNT_POSITION)) +
                String.format(Formats.SECOND_LOTTO_PRIZE_MESSAGE, lottosResult.get(SECOND_PRIZE_COUNT_POSITION)) +
                String.format(Formats.FIRST_LOTTO_PRIZE_MESSAGE, lottosResult.get(FIRST_PRIZE_COUNT_POSITION));

        return result;
    }

    private static class Formats {
        private static final String HEAD = "\n당첨 통계\n---\n";
        private static final String FIFTH_LOTTO_PRIZE_MESSAGE = "3개 일치 (5,000원) - %d개\n";
        private static final String FOURTH_LOTTO_PRIZE_MESSAGE = "4개 일치 (50,000원) - %d개\n";
        private static final String THIRD_LOTTO_PRIZE_MESSAGE = "5개 일치 (1,500,000원) - %d개\n";
        private static final String SECOND_LOTTO_PRIZE_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
        private static final String FIRST_LOTTO_PRIZE_MESSAGE = "6개 일치 (2,000,000,000원) - %d개\n";
    }
}
