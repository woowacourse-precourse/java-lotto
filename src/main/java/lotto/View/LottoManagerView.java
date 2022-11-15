package lotto.View;

import lotto.Model.Lotto;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.View.IOMessage.*;

/**
 *  LottoManager 가 동작되는데 필요한 데이터를 입력 받고 출력하는 UI 클래스
 *  1. 사용자에게 로또 구입 금액 입력 받기
 *  2. 발행한 로또 번호들 오름차순으로 출력하기
 *  3. 로또 당첨 번호, 보너스 번호 입력 받기
 *  4. 로또 당첨 통계와 수익률 출력하기
 */

public class LottoManagerView {

    public static String inputBonusNumber(){
        System.out.println(GET_BONUS_NUMBER_MESSAGE);
        return readLine();
    }

    public static String inputWinningNumbers(){
        System.out.println(GET_WINNING_NUMBERS_MESSAGE);
        return readLine();
    }
    public static String inputUserMoney(){
        System.out.println(GET_LOTTO_PRICE_MESSAGE);
        return readLine();
    }

    public static void printIssuedLotto(int ticketNumber, List<Lotto> userLotto){
        System.out.println(String.valueOf(ticketNumber) + LOTTO_TICKET_NUMBER_MESSAGE);
        for(Lotto lotto: userLotto){
            System.out.println(lotto);
        }
    }

    // TODO: 당첨번호, 보너스 번호 입력 받기
    public static void getWinningNumbers(){

    }

    // TODO: 당첨 통게 출력하기
    public static void printWinningHistory(){

    }
}
