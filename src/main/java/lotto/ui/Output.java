package lotto.ui;

import lotto.standard.Place;

import java.util.List;
import java.util.Map;

public class Output {

    private static final String GUIDE_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String GUIDE_INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요.";
    private static final String GUIDE_INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    private static final String PURCHASING_QUANTITY = "\n%d개를 구매했습니다.";
    private static final String WINNING_DETAILS = "\n당첨 통계\n" + "---";
    private static final String WINNING_DETAILS_ARGUMENT = "(%,d원) - %d개";
    private static final String EARNING_RATE = "총 수익률은 %.1f%%입니다.";

    public void guideInputAmount() {
        System.out.println(GUIDE_INPUT_AMOUNT);
    }

    public void guideInputWinningNumbers() {
        System.out.println(GUIDE_INPUT_WINNING_NUMBER);
    }

    public void guideInputBonusNumber() {
        System.out.println(GUIDE_INPUT_BONUS_NUMBER);
    }

    public void showPurchasesQuantity(int purchasesQuantity) {
        System.out.println(String.format(PURCHASING_QUANTITY, purchasesQuantity));
    }


    public void showBoughtLotto(List<List<Integer>> userLottoTickets) {
        for (List<Integer> userLottoTicket : userLottoTickets) {
            System.out.println(userLottoTicket);
        }
    }

    public void showWinningDetails(Map<Place, Integer> winningRanks) {
        System.out.println(WINNING_DETAILS);
        for (Place place : Place.values()) {
            System.out.println(place.getWords()
                    + String.format(WINNING_DETAILS_ARGUMENT, place.getPrizeMoney(), winningRanks.get(place)));
        }
    }

    public void showEarningRate(double earningRate) {
        System.out.println(String.format(EARNING_RATE, earningRate));
    }

}
