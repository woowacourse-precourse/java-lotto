package lotto;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 구입 금액 입력
        Console console = new Console();
        double money=0;
        try {
            money = console.inputMoney();
        } catch (IllegalArgumentException e) {
            console.outputMoneyErrorMessage();
            return;
        }

        // 로또 구매
        LottoGenerator lottoGenerator = new LottoGenerator();
        int count = lottoGenerator.getLottoCount(money);
        List<Integer>[] issuedLottos = lottoGenerator.createRandomNumbers(count);
        console.outputMyLottos(issuedLottos);

        // 당첨 번호 입력
        Lotto lotto = null;
        try {
             lotto = console.inputWinningNumbers();
        } catch (IllegalArgumentException e) {
            console.outputErrorMessage();
            return;
        }

        // 보너스 번호 입력
        int bonusNumber = console.inputBonusNumber();
        try {
            lotto.checkBonusException(bonusNumber);
        } catch (IllegalArgumentException e) {
            console.outputErrorMessage();
            return;
        }

        LottoResult lottoResult = new LottoResult();
        for (List<Integer> issuedLotto : issuedLottos) {
            // 로또 번호 비교
            int correctCount = lotto.compareNumbers(issuedLotto);
            // 보너스 번호 비교
            boolean bonus = lotto.compareBonus(bonusNumber);
            // 당첨 순위 계산
            Rank rank = Rank.findByCorrectCountAndBonus(correctCount, bonus);
            if (rank == null) {
                continue;
            }// 순위 저장
            lottoResult.insertResult(rank);
        }

        console.outputWinningResult(lottoResult.getCopyResult(), lottoResult.calculateYield(money));
    }
}
