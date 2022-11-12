package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import utils.Output;
import utils.UserInput;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.INITIAL_NUMBER;
import static constant.Constant.MONEY_UNIT;

public class Application {
    static List<Lotto> lottoTickets = new ArrayList<>();

    public static void main(String[] args) {
        try{
            int numOfLotto = UserInput.inputPrice();
            createLottoTickets(numOfLotto);
            Output.showLottoTickets(lottoTickets);

            UserInput.inputWinningNumbers();
            Result result = new Result(lottoTickets);
            result.calculateReturnOfRate(numOfLotto*MONEY_UNIT);
        } catch (IllegalArgumentException e) {
        }
    }

    private static void createLottoTickets(int numOfLotto) {
        for (int i=INITIAL_NUMBER; i<numOfLotto; i++) {
            lottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

}
