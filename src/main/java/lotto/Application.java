package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int checkInputCondition(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ErrorResponse.INPUT_CONTAINS_CHAR_ERROR.getErrorMessage());
            }
        }

        return Integer.parseInt(input);
    }

    public static int convertBuyingPriceIntoLotteries(int buyingPrice) {
        if (buyingPrice % 1000 != 0) {
            throw new IllegalArgumentException(ErrorResponse.INPUT_BUYING_RANGE_ERROR.getErrorMessage());
        }

        return buyingPrice / 1000;
    }

    public static List<List<Integer>> getLottoTickets(int ticketAmount) {
        List<List<Integer>> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketAmount; i++) {
            List<Integer> ticket = Lotto.createRandomLottoNumber();
            lottoTickets.add(ticket);
        }

        return lottoTickets;
    }
}
