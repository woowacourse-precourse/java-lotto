package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomLottos {
    private List<Lotto> randomLottos = new ArrayList<>();
    public RandomLottos(int money){
        validateMoney(money);
        for(int i = 0; i < money/1000; ++i) {
            List<Integer> list = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            randomLottos.add(new Lotto(list));
        }
    }

    public List<LottoRanking> createLottoRankingsBy(WinningLotto winningLotto){
        return randomLottos.stream()
                .map(randomLotto -> randomLotto.findLottoRankingBy(winningLotto))
                .collect(Collectors.toList());
    }

    public void printRandomLottos(){
        System.out.println("\n" + randomLottos.size() + "개를 구매했습니다.");
        for(Lotto lotto:randomLottos){
            lotto.printLottoNumbers();
        }
    }

    private void validateMoney(int money){
        if(money < 0){
            throw new IllegalArgumentException("[ERROR] 음수가 아닌 정수를 입력해야 합니다.");
        }
        if(money % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.");
        }
    }
}
