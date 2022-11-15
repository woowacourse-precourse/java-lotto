package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    // TODO: 변수
    /*
        - 당첨 번호(winningNumbers), 보너스 번호(bonusNumber)
        - 사용자가 구입한 로또 수량 (ticketNumber)
        - 발행된 사용자의 로또 번호들을 저장 (List<Lotto> userNumbers)
     */
    private static int ticketNumber;
    private static final List<Lotto> userLotto = new ArrayList<>();
    private static final List<Integer> winnings = new ArrayList<>();
    private static int bonusNumber;

    private static final String INTEGER_REGEX = "-?\\d+";


    private static final int PRICE_PER_LOTTO_TICKET = 1000;
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
    private static void issue(){

    }
}
