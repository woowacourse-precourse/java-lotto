package lottomanager;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoChecker {

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

    public ArrayList<Integer> getRank(List<List<Integer>> Lottoes, List<Integer> winningLotto, boolean bonus ) {
        ArrayList<Integer> Rank = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (int i = 0; i < Lottoes.size(); i++) {
            if (compareLotto(winningLotto, Lottoes.get(i)) == 3) Rank.set(0, Rank.get(0) + 1);
            else if (compareLotto(winningLotto, Lottoes.get(i)) == 4) Rank.set(1, Rank.get(1) + 1);
            else if (compareLotto(winningLotto, Lottoes.get(i)) == 5 && bonus) Rank.set(3, Rank.get(3) + 1);
            else if (compareLotto(winningLotto, Lottoes.get(i)) == 5) Rank.set(2, Rank.get(2) + 1);
            else if (compareLotto(winningLotto, Lottoes.get(i)) == 6) Rank.set(4, Rank.get(4) + 1);
        }
        return Rank;
    }
}
