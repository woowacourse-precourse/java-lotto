package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LotteryAnswer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.User;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private final LotteryAnswer answer;
    private final User user;
    private final LottoView lottoView;

    public LottoController(LotteryAnswer answer, User user, LottoView lottoView) {
        this.answer = answer;
        this.user = user;
        this.lottoView = lottoView;
    }

    public void purchase() {
        System.out.println(lottoView.PURCHASE);
        user.inputPurchaseAmount(Console.readLine());
        System.out.println();

        System.out.println(lottoView.afterPurchase(user.getPurchaseAmount()));
        user.createLottos();
        System.out.println(lottoView.lottos(user.getLottos()) + "\n");
    }

    public void inputAnswer() {
        System.out.println(lottoView.INPUT_ANSWER);
        answer.inputAnswerLotto(Console.readLine());
        System.out.println();

        System.out.println(lottoView.INPUT_BONUS);
        answer.inputBonusNumber(Console.readLine());
        System.out.println();
    }

    public void getResult() {
        for (Lotto lotto : user.getLottos()) {
            int countAnswer = countAnswer(lotto);
            int countBonus = countBonus(lotto);

            user.addPrize(Prize.getResult(countAnswer, countBonus));
        }

        System.out.println(lottoView.result(user.getPrizes()));
        System.out.println(lottoView.yield(user.getYield()));
    }

    private int countAnswer(Lotto lotto) {
        List<Integer> answerNumbers = answer.getAnswer().getNumbers();

        return (int) lotto.getNumbers().stream()
                .filter(answerNumbers::contains)
                .count();
    }

    private int countBonus(Lotto lotto) {
        int bonusNumber = answer.getBonusNumber();

        if (lotto.getNumbers().contains(bonusNumber))
            return 1;

        return 0;
    }
}
