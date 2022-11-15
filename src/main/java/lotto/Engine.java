package lotto;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

/*
 * 로또 게임의 구동을 담당하는 클래스 
 */
public class Engine {

    private static String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static String NUMBER_OF_PURCHASED = "개를 구매했습니다.";
    private static String INPUT_WINNERS = "당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS = "보너스 번호를 입력해 주세요.";
    private static String OUTPUT_STATISTICS = "당첨 통계\n---";
    private static String RESULT_MESSAGE = "%d개 일치%s(%s원) - %d개\n";
    private static String BONUS_MESSAGE = ", 보너스 볼 일치 ";
    private static String OUTPUT_PROFIT = "총 수익률은 ";
    private static double moneyPaid = 0;
    private static double moneyWon = 0;

    private InputManager input = new InputManager();
    private LottoMachine lottoMachine = new LottoMachine();
    private List<Lotto> lottoTickets = new ArrayList<Lotto>();
    Lotto winningNumber;
    int bounusNumber;
    WinnersLotto winnersLotto;
    private Result result;

    public void run() {
        initLottoTickets();
        initWinningNumber();
        printResults();
    }

    private static String printIfSecond(final Reward reward) {
        if (reward.equals(Reward.SECOND)) {
            return BONUS_MESSAGE;
        }
        return " ";
    }

    private static double getProfit(double paid, double won) {
        double result = ((double) won / (double) paid) * 10;
        return (double) Math.round(result * 100) / 10;
    }

    private void initLottoTickets() {
        System.out.println(INPUT_MONEY);
        int purchase = input.purchaseAmount();
        moneyPaid = purchase * 1000;
        System.out.println(purchase + NUMBER_OF_PURCHASED);
        lottoTickets = lottoMachine.createLottoTickets(purchase);
        for (Lotto lottos : lottoTickets) {
            lottos.printNumber();
        }
    }

    private void initWinningNumber() {
        System.out.println(INPUT_WINNERS);
        winningNumber = new Lotto(input.getWinningNum());
        System.out.println(INPUT_BONUS);
        bounusNumber = input.getBounusNum();
        winnersLotto = WinnersLotto.of(winningNumber, bounusNumber);
        result = new Result(lottoTickets, winnersLotto);
    }

    private void printResults() {
        DecimalFormat formatter = new DecimalFormat("###,###");

        System.out.println(OUTPUT_STATISTICS);
        for (Reward reward : Reward.getWithoutDefault()) {
            System.out.printf(RESULT_MESSAGE,
                    reward.getSameCount(), printIfSecond(reward),
                    String.valueOf(formatter.format(reward.getPrize())), result.getRank(reward));

            moneyWon += reward.getPrize() * result.getRank(reward);
        }
        System.out.println(OUTPUT_PROFIT + getProfit(moneyPaid, moneyWon) + "%입니다.");
    }

}
