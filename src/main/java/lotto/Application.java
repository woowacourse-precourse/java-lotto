package lotto;

import camp.nextstep.edu.missionutils.Console;

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

    public static String inputWinnerNumber() {
        String userInput = Console.readLine();
        if (!userInput.contains(",")) {
            throw new IllegalArgumentException(ErrorResponse.INPUT_WITHOUT_COMMA_ERROR.getErrorMessage());
        }

        return userInput;
    }

    public static String validateWinnerNumberSize(String userInput) {
        String[] trimmedInput = userInput.split(",");

        if (trimmedInput.length != 6) {
            throw new IllegalArgumentException(ErrorResponse.INPUT_WRONG_SIZE_ERROR.getErrorMessage());
        }

        return userInput;
    }

    public static List<Integer> convertStringWinnerNumberIntoListWinnerNumber(String userInput) {
        List<Integer> convertedNumber = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            convertedNumber.add(Integer.parseInt(String.valueOf(userInput.charAt(i))));
        }

        return convertedNumber;
    }
}
