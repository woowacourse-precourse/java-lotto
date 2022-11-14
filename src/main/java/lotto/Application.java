package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Application {
    static HashMap<LottoRank, Integer> winningHistory = new HashMap<>();
    static int inputPrice = 0;

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            List<Lotto> myLottoTickets = buyLotto();
            printMyLottoTickets(myLottoTickets);

            Lotto winnerNumber = new Lotto(inputWinnerNumber());
            System.out.println(winnerNumber.getNumbers());
            System.out.println();

            int bonusNumber = inputBonusNumber();

            saveLottoRankByTicket(winnerNumber, myLottoTickets, bonusNumber);

            printLottoTicketHistory();

            printWinningsOutOfBuyingPrice(inputPrice);
        } catch (LottoException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int checkUserInputCondition(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new LottoException(ErrorResponse.INPUT_CONTAINS_CHAR_ERROR);
            }
        }

        return Integer.parseInt(input);
    }

    public static int convertBuyingPriceIntoTicketAmount(int buyingPrice) {
        if (buyingPrice % 1000 != 0) {
            throw new LottoException(ErrorResponse.INPUT_BUYING_RANGE_ERROR);
        }

        return buyingPrice / 1000;
    }

    public static List<Lotto> getLottoTickets(int ticketAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketAmount; i++) {
            List<Integer> randomLottoNumber = Lotto.createRandomLottoNumber();
            Lotto ticket = new Lotto(randomLottoNumber);
            lottoTickets.add(ticket);
        }

        return lottoTickets;
    }

    private static List<Lotto> buyLotto() {
        String userInput = Console.readLine();
        System.out.println();
        int buyingPrice = checkUserInputCondition(userInput);

        inputPrice = buyingPrice;

        int ticketAmount = convertBuyingPriceIntoTicketAmount(buyingPrice);
        List<Lotto> lottoTickets = getLottoTickets(ticketAmount);

        return lottoTickets;
    }

    private static void printMyLottoTickets(List<Lotto> lottoTickets) {
        int size = lottoTickets.size();
        System.out.println(size + "개를 구매했습니다.");
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
        System.out.println();
    }

    public static String validateWinnerNumberContainsComma(String userInput) {
        if (!userInput.contains(",")) {
            throw new LottoException(ErrorResponse.INPUT_WITHOUT_COMMA_ERROR);
        }

        return userInput;
    }

    public static String validateWinnerNumberSize(String userInput) {
        String[] trimmedInput = userInput.split(",");

        if (trimmedInput.length != 6) {
            throw new LottoException(ErrorResponse.INPUT_WRONG_SIZE_ERROR);
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
                throw new LottoException(ErrorResponse.INPUT_LOTTO_RANGE_ERROR);
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
            throw new LottoException(ErrorResponse.INPUT_LOTTO_RANGE_ERROR);
        }

        return bonusNumber;
    }

    private static int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInput = Console.readLine();

        int bonusNumber = checkUserInputCondition(userInput);

        return bonusNumber;
    }

    private static void initWinningHistory() {
        for (LottoRank value : LottoRank.values()) {
            winningHistory.put(value, 0);
        }
    }

    public static LottoRank countCorrespondingNumbers(Lotto winnerNumber, Lotto checkTargetNumber, int bonusNumber) {
        int correspondingNumber = 0;
        int correspondingBonusNumber = 0;

        for (Integer targetNumber : checkTargetNumber.getNumbers()) {
            if (winnerNumber.getNumbers().contains(targetNumber)) {
                correspondingNumber++;
            }
        }

        if (checkTargetNumber.getNumbers().contains(bonusNumber)) {
            correspondingBonusNumber++;
        }

        return LottoRank.getRank(correspondingNumber, correspondingBonusNumber);
    }

    public static void saveLottoRankByTicket(Lotto winnerNumber, List<Lotto> lottoTickets, int bonusNumber) {
        initWinningHistory();
        for (Lotto lottoTicket : lottoTickets) {
            LottoRank lottoRank = countCorrespondingNumbers(winnerNumber, lottoTicket, bonusNumber);
            addToHistory(lottoRank);
        }
    }

    private static void addToHistory(LottoRank lottoRank) {
        Integer prevHistory = winningHistory.get(lottoRank);
        winningHistory.put(lottoRank, prevHistory + 1);
    }

    private static void printLottoTicketHistory() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(LottoRank.FIFTH_PLACE.getMessage() + winningHistory.get(LottoRank.FIFTH_PLACE) + "개");
        System.out.println(LottoRank.FOURTH_PLACE.getMessage() + winningHistory.get(LottoRank.FOURTH_PLACE) + "개");
        System.out.println(LottoRank.THIRD_PLACE.getMessage() + winningHistory.get(LottoRank.THIRD_PLACE) + "개");
        System.out.println(LottoRank.SECOND_PLACE.getMessage() + winningHistory.get(LottoRank.SECOND_PLACE) + "개");
        System.out.println(LottoRank.FIRST_PLACE.getMessage() + winningHistory.get(LottoRank.FIRST_PLACE) + "개");
    }

    private static void printWinningsOutOfBuyingPrice(int buyingPrice) {
        int sumOfWinnings = getTotalWinnings();

        Double winningsRate = (Double.valueOf(sumOfWinnings) / Double.valueOf(buyingPrice)) * 100.0f;

        String trimmedWinningsRate = String.format("%.1f", winningsRate);

        System.out.println("총 수익률은 " + trimmedWinningsRate + "%입니다.");
    }

    private static int getTotalWinnings() {
        int totalWinnings = 0;
        for (LottoRank lottoRank : winningHistory.keySet()) {
            if (!lottoRank.equals(LottoRank.NOT_IN_PLACE) && winningHistory.get(lottoRank) != 0) {
                totalWinnings += lottoRank.getWinnings();
            }
        }

        return totalWinnings;
    }
}
