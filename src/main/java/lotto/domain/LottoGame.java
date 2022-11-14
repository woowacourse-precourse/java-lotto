package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public enum eLottoPlace {
        FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, FIFTH_PLACE, NOTHING
    }

    private static final int _lotto_price = 1000;
    private static final String _1st_reward = "2000000000";
    private static final String _2nd_reward = "30000000";
    private static final String _3rd_reward = "1500000";
    private static final String _4th_reward = "50000";
    private static final String _5th_reward = "5000";
    public static final int _1st_index = 0;
    public static final int _2nd_index = 1;
    public static final int _3rd_index = 2;
    public static final int _4th_index = 3;
    public static final int _5th_index = 4;

    // 로또 구매 함수
    public static List<Lotto> buyLotto(int money) {
        List<Lotto> lottoes = new ArrayList<>();
        int lottoCount = money / _lotto_price;

        if (money < _lotto_price) {
            throw new IllegalArgumentException("[ERROR] 로또의 최소 가격은 " + _lotto_price + "원 입니다.");
        }
        if (money % _lotto_price != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원 단위로 구매할 수 있습니다.");
        }

        for (int i = 0; i < lottoCount; ++i) {
            lottoes.add(new Lotto(makeUniqueLottoNumber()));
        }
        return lottoes;
    }


    private static List<Integer> makeUniqueLottoNumber() {
        return (Randoms.pickUniqueNumbersInRange(Lotto._min_lotto_number, Lotto._max_lotto_number,
                Lotto._lotto_length));
    }

    // 로또 결과 확인 함수
    public static int[] getResultLotto(List<Lotto> lottoes, Lotto winningLotto, int bonus) {
        int[] matchTable = initMatchTable();

        for (Lotto lotto : lottoes) {
            eLottoPlace place = matchLotto(lotto, winningLotto, bonus);
            matchTable = appendPlaceToResult(matchTable, place);
        }
        return matchTable;
    }

    private static int[] initMatchTable() {
        int[] matchTable = {0, 0, 0, 0, 0};

        return matchTable;
    }

    private static eLottoPlace matchLotto(Lotto l1, Lotto l2, int bonus) {
        int matches = 0;

        for (int num : l1.getNumbers()) {
            if (l2.getNumbers().contains(num)) {
                matches += 1;
            }
        }
        return getLottoPlace(matches, l1.getNumbers().contains(bonus));
    }

    private static eLottoPlace getLottoPlace(int matches, boolean isBonusMatch) {
        if (matches == 6)
            return eLottoPlace.FIRST_PLACE;
        if (matches == 5 && isBonusMatch)
            return eLottoPlace.SECOND_PLACE;
        if (matches == 5)
            return eLottoPlace.THIRD_PLACE;
        if (matches == 4)
            return eLottoPlace.FOURTH_PLACE;
        if (matches == 3)
            return eLottoPlace.FIFTH_PLACE;
        return eLottoPlace.NOTHING;
    }


    private static int[] appendPlaceToResult(int[] matches, eLottoPlace place) {
        if (place == eLottoPlace.FIRST_PLACE)
            matches[_1st_index] += 1;
        if (place == eLottoPlace.SECOND_PLACE)
            matches[_2nd_index] += 1;
        if (place == eLottoPlace.THIRD_PLACE)
            matches[_3rd_index] += 1;
        if (place == eLottoPlace.FOURTH_PLACE)
            matches[_4th_index] += 1;
        if (place == eLottoPlace.FIFTH_PLACE)
            matches[_5th_index] += 1;
        return matches;
    }

    // 수익률 계산 함수
    public static BigDecimal calcRateOfReturn(int[] matches, int money) {
        BigDecimal rateOfReturn = new BigDecimal(sumReward(matches));

        rateOfReturn = rateOfReturn.divide(new BigDecimal(String.valueOf(money)), 3, RoundingMode.CEILING);
        rateOfReturn = rateOfReturn.multiply(new BigDecimal("100"));

        return rateOfReturn.setScale(1, RoundingMode.HALF_UP);
    }

    private static BigInteger sumReward(int[] matches) {
        BigInteger reward = new BigInteger("0");
        String[] rewardTable = {_1st_reward, _2nd_reward, _3rd_reward, _4th_reward, _5th_reward};

        for (int i = 0; i < matches.length; ++i) {
            BigInteger nowReward = new BigInteger(rewardTable[i]);
            BigInteger count = new BigInteger(String.valueOf(matches[i]));

            nowReward = nowReward.multiply(count);
            reward = reward.add(nowReward);
        }
        return reward;
    }
}
