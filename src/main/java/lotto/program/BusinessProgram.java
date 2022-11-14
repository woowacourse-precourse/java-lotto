package lotto.program;

import lotto.utils.Converter;
import lotto.utils.Generator;
import lotto.domain.Lotto;
import lotto.domain.LottoOfAnswer;
import lotto.domain.LottoOfUser;
import lotto.domain.PrizeOfUser;

public class BusinessProgram {

    public LottoOfUser generateUserLotto(int money) {
        int ticket = Converter.moneyToTicket(money);
        return generateLottoByTicket(ticket);
    }

    private LottoOfUser generateLottoByTicket(int ticket) {
        LottoOfUser userOfLotto = new LottoOfUser();
        for (int index = 0; index < ticket; index++) {
            Lotto newLotto = new Lotto(Generator.makeRandomLottoNumbers());
            userOfLotto.add(newLotto);
        }
        System.out.println(ticket+"개를 구매했습니다.");
        return userOfLotto;
    }

    public void printUserLottoResults(LottoOfUser userLotto, LottoOfAnswer answerLotto) {
        System.out.println("당첨통계\n---");
        PrizeOfUser userPrize = userLotto.matchWithAnswer(answerLotto);
        userPrize.printPrize();
    }

    public void printUserLotto(LottoOfUser userLotto) {
        userLotto.printAllLotto();
    }
}
