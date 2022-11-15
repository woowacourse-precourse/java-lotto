package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Domain {
    private static final String INPUT_LOTTO_AMOUNT = "로또금액을 입력해 주세요.";
    private static final String ENTER = "\n";

    private static final String OUTPUT_LOTTO_PURCHASE_COUNT = "개를 구매했습니다.";

    private static final int TICKET_PRICE = 1000;
    private static final int MAX_VALUE_OF_LOTTO_NUMBER = 45;
    private static final int MIN_VALUE_OF_LOTTO_NUMBER = 1;
    private static final int LOTTO_COUNT = 6;

    private static int lottoAmount;
    private static int ticketNumbers;

    private static final List<Lotto> lottoList = new ArrayList<>();

    // TODO: 로또 금액 문장 출력 후 로또 금액을 입력 받는다.
    private static int inputLottoAmount(){
        System.out.println(INPUT_LOTTO_AMOUNT);
        return Exception.isCorrectAmount(Console.readLine());
    }

    // TODO: LOTTO_AMOUNT 변수를 초기화 한다.
    private static void initializationLottoAmount(){
        lottoAmount = inputLottoAmount();
    }

    // TODO: TICKET_NUMBERS 변수를 초기화 한다.
    private static void initializationTicketNumbers(){
        ticketNumbers = lottoAmount / TICKET_PRICE;
    }

    // TODO: lottoList를 초기화 한다.
    private static void initializationLottoList(){
        for(int i=0; i<ticketNumbers; i++)
            createLottoTicket();
    }

    // TODO: 로또 객체 생성 후 로또 번호를 랜덤으로 생성
    private static void createLottoTicket(){
        lottoList.add(new Lotto(Randoms.pickUniqueNumbersInRange(
                MIN_VALUE_OF_LOTTO_NUMBER, MAX_VALUE_OF_LOTTO_NUMBER, LOTTO_COUNT)));
    }

    // TODO: 로또 구매 개수 및 번호 출력
    public void printLottoNumbers(){
        System.out.println(ENTER + ticketNumbers + OUTPUT_LOTTO_PURCHASE_COUNT);
        for(Lotto lottoTicket : lottoList)
            System.out.println(lottoTicket.getNumbers());
    }
}
