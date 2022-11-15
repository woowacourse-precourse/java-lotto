package lotto.View;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 *  LottoManager 가 동작되는데 필요한 데이터를 입력 받고 출력하는 UI 클래스
 *  1. 사용자에게 로또 구입 금액 입력 받기
 *  2. 발행한 로또 번호들 오름차순으로 출력하기
 *  3. 로또 당첨 번호, 보너스 번호 입력 받기
 *  4. 로또 당첨 통계와 수익률 출력하기
 */

public class LottoManagerView {
    public static String inputUserMoney(){
        System.out.println(IOMessage.GET_LOTTO_PRICE_MESSAGE);
        return readLine();
    }
    // TODO: 구매 내역과 로또 오름차순 출력
    public static void printIssuedLotto(){

        
    }

    // TODO: 당첨번호, 보너스 번호 입력 받기
    public static void getWinningNumbers(){

    }

    // TODO: 당첨 통게 출력하기
    public static void printWinningHistory(){

    }
}
