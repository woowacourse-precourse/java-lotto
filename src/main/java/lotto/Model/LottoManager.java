package lotto.Model;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoManager {
    private static int ticketNumber;
    public static final List<Lotto> userLotto = new ArrayList<>();
    public static final List<Integer> winnings = new ArrayList<>();
    private static int bonusNumber = 0;

    private static final String INTEGER_REGEX = "-?\\d+";
    private static final String WINNING_NUMBER_SPLIT_REGEX = ",";
    private static final int LOTTO_NUMBER_START = 1;
    private static final int LOTTO_NUMBER_END = 45;

    private static final int PRICE_PER_LOTTO_TICKET = 1000;

    public LottoManager(){
        initialize();

    }
    // TODO: 메서드
    /*
        - 사용자에게 입력 받은 금액에 따라 로또 수량을 저장하는 기능 (getUserMoney)
        - 사용자에게 수량만큼 로또 발행하는 기능 (issue)
        - 사용자에게 입력 받은 당첨 번호와 보너스 번호를 저장 (getWinningNumbers)
        - 당첨 번호와 사용자의 로또를 비교하는 기능 (compare)
            - 사용자가 발행한 각 로또가 당첨 번호와 일치하는 것이 몇 개 있는지 세는 메서드
            - 3, 4, 5, 5(보너스), 6 일치에 해당하는 것이 몇개인지 통계를 내는 메서드
        - 당첨 내역을 정산하는 기능 (calculateWinningNumbers)
            - 전체 당첨금을 계산하는 메서드
            - 전체 수익률을 계산하는 메서드
     */

    private static void validateNumber(String input) {
        if (!input.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_LOTTO_NUMBER));
        }
        int number = Integer.parseInt(input);
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
        for(String s:numbers){
            System.out.println(s);
        }

        for (String number : numbers) {
            if(validateWinningNumber(number)) {
                winnings.add(Integer.parseInt(number));
            }
        }
        for(int w:winnings){
            System.out.println(w);
        }
        if (winnings.size() != 6) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_WINNING_NUMBERS));
        }
    }

    public static void getWinningNumbers(String input) {
        validateWinningNumbers(input);
    }

    public static void getUserMoney(String userMoney) {
        if (!userMoney.matches(INTEGER_REGEX)) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_MONEY));
        }
        int money = Integer.parseInt(userMoney);
        if (money % PRICE_PER_LOTTO_TICKET != 0) {
            throw new IllegalArgumentException(String.valueOf(ErrorResponse.INVALID_LOTTO_PURCHASE_PRICE));
        }
        ticketNumber = money / PRICE_PER_LOTTO_TICKET;
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
    public static void initialize(){
        userLotto.removeAll(userLotto);
        winnings.removeAll(winnings);
    }
}
