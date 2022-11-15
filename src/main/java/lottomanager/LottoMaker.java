package lottomanager;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMaker {
    private List<Integer> makeLottoNumber(){
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    public List<List<Integer>> drawLotto(int payedMoney){
        List<List<Integer>> payedLotto = new ArrayList<>();

        for (int i = 0; i < payedMoney/1000; i++){
            payedLotto.add(makeLottoNumber());
        }

        return payedLotto;
    }

    public int compareLotto(List<Integer> winningNumber, List<Integer> payedLotto){
        int matches = 0;

        for (int i = 0; i < winningNumber.size(); i++){
            if (payedLotto.contains(winningNumber.get(i))) matches++;
        }

        return matches;
    }

    public boolean compareBonus(int bonusNumber, List<Integer> payedLotto){
        for (int i = 0; i < payedLotto.size(); i++){
            if (payedLotto.contains(bonusNumber)) return true;
        }
        return false;
    }
}
