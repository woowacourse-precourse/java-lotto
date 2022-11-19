package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * 숫자를 비교하고 수익률을 계산하는 클래스
 */
public class CompareNumber {
    private static final int STANDARDWINNINGLOTTO = 3;
    private static final int RANKFIVEINDEX = 3;
    private static final int RANKSIXINDEX = 4;
    private static final int RIGHTNUMBERFIVE = 5;
    private static final int RIGHTNUMBERSIX = 6;

    private List<List<Integer>> lottoNumbers;
    private List<Integer> winingNumbers;
    private int bonusNumber;
    private List<Integer> lottoResult;

    public CompareNumber(List<List<Integer>> lottoNumbers, List<Integer> winingNumbers, int bonusNumber) {
        this.lottoNumbers = lottoNumbers;
        this.winingNumbers = winingNumbers;
        this.bonusNumber = bonusNumber;
        this.lottoResult = new ArrayList<>(List.of(0, 0, 0, 0, 0));
    }

    public List<Integer> getLottoResult() {
        return lottoResult;
    }

    public void compareLotto() {
        for (List<Integer> lottoNumber : lottoNumbers) {
            int compareCount = countDuplicateNumber(lottoNumber);
            rankLotto(compareCount, lottoNumber);
        }
    }

    public int countDuplicateNumber(List<Integer> lottoNumber) {
        List<Integer> joined = Stream.concat(lottoNumber.stream(), winingNumbers.stream())
                .distinct()
                .collect(Collectors.toList());
        return (lottoNumber.size() + winingNumbers.size()) - joined.size();
    }

    public void rankLotto(int correctCount, List<Integer> lottoNumber) {
        if (correctCount == RIGHTNUMBERFIVE && compareBonusNumber(lottoNumber)) {
            lottoResult.set(RANKFIVEINDEX, lottoResult.get(RANKFIVEINDEX) + 1);
        }
        if (correctCount == RIGHTNUMBERSIX) {
            lottoResult.set(RANKSIXINDEX, lottoResult.get(RANKSIXINDEX) + 1);
        }
        if (correctCount >= STANDARDWINNINGLOTTO) {
            lottoResult.set(correctCount - STANDARDWINNINGLOTTO, lottoResult.get(correctCount - STANDARDWINNINGLOTTO) + 1);
        }
    }

    public boolean compareBonusNumber(List<Integer> lottoNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    public float calculationYield(String inputMoney) {
        int money = Integer.parseInt(inputMoney);
        float sum = 0;
        for (int i = 0; i < lottoResult.size(); i++) {
            Rank rank = Rank.valueOf(i);
            sum += rank.getPrize() * lottoResult.get(i);
        }
        return (sum / money) * 100;
    }

}
