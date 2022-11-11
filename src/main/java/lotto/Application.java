package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import utils.UserInput;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.INITIAL_NUMBER;
import static constant.Constant.MONEY_UNIT;

public class Application {
    static List<Lotto> lottoTickets = new ArrayList<>();

    public static void main(String[] args) {
        int numOfLotto = UserInput.inputPrice();
        createLottoTickets(numOfLotto);
        System.out.println(numOfLotto+"개를 구매했습니다.");
        showLottoTickets();
        UserInput.inputWinningNumbers();
        Result result = new Result(lottoTickets);
        double returnOfRate = result.calculateReturnOfRate(numOfLotto*MONEY_UNIT);
        System.out.println("총 수익률은 "+returnOfRate+"%입니다.");
    }

    private static void createLottoTickets(int numOfLotto) {
        for (int i=INITIAL_NUMBER; i<numOfLotto; i++) {
            lottoTickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public static void showLottoTickets() {
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
