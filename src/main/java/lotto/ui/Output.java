package lotto.ui;

import lotto.entity.Guide;
import lotto.entity.Place;

import java.util.List;
import java.util.Map;

public class Output {

    public void guideInputAmount() {
        System.out.println(Guide.INPUT_AMOUNT.getMessage());
    }

    public void guideInputWinningNumbers() {
        System.out.println(Guide.WINNING_NUMBER.getMessage());
    }

    public void guideInputBonusNumber() {
        System.out.println(Guide.BONUS_NUMBER.getMessage());
    }

    public void showPurchasesQuantity(int purchasesQuantity) {
        System.out.println(String.format(Guide.PURCHASING_QUANTITY.getMessage(),
                purchasesQuantity));
    }

    public void showBoughtLotto(List<List<Integer>> userLottoTickets) {
        for (List<Integer> userLottoTicket : userLottoTickets) {
            System.out.println(userLottoTicket);
        }
    }

    public void showWinningDetails(Map<Place, Integer> winningRanks) {
        System.out.println(Guide.WINNING_DETAILS.getMessage());
        for (Place place : Place.values()) {
            System.out.println(place.getWords()
                    + String.format(Guide.WINNING_DETAILS_ARGUMENT.getMessage(),
                    place.getPrizeMoney(), winningRanks.get(place)));
        }
    }

    public void showEarningRate(double earningRate) {
        System.out.println(String.format(Guide.EARNING_RATE.getMessage(), earningRate));
    }

}
