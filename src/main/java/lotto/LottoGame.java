package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public enum eLottoPlace {
        FIRST_PLACE,
        SECOND_PLACE,
        THIRD_PLACE,
        FOURTH_PLACE,
        FIFTH_PLACE,
        NOTHING
    }
    private static final int _lotto_price = 1000;
    public static final int _first_place = 0;
    public static final int _second_place = 1;
    public static final int _third_place = 2;
    public static final int _fourth_place = 3;
    public static final int _fifth_place = 4;

    public static List<Lotto> buyLotto(int money) {
        List<Lotto> lottoes = new ArrayList<>();
        int lottoCount = money / _lotto_price;

        if (money < _lotto_price) {
            throw new IllegalArgumentException(Application._err_msg + " 로또의 최소 가격은 " + _lotto_price + "원 입니다.");
        }
        if (money % _lotto_price != 0) {
            throw new IllegalArgumentException(Application._err_msg + " 로또는 천원 단위로 구매할 수 있습니다.");
        }

        for (int i = 0; i < lottoCount; ++i) {
            lottoes.add(new Lotto(makeUniqueLottoNumber()));
        }
        LottoOutStream.outStreamLottoCount(lottoCount);
        return lottoes;
    }

    public static int[] getResultLotto(List<Lotto> lottoes, Lotto winningLotto, int bonus) {
        int[] matches = {0, 0, 0, 0, 0};

        for (Lotto lotto: lottoes) {
            eLottoPlace place = matchLotto(lotto, winningLotto, bonus);
            matches = appendPlaceToResult(matches, place);
        }
        return matches;
    }

    public static eLottoPlace matchLotto(Lotto l1, Lotto l2, int bonus) {
        int matches = 0;

        for (int num : l1.getNumbers()) {
            if (l2.getNumbers().contains(num)) {
                matches += 1;
            }
        }
        return getLottoPlace(matches, l1.getNumbers().contains(bonus));
    }

    public static BigDecimal calcRateOfReturn(int[] matches, int money) {
        BigDecimal rateOfReturn = new BigDecimal(sumReward(matches));

        rateOfReturn = rateOfReturn.divide(new BigDecimal(String.valueOf(money)), 3, RoundingMode.CEILING);
        rateOfReturn = rateOfReturn.multiply(new BigDecimal("100"));

        return rateOfReturn.setScale(1, RoundingMode.HALF_UP);
    }

    private static BigInteger sumReward(int[] matches) {
        BigInteger reward = new BigInteger("0");
        String[] rewardByPlace = {"2000000000", "30000000", "1500000", "50000", "5000"};

        for (int i = 0; i < matches.length; ++i) {
            BigInteger nowReward = new BigInteger(rewardByPlace[i]);
            BigInteger count = new BigInteger(String.valueOf(matches[i]));

            nowReward = nowReward.multiply(count);
            reward = reward.add(nowReward);
        }
        return reward;
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

    private static List<Integer> makeUniqueLottoNumber() {
        return (Randoms.pickUniqueNumbersInRange(Lotto._min_lotto_number, Lotto._max_lotto_number, Lotto._lotto_length));
    }

    private static int[] appendPlaceToResult(int[] matches, eLottoPlace place) {
        if (place == eLottoPlace.FIRST_PLACE)
            matches[_first_place] += 1;
        if (place == eLottoPlace.SECOND_PLACE)
            matches[_second_place] += 1;
        if (place == eLottoPlace.THIRD_PLACE)
            matches[_third_place] += 1;
        if (place == eLottoPlace.FOURTH_PLACE)
            matches[_fourth_place] += 1;
        if (place == eLottoPlace.FIFTH_PLACE)
            matches[_fifth_place] += 1;
        return matches;
    }
}
