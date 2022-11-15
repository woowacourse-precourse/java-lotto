package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.utils.Constant;

public class User {

    private int money;
    private List<Lotto> numbers;
    private Map<LottoWinType, Integer> lottoWinTypeMap;

    public User(int money, List<Lotto> numbers) {
        this.money = money;
        this.numbers = numbers;
        this.lottoWinTypeMap = new HashMap<>();
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getNumbers() {
        return numbers;
    }

    public Map<LottoWinType, Integer> getLottoWinTypeMap() {
        return lottoWinTypeMap;
    }

    public static User of(int money, List<Lotto> lottos) {
        return new User(money, lottos);
    }

    private void initLottoWinTypeMap() {
        this.lottoWinTypeMap.put(LottoWinType.FIRST_PLACE, 0);
        this.lottoWinTypeMap.put(LottoWinType.SECOND_PLACE, 0);
        this.lottoWinTypeMap.put(LottoWinType.THIRD_PLACE, 0);
        this.lottoWinTypeMap.put(LottoWinType.FOURTH_PLACE, 0);
        this.lottoWinTypeMap.put(LottoWinType.FIFTH_PLACE, 0);
        this.lottoWinTypeMap.put(LottoWinType.ELSE, 0);
    }

    public static int payDividedByUnit(int money) {
        return money / Constant.MONEY_UNIT;
    }

    public GameScore getGameScore(Lotto winLottoNumbers, int bonusLottoNumber) {
        int totalPrizeMoney = 0;
        initLottoWinTypeMap();
        for (Lotto lotto : this.numbers) {
            LottoWinType winType = lotto.findMatchedLotto(winLottoNumbers.getNumbers(), bonusLottoNumber);
            totalPrizeMoney += winType.getMoney();
            this.lottoWinTypeMap.put(winType, this.lottoWinTypeMap.get(winType) + 1);
        }
        return GameScore.of(totalPrizeMoney, this.money, this.lottoWinTypeMap);
    }
}
