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
    private List<Lotto> _lotto;
    private Lotto _winning_lotto;
    private int _bonus_number;
    private int[] _match_table;
    private int _money;

    public LottoGame(int money) {
        setMoney(money);
        setBonusNumber(-1);
        setLotto(null);
        setWinningLotto(null);
        setMatchTable(null);
    }

    // 로또 구매 함수
    public void buy() {
        validateMoney();
        setLotto(generateLotto(calcLottoCount()));
    }

    private List<Lotto> generateLotto(int lottoCount) {
        List<Lotto> lotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; ++i) {
            lotto.add(new Lotto(makeUniqueLottoNumber()));
        }
        return lotto;
    }

    private int calcLottoCount() {
        return getMoney() / _lotto_price;
    }

    private void validateMoney() {
        int money = getMoney();

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
    public void getResult() {
        setMatchTable(initMatchTable());

        for (Lotto element : getLotto()) {
            eLottoPlace place = getLottoPlace(element, getWinningLotto());
            setMatchTable(appendPlaceToResult(getMatchTable(), place));
        }
    }

    private static int[] initMatchTable() {
        int[] matchTable = {0, 0, 0, 0, 0};

        return matchTable;
    }

    private eLottoPlace getLottoPlace(Lotto l1, Lotto l2) {
        int matchCount = getMatchNumberCount(l1, l2);
        boolean isBonusMatch = l1.getNumbers().contains(getBonusNumber());

        return matchLottoPlace(matchCount, isBonusMatch);
    }

    private int getMatchNumberCount(Lotto l1, Lotto l2) {
        int matchCount = 0;

        for (int num : l1.getNumbers()) {
            if (l2.getNumbers().contains(num)) {
                matchCount += 1;
            }
        }
        return matchCount;
    }

    private eLottoPlace matchLottoPlace(int matchCount, boolean isBonusMatch) {
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


    private int[] appendPlaceToResult(int[] matchTable, eLottoPlace place) {
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

    // setter
    public void setLotto(List<Lotto> lotto) {
        this._lotto = lotto;
    }

    public void setMatchTable(int[] matchTable) {
        this._match_table = matchTable;
    }

    public void setMoney(int money) {
        this._money = money;
    }

    public void setWinningLotto(Lotto winningLotto) {
        this._winning_lotto = winningLotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this._bonus_number = bonusNumber;
    }

    // getter
    public List<Lotto> getLotto() {
        if (this._lotto == null) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하지 않았습니다.");
        }
        return this._lotto;
    }

    public int[] getMatchTable() {
        if (this._match_table == null) {
            throw new IllegalArgumentException("[ERROR] 로또 당첨 테이블이 계산 되지 않았습니다.");
        }
        return this._match_table;
    }

    public int getMoney() {
        if (this._money == -1) {
            throw new IllegalArgumentException("[ERROR] 구매 금액을 입력 받지 않았습니다.");
        }
        return this._money;
    }

    public Lotto getWinningLotto() {
        if (this._winning_lotto == null) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 입력되지 않았습니다.");
        }
        return this._winning_lotto;
    }

    public int getBonusNumber() {
        if (this._bonus_number == -1) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 입력되지 않았습니다.");
        }
        return _bonus_number;
    }
}
