package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private int money;
    private List<Lotto> numbers;
    private Map<LottoWinType, Integer> lottoWinTypeMap;

    public User(int money, List<Lotto> numbers) {
        this.money = money;
        this.numbers = numbers;
        this.lottoWinTypeMap = new HashMap<>();
    }

    public static User of(int money, List<Lotto> lottos) {
        return new User(money, lottos);
    }

    public GameScore getGameScore(Lotto lottoNumbers, int bonusNumber) {
        int totalWinMoney = 0;
        initLottoWinTypeMap();
        for (Lotto lotto : this.numbers) {
            LottoWinType winType = lotto.checkMatchedLotto(lottoNumbers.getNumbers(), bonusNumber);
            totalWinMoney += winType.getMoney();
            this.lottoWinTypeMap.put(winType, this.lottoWinTypeMap.get(winType) + 1);
        }
        return GameScore.of(totalWinMoney, this.money, this.lottoWinTypeMap);
    }

    private void initLottoWinTypeMap() {
        this.lottoWinTypeMap.put(LottoWinType.FIRST, 0);
        this.lottoWinTypeMap.put(LottoWinType.SECOND, 0);
        this.lottoWinTypeMap.put(LottoWinType.THIRD, 0);
        this.lottoWinTypeMap.put(LottoWinType.FOURTH, 0);
        this.lottoWinTypeMap.put(LottoWinType.FIFTH, 0);
        this.lottoWinTypeMap.put(LottoWinType.ELSE, 0);
    }
}
