package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoUtils;

public class User {

    private static List<LottoGrade> lottoGrades;
    private int lottoPayment;
    private List<Lotto> lottos;
    private double profit;

    public void buyLottos(int lottoAmount) {
        lottos = new ArrayList<>();

        while (lottos.size() < lottoAmount) {
            List<Integer> lottoNumbers = new ArrayList<>(LottoUtils.pickUniqueNumbersInRange());
            Collections.sort(lottoNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }

    public void getLottoResults(WinningLotto winningLotto) {
        lottoGrades = new ArrayList<>();

        for (Lotto lotto : lottos) {
            LottoGrade lottoGrade = lotto.getLottoGrade(winningLotto);
            if (lottoGrade != null) {
                lottoGrades.add(lottoGrade);
            }
        }
    }

    public static int getCountLottoGrade(LottoGrade lottoGrade) {
        return (int) lottoGrades.stream()
                .filter(lottoGrade::equals)
                .count();
    }

    public String getLottoProfitRate() {
        for (LottoGrade lottoGrade : lottoGrades) {
            profit += lottoGrade.getPrize();
        }
        return String.format("%.1f", profit / lottoPayment * 100);
    }

    public void setLottoPayment(int lottoPayment) {
        this.lottoPayment = lottoPayment;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
