package lotto.constant;

import lotto.domain.Lotto;

import java.util.List;

public class Message {

    private static final String INPUT_USER_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_LOTTO_TICKETS_MESSAGE = "%d개를 구매했습니다.%n";
    private static final String INPUT_SERVICE_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";

    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String INPUT_ERROR_EMPTY_MESSAGE = ERROR_MESSAGE + "빈 값이 입력되었습니다. 게임을 종료합니다.";
    private static final String INPUT_ERROR_USER_MONEY_MESSAGE = ERROR_MESSAGE + "%d단위로만 입력 가능합니다. 게임을 종료합니다.%n";

    public static void printInputErrorEmpty(){
        System.out.println(INPUT_ERROR_EMPTY_MESSAGE);
    }
    public static void printInputUserMoney(){
        System.out.println(INPUT_USER_MONEY_MESSAGE);
    }

    public static void printInputErrorUserMoney(){
        System.out.printf(INPUT_ERROR_USER_MONEY_MESSAGE, Constant.LOTTO_PRICE);
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
}
