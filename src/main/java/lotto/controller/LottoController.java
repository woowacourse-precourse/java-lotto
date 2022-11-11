package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Answer;
import lotto.domain.Lotto;
import lotto.domain.Prize;
import lotto.domain.User;
import lotto.view.LottoView;

import java.util.List;

public class LottoController {
    private final Answer answer;
    private final User user;
    private final LottoView lottoView;

    public LottoController(Answer answer, User user, LottoView lottoView) {
        this.answer = answer;
        this.user = user;
        this.lottoView = lottoView;
    }

    public void purchase() {
        lottoView.purchase();
        user.inputPurchaseAmount(Console.readLine());

        lottoView.afterPurchase(user.getPurchaseAmount());
        lottoView.lottos(user.createLottos());
    }

    public void inputAnswer() {
        lottoView.inputAnswer();
        answer.inputAnswerLotto(Console.readLine());

        lottoView.inputBonus();
        answer.inputBonusNumber(Console.readLine());
    }

    public void getResult() {
        for (Lotto lotto : user.getLottos()) {
            int countAnswer = countAnswer(lotto);
            int countBonus = countBonus(lotto);

            user.addPrize(Prize.getResult(countAnswer, countBonus));
        }

        lottoView.result(user.getPrizes());
        lottoView.yield(user.getYield());
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
