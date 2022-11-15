package Domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoCompare {

    public List<List<Integer>> compareResultLotto(List<List<Integer>> userLotto, List<Integer> winnerLotto, String inputBonusNumber) {
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);
        List<List<Integer>> userResult = new ArrayList<>();

        for (List<Integer> lottoSheet : userLotto) {
            List<Integer> unMatchBall = unMatchUserBall(lottoSheet, winnerLotto);

            int totalMatch = 6 - unMatchBall.size();
            int bonusBall = bonusNumber.matchBonusNumber(unMatchBall);

            userResult.add(Arrays.asList(totalMatch, bonusBall));
        }
        return userResult;
    }

    public List<Integer> unMatchUserBall(List<Integer> userLottoSheet, List<Integer> winnerLotto) {
        List<Integer> LottoSheet = new ArrayList<>(userLottoSheet);
        LottoSheet.removeAll(winnerLotto); // 위너와 중복되는 공 제거
        return LottoSheet;
    }

}
