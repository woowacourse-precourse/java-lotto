package lotto.constant;

import lotto.domain.Lotto;

import java.util.List;

public class Message {

    private static final String INPUT_USER_LOTTO_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_LOTTO_TICKETS_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String INPUT_SERVICE_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_SERVICE_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String START_WINNING_STATISTICS_MESSAGE = "당첨 통계\n---";

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INPUT_ERROR_HAS_CHARACTER_MESSAGE = ERROR_MESSAGE + "숫자가 아닌 수가 입력되었습니다. 게임을 종료합니다.";
    private static final String INPUT_ERROR_EMPTY_MESSAGE = ERROR_MESSAGE + "빈 값이 입력되었습니다. 게임을 종료합니다.";
    private static final String INPUT_ERROR_RANGE_OUT_MESSAGE = ERROR_MESSAGE + "%d~%d 범위로만 입력 가능합니다. 게임을 종료합니다.%n";
    private static final String INPUT_ERROR_IS_NOT_COMMA_MESSAGE = ERROR_MESSAGE + "%d개가 아닌 개수로 입력되었습니다. 게임을 종료합니다.%n";
    private static final String INPUT_ERROR_IS_DUPLICATE_MESSAGE = ERROR_MESSAGE + "%d개의 숫자 중 중복되는 숫자가 입력되었습니다. 게임을 종료합니다.%n";
    private static final String INPUT_ERROR_IS_DUPLICATE_BONUS_NUMBER_MESSAGE = ERROR_MESSAGE + "보너스 번호가 당첨 번호와 중복됩니다. 게임을 종료합니다.";
    private static final String INPUT_ERROR_USER_LOTTO_MONEY_MESSAGE = ERROR_MESSAGE + "%d단위로만 입력 가능합니다. 게임을 종료합니다.%n";

    public static void printInputErrorHasCharacter() {
        System.out.println(INPUT_ERROR_HAS_CHARACTER_MESSAGE);
    }

    public static void printInputErrorEmpty(){
        System.out.println(INPUT_ERROR_EMPTY_MESSAGE);
    }

    public static void printInputErrorIsNotComma() {
        System.out.printf(INPUT_ERROR_IS_NOT_COMMA_MESSAGE, Constant.LOTTO_SIZE);
    }

    public static void printInputErrorRangeOut(){
        System.out.printf(INPUT_ERROR_RANGE_OUT_MESSAGE, Constant.LOTTO_START_NUMBER, Constant.LOTTO_END_NUMBER);
    }

    public static void printInputErrorDuplicate(){
        System.out.printf(INPUT_ERROR_IS_DUPLICATE_MESSAGE, Constant.LOTTO_SIZE);
    }

    public static void printInputErrorDuplicateBonusNumber(){
        System.out.println(INPUT_ERROR_IS_DUPLICATE_BONUS_NUMBER_MESSAGE);
    }

    public static void printInputUserLottoMoney(){
        System.out.println(INPUT_USER_LOTTO_MONEY_MESSAGE);
    }

    public static void printInputErrorUserLottoMoney(){
        System.out.printf(INPUT_ERROR_USER_LOTTO_MONEY_MESSAGE, Constant.LOTTO_PRICE);
    }

    public static void printNumberLottoTickets(int nLottoTickets){
        System.out.printf(NUMBER_LOTTO_TICKETS_MESSAGE, nLottoTickets);
    }

    public static void printLottoTickets(List<Lotto> lottoTickets){
        for (int i=0; i< lottoTickets.size(); i++){
            System.out.println(lottoTickets.get(i).getNumbers());
        }
    }

    public static void printInputServiceWinningNumbers(){
        System.out.println(INPUT_SERVICE_WINNING_NUMBERS_MESSAGE);
    }

    public static void printInputServiceBonusNumber(){
        System.out.println(INPUT_SERVICE_BONUS_NUMBER_MESSAGE);
    }

    public static void printStartWinningStatistics(){
        System.out.println(START_WINNING_STATISTICS_MESSAGE);
    }


}
