package lotto.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinChecker {
    private final List<Integer> winNumber;
    private final int bonusNumber;

    public WinChecker(List<Integer> winNumber, int bonusNumber) throws IllegalArgumentException{
        if (winNumber.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호에 포함되지 않아야 합니다.");

        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    private Rank getRank(Lotto lottoNumber) {
        int count = lottoNumber.compare(winNumber);

        return Rank.of(count, isBonus(lottoNumber));
    }

    public Map<Rank, Integer> checkLotto(List<Lotto> lottos){
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto: lottos){
            Rank rank = getRank(lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    private boolean isBonus(Lotto lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }
}
