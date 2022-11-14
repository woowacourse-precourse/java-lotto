package lotto.domain;

import java.util.List;
import lotto.lottoclient.LottoConsole;

public class LottoChecker {

    private final LottoConsole lottoConsole;
    private AnswerLotto answerLotto;

    public LottoChecker(LottoConsole lottoConsole) {
        this.lottoConsole = lottoConsole;
    }

    public void decideAnswerLotto() {
        this.answerLotto = new AnswerLotto(lottoConsole.inputAnswerNumber(),
            lottoConsole.inputAnswerBonusNumber());
    }

    public AnswerLotto getAnswerLotto() {
        return answerLotto;
    }

    public void checkUserLottoList(User user) {
        List<PaidLotto> paidLottoList = user.getPaidLottoList();
        paidLottoList.forEach(paidLotto -> paidLotto.compareWith(this.answerLotto));
    }

    public void tellAnswerToUser(User user) {
        for (LottoReward lottoReward : LottoReward.values()) {
            lottoReward.getReward(user.getPaidLottoList().stream().filter(PaidLotto::isRewarded)
                .filter(paidLotto -> paidLotto.hasSameLottoReward(lottoReward))
                .count());
        }

        user.tellBenefit();
    }
}
