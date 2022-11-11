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
        try{
            int numOfLotto = UserInput.inputPrice();
            createLottoTickets(numOfLotto);
            showLottoTickets();

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

    public static void showLottoTickets() {
        System.out.println(lottoTickets.size()+"개를 구매했습니다.");
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
