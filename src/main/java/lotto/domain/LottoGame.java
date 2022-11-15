package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    public enum eLottoPlace {
        FIRST_PLACE, SECOND_PLACE, THIRD_PLACE, FOURTH_PLACE, FIFTH_PLACE, NOTHING
    }

    private static final int _lotto_price = 1000;
    public static final int _1st_index = 0;
    public static final int _2nd_index = 1;
    public static final int _3rd_index = 2;
    public static final int _4th_index = 3;
    public static final int _5th_index = 4;

    // 로또 구매 함수
    public static List<Lotto> buy(int money) {
        validateMoney(money);
        return generateLotto(calcLottoCount(money));
    }

    private static List<Lotto> generateLotto(int lottoCount) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; ++i) {
            lotto.add(new Lotto(makeUniqueLottoNumber()));
        }
        return lotto;
    }

    private static int calcLottoCount(int money) {
        return money / _lotto_price;
    }

    private static void validateMoney(int money) {
        if (money < _lotto_price) {
            throw new IllegalArgumentException("[ERROR] 로또의 최소 가격은 " + _lotto_price + "원 입니다.");
        }
        if (money % _lotto_price != 0) {
            throw new IllegalArgumentException("[ERROR] 로또는 천원 단위로 구매할 수 있습니다.");
        }
    }
    
    private static List<Integer> makeUniqueLottoNumber() {
        return (Randoms.pickUniqueNumbersInRange(Lotto._min_lotto_number, Lotto._max_lotto_number,
                Lotto._lotto_length));
    }

    // 로또 결과 확인 함수
    public static int[] getResult(List<Lotto> lotto, Lotto winningLotto, int bonus) {
        int[] matchTable = initMatchTable();

        for (Lotto element : lotto) {
            eLottoPlace place = getMatchTable(element, winningLotto, bonus);
            matchTable = appendPlaceToResult(matchTable, place);
        }
        return matchTable;
    }

    private static int[] initMatchTable() {
        int[] matchTable = {0, 0, 0, 0, 0};

        return matchTable;
    }

    private static eLottoPlace getMatchTable(Lotto l1, Lotto l2, int bonus) {
        int matchCount = getMatchCount(l1, l2);

        return getLottoPlace(matchCount, l1.getNumbers().contains(bonus));
    }

    private static int getMatchCount(Lotto l1, Lotto l2) {
        int matchCount = 0;

        for (int num : l1.getNumbers()) {
            if (l2.getNumbers().contains(num)) {
                matchCount += 1;
            }
        }
        return matchCount;
    }

    private static eLottoPlace getLottoPlace(int matchCount, boolean isBonusMatch) {
        if (matchCount == 6)
            return eLottoPlace.FIRST_PLACE;
        if (matchCount == 5 && isBonusMatch)
            return eLottoPlace.SECOND_PLACE;
        if (matchCount == 5)
            return eLottoPlace.THIRD_PLACE;
        if (matchCount == 4)
            return eLottoPlace.FOURTH_PLACE;
        if (matchCount == 3)
            return eLottoPlace.FIFTH_PLACE;
        return eLottoPlace.NOTHING;
    }


    private static int[] appendPlaceToResult(int[] matchTable, eLottoPlace place) {
        if (place == eLottoPlace.FIRST_PLACE)
            matchTable[_1st_index] += 1;
        if (place == eLottoPlace.SECOND_PLACE)
            matchTable[_2nd_index] += 1;
        if (place == eLottoPlace.THIRD_PLACE)
            matchTable[_3rd_index] += 1;
        if (place == eLottoPlace.FOURTH_PLACE)
            matchTable[_4th_index] += 1;
        if (place == eLottoPlace.FIFTH_PLACE)
            matchTable[_5th_index] += 1;
        return matchTable;
    }
}
