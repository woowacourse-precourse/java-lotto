package lotto.Model;

import java.util.*;
import java.util.logging.Logger;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoManager {
    private static int inputMoney;
    private static int jackpot = 0;
    private static int ticketNumber;
    public static final List<Lotto> userLotto = new ArrayList<>();
    public static final List<Integer> winnings = new ArrayList<>();
    private static int bonusNumber;

    public static final Map<Integer, Integer> winningHistory = new HashMap<>();

    private static final String INTEGER_REGEX = "-?\\d+";
    private static final String WINNING_NUMBER_SPLIT_REGEX = ",";
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;

    private static final int LOTTO_SIZE = 6;
    private static final int PRICE_PER_LOTTO_TICKET = 1000;

    public LottoManager(){
        initialize();
    }

    public String getEarningRate() {
        double rate = jackpot / (double) inputMoney * 100.f;
        return String.valueOf(rate);
    }

    public List<Integer> getWinningRecords() {
        List<Integer> record = new ArrayList<>();
        for (int index = 3; index < LOTTO_SIZE + 2; index++) {
            record.add(winningHistory.get(index));
        }
        return record;
    }

    private int getMatchingCount(Lotto lotto) {
        int count = 0;
        for (int index = 0; index < LOTTO_SIZE; index++) {
            if (winnings.contains(lotto.getNumber(index))) {
                count++;
            }
        }
        return count;
    }

    public void compare() {
        for (Lotto lotto : userLotto) {
            int count = getMatchingCount(lotto);
            if (count == 5 && winnings.contains(bonusNumber)) {
                winningHistory.put(6, winningHistory.get(6) + 1);
                jackpot += PrizeMoney.PRIZE_FOR_FIVE_MATCHING_WITH_BONUS.getMoney();
                continue;
            }
            if (count == 6) {
                winningHistory.put(7, winningHistory.get(7) + 1);
                jackpot += PrizeMoney.PRIZE_FOR_SIX_MATCHING.getMoney();
                continue;
            }
            if (count == 5) {
                winningHistory.put(5, winningHistory.get(5) + 1);
                jackpot += PrizeMoney.PRIZE_FOR_FIVE_MATCHING.getMoney();
                continue;
            }
            if (count == 4) {
                winningHistory.put(4, winningHistory.get(4) + 1);
                jackpot += PrizeMoney.PRIZE_FOR_FOUR_MATCHING.getMoney();
                continue;
            }
            if (count == 3) {
                winningHistory.put(3, winningHistory.get(3) + 1);
                jackpot += PrizeMoney.PRIZE_FOR_THREE_MATCHING.getMoney();
            }
        }
    }

    private static void validateNumber(String input) {
        int number = 0;
        try{
            number = Integer.parseInt(input);
        }catch(Exception e){
            System.out.println(ErrorResponse.INVALID_LOTTO_NUMBER);
        }
        if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_LOTTO_NUMBER_RANGE));
        }
    }
    private static void validateBonusNumber(String input) {
        validateNumber(input);
        if (winnings.contains(Integer.parseInt(input))) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_BONUS_UNIQUE_NUMBER));
        }
    }

    public static void getBonusNumber(String input) {
        validateBonusNumber(input);
        bonusNumber = Integer.parseInt(input);
    }

    private static String[] getSplitWinningNumbers(String input){
        String[] numbers = input.split(WINNING_NUMBER_SPLIT_REGEX);
        if (numbers.length != 6) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_WINNING_NUMBERS));
        }
        return numbers;
    }

    private static boolean validateWinningNumber(String number){
        validateNumber(number);
        if (winnings.contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_WINNING_UNIQUE_NUMBERS));
        }
        return true;
    }

    private static void validateWinningNumbers(String input){
        String[] numbers = getSplitWinningNumbers(input);

        for (String number : numbers) {
            if(validateWinningNumber(number)) {
                winnings.add(Integer.parseInt(number));
            }
        }

        if (winnings.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_WINNING_NUMBERS));
        }
    }

    public static void getWinningNumbers(String input) {
        validateWinningNumbers(input);
    }

    public static void getUserMoney(String userMoney) {
        try {
            inputMoney = Integer.parseInt(userMoney);
        }catch(IllegalArgumentException e){
            System.out.println(ErrorResponse.INVALID_MONEY);
        }
        if (inputMoney % PRICE_PER_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_LOTTO_PURCHASE_PRICE));
        }
        ticketNumber = inputMoney / PRICE_PER_LOTTO_TICKET;
    }

    public static int getTicketNumber(){
        return ticketNumber;
    }

    public static void issue() {
        for (int number = 0; number < ticketNumber; number++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            userLotto.add(new Lotto(lottoNumbers));
        }
    }

    public static void getIssuedLotto(){
        for(Lotto lotto: userLotto){
            System.out.println(lotto);
        }
    }
    private static void initializeHistory() {
        for (int count = 0; count < 8; count++) {
            winningHistory.put(count, 0);
        }
    }

    public static void initialize(){
        userLotto.removeAll(userLotto);
        winnings.removeAll(winnings);
        initializeHistory();

    }
}
