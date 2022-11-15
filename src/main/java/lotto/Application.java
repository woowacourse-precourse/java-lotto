package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        /* 상수 또는 클래스 변수 */
        ComparingMachine comparingMachine = new ComparingMachine();
        RateCalculator rateCalculator = new RateCalculator();
        NumberGenerator numberGenerator = new NumberGenerator();
        Map<Integer, Integer> result = comparingMachine.getResult();
        List<Integer> winningNumber;
        PurchasingLottoList purchasingLottoList;
        Lotto lotto;
        Message message = null;

        /* 인스턴스 변수 */
        int money = 0;
        int bonusNumber = 0;
        int totalWinningMoney = 0;
        double rateOfReturn = 0;
        String inputData = "";

        /* 생성자 및 메서드 */
        //로또 구입 금액
        try {
            System.out.println(message.INPUT_MONEY.getMessage());
            inputData = Console.readLine();
            comparingMachine.checkValidateNumber(inputData);

            money = Integer.parseInt(inputData);
            purchasingLottoList = new PurchasingLottoList(money);

            //로또 구매 갯수
            System.out.println();
            System.out.println(purchasingLottoList.getNumberOfTicket() + message.BUY_SOME.getMessage());

            //로또 번호 목록
            for (List<Integer> LottoList : purchasingLottoList.getLottoList()) {
                System.out.println(LottoList);
            }

            //당첨 번호 입력
            System.out.println(message.INPUT_WINNING_NUMBER.getMessage());
            winningNumber = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            lotto = new Lotto(winningNumber);
            System.out.println();

            //보너스 번호 입력
            System.out.println(Message.INPUT_BONUS_NUMBER.getMessage());
            bonusNumber = Integer.parseInt(Console.readLine());
            System.out.println();

            //로또번호 및 보너스 번호 일치여부 확인
            comparingMachine.countContainNumber(winningNumber, purchasingLottoList.getLottoList());
            comparingMachine.countContainBonusNumber(bonusNumber, purchasingLottoList.getLottoList());
            comparingMachine.countWinResult();

            //당첨 통계 출력
            System.out.println(message.WIN_RATE.getMessage());
            System.out.println(message.LINE.getMessage());

            System.out.println(message.CORRECT_THIRD.getMessage() + result.get(5000) + message.UNIT.getMessage());
            System.out.println(message.CORRECT_FOURTH.getMessage() + result.get(50000) + message.UNIT.getMessage());
            System.out.println(message.CORRECT_FIFTH.getMessage() + result.get(1500000) + message.UNIT.getMessage());
            System.out.println(message.CORRECT_FIFTH_BONUS.getMessage() + result.get(30000000) + message.UNIT.getMessage());
            System.out.println(message.CORRECT_SIXTH.getMessage() + result.get(2000000000) + message.UNIT.getMessage());

            //수익률 출력
            totalWinningMoney = rateCalculator.calculateWinningMoney(result);
            rateOfReturn = rateCalculator.calculateReturnOfRate(money, totalWinningMoney);
            System.out.println(message.RETURN_OF_RATE.getMessage() + rateOfReturn + message.PERCENTAGE.getMessage());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
