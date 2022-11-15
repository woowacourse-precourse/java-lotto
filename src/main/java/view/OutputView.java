package view;

import domain.Lotto;
import service.Winner;

import java.util.EnumMap;
import java.util.List;

public class OutputView {
    public static void requestPurchaseAmount() {
        System.out.println(Text.REQUEST_PURCHASE_AMOUNT);
    }

    public static void noticePublishedLotto(List<Lotto> publishedLotto) {
        System.out.print("\n" + publishedLotto.size());
        System.out.println(Text.NOTICE_NUMBER_OF_LOTTO);

        publishedLotto.stream().map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void requestWinningNumbers() {
        System.out.println(Text.REQUEST_WINNING_NUMBERS);
    }

    public static void requestBonusNumber() {
        System.out.println(Text.REQUEST_BONUS_NUMBER);
    }

    public static void noticeResult(EnumMap<Winner, Integer> winners, double rateOfReturn) {
        System.out.println(Text.NOTICE_RESULT);
        StringBuilder result = new StringBuilder();

        result.append(Text.FIFTH_PLACE.getText()).append(winners.get(Winner.FIFTH_PLACE)).append(Text.COUNT.getText()).append("\n");
        result.append(Text.FOURTH_PLACE.getText()).append(winners.get(Winner.FOURTH_PLACE)).append(Text.COUNT.getText()).append("\n");
        result.append(Text.THIRD_PLACE.getText()).append(winners.get(Winner.THIRD_PLACE)).append(Text.COUNT.getText()).append("\n");
        result.append(Text.SECOND_PLACE.getText()).append(winners.get(Winner.SECOND_PLACE)).append(Text.COUNT.getText()).append("\n");
        result.append(Text.FIRST_PLACE.getText()).append(winners.get(Winner.FIRST_PLACE)).append(Text.COUNT.getText());
        result.append(Text.NOTICE_RATE_OF_RETURN).append(String.format(Text.ROUND.getText(), rateOfReturn)).append(Text.NOTICE_PERCENT);

    }
}
