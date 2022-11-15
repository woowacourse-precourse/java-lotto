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


        /* 인스턴스 변수 */
        int money = 0;
        int bonusNumber = 0;
        int totalWinningMoney = 0;
        double rateOfReturn = 0;
        String inputData = "";

        /* 생성자 및 메서드 */
        //로또 구입 금액
        try {
            System.out.println("구입금액을 입력해 주세요");
            inputData = Console.readLine();
            numberGenerator.checkValidateNumber(inputData);

            money = Integer.parseInt(inputData);
            purchasingLottoList = new PurchasingLottoList(money);

            //로또 구매 갯수
            System.out.println();
            System.out.println(purchasingLottoList.getNumberOfTicket() + "개를 구매했습니다.");

            //로또 번호 목록
            for (List<Integer> LottoList : purchasingLottoList.getLottoList()) {
                System.out.println(LottoList);
            }

            //당첨 번호 입력
            System.out.println("당첨 번호를 입력해 주세요.");
            winningNumber = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            lotto = new Lotto(winningNumber);
            System.out.println();

            //보너스 번호 입력
            System.out.println("보너스 번호를 입력해 주세요.");
            bonusNumber = Integer.parseInt(Console.readLine());
            System.out.println();

            //로또번호 및 보너스 번호 일치여부 확인
            comparingMachine.countContainNumber(winningNumber, purchasingLottoList.getLottoList());
            comparingMachine.countContainBonusNumber(bonusNumber, purchasingLottoList.getLottoList());
            comparingMachine.countWinResult();

            //당첨 통계 출력
            System.out.println("당첨 통계");
            System.out.println("---");

            System.out.println("3개 일치 (5,000원) - " + result.get(5000) + "개");
            System.out.println("4개 일치 (50,000원) - " + result.get(50000) + "개");
            System.out.println("5개 일치 (1,500,000원) - " + result.get(1500000) + "개");
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.get(30000000) + "개");
            System.out.println("6개 일치 (2,000,000,000원) - " + result.get(2000000000) + "개");

            //수익률 출력
            totalWinningMoney = rateCalculator.calculateWinningMoney(result);
            rateOfReturn = rateCalculator.calculateReturnOfRate(money, totalWinningMoney);
            System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
