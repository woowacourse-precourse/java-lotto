package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    static HashMap<WinningPlace, Integer> winningHistory = new HashMap<>();

    public static void main(String[] args) {
//        Skeleton code for main
        List<List<Integer>> myLottoTickets = buyLotto();
        printMyLottoTickets(myLottoTickets);

        List<Integer> winnerNumber = inputWinnerNumber();
        System.out.println(winnerNumber);

        int bonusNumber = inputBonusNumber();
    }

    public static int checkUserInputCondition(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException(ErrorResponse.INPUT_CONTAINS_CHAR_ERROR.getErrorMessage());
            }
        }

        return Integer.parseInt(input);
    }

    public static int convertBuyingPriceIntoTicketAmount(int buyingPrice) {
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

    private static List<List<Integer>> buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String userInput = Console.readLine();
        System.out.println();
        int buyingPrice = checkUserInputCondition(userInput);
        int ticketAmount = convertBuyingPriceIntoTicketAmount(buyingPrice);
        List<List<Integer>> lottoTickets = getLottoTickets(ticketAmount);

        return lottoTickets;
    }

    private static void printMyLottoTickets(List<List<Integer>> lottoTickets) {
        int size = lottoTickets.size();
        System.out.println(size + "개를 구매했습니다.");
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
        System.out.println();
    }

    public static String validateWinnerNumberContainsComma(String userInput) {
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

        String[] trimmedInput = userInput.split(",");
        for (String inputNumber : trimmedInput) {
            convertedNumber.add(Integer.parseInt(inputNumber));
        }

        return convertedNumber;
    }

    public static void validateWinnerNumberRange(List<Integer> winnerNumber) {
        for (Integer eachNumber : winnerNumber) {
            if (eachNumber < 1 || eachNumber > 45) {
                throw new IllegalArgumentException(ErrorResponse.INPUT_LOTTO_RANGE_ERROR.getErrorMessage());
            }
        }
    }

    private static List<Integer> inputWinnerNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        String commaValidated = validateWinnerNumberContainsComma(userInput);
        String sizeValidated = validateWinnerNumberSize(commaValidated);
        List<Integer> convertedWinnerNumber = convertStringWinnerNumberIntoListWinnerNumber(sizeValidated);
        validateWinnerNumberRange(convertedWinnerNumber);

        return convertedWinnerNumber;
    }

    public static int validateBonusNumberRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorResponse.INPUT_BONUS_NUMBER_RANGE_ERROR.getErrorMessage());
        }

        return bonusNumber;
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();
        int bonusNumber = checkUserInputCondition(userInput);
        bonusNumber = validateBonusNumberRange(bonusNumber);

        return bonusNumber;
    }

    public static void getWinningPlaceByTicket(List<Integer> winnerNumber, List<List<Integer>> lottoTickets, int bonusNumber) throws Exception {
        for (List<Integer> lottoTicket : lottoTickets) {
            WinningPlace winningPlace = Lotto.countCorrespondingNumbers(winnerNumber, lottoTicket, bonusNumber);
            addToHistory(winningPlace);
        }
    }

    private static void addToHistory(WinningPlace winningPlace) {
        if (!winningHistory.containsKey(winningPlace)) {
            winningHistory.put(winningPlace, 0);
        }

        Integer prevHistory = winningHistory.get(winningPlace);
        winningHistory.put(winningPlace, prevHistory + 1);
    }
}
