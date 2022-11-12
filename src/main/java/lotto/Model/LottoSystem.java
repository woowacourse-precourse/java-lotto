package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class LottoSystem {

    private static final List<Integer> winningStatics = new ArrayList<>();

    public static List<Integer> getWinningStatics() {
        return winningStatics;
    }

    public static void lottoSystem(List<Integer> winningNumber, int bonusNumber) {
        var myLottoNumbers = RandomLotto.getBundleOfLottoNumbers();
        myLottoNumbers.stream()
                .mapToInt(lottoNumberOfCase -> calcScore(winningNumber, bonusNumber, lottoNumberOfCase))
                .forEach(winningStatics::add);
    }

    private static int calcScore(List<Integer> winningNumber, int bonusNumber, List<Integer> lottoNumberOfCase) {
        int score = 0;
        for (int j : winningNumber) {
            if (lottoNumberOfCase.contains(j)) score += 1;
        }
        if (score == 5 && lottoNumberOfCase.contains(bonusNumber)) {
            score += 2;
        }
        return score;
    }
}
