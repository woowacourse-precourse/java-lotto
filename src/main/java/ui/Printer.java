package ui;

import dto.ResultDto;
import lotto.Lotto;

import java.util.Collections;
import java.util.List;

public class Printer {

    public void printEnterPurchaseAmount() {
        System.out.println(UiText.ENTER_PURCHASE_AMOUNT.getTxt());
    }

    public void printBoughtNum(Integer boughtNum) {
        System.out.println(boughtNum + UiText.BOUGHT_NUMBER.getTxt());
    }

    public void printLotto(List<Lotto> boughtLotto) {
        for (Lotto lotto : boughtLotto) {
//            Collections.sort(lotto.getNumbers());
            System.out.println(lotto.getNumbers());
        }
    }

    public void printEnterWinningNumber() {
        System.out.println(UiText.ENTER_WINNING_NUMBER.getTxt());
    }

    public void printEnterBonusNumber() {
        System.out.println(UiText.ENTER_BONUS_NUMBER.getTxt());
    }

    public void printWinningStatistics(ResultDto dto) {
        System.out.println(UiText.WINNING_STATISTICS.getTxt());
        System.out.println(UiText.THREE_MATCHES.getTxt() + dto.getThreeCount() + "개");
        System.out.println(UiText.FOUR_MATCHES.getTxt() + dto.getFourCount() + "개");
        System.out.println(UiText.FIVE_MATCHES.getTxt() + dto.getFiveCount() + "개");
        System.out.println(UiText.FIVE_AND_BONUS_MATCHES.getTxt() + dto.getFiveBonusCount() + "개");
        System.out.println(UiText.SIX_MATCHES.getTxt() + dto.getSixCount() + "개");
        System.out.println(UiText.GROSS_RETURN.getTxt() + String.format("%.1f", dto.getGrossReturn()) + "%입니다.");
    }

    public void printErrorMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
