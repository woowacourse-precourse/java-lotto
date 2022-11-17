package lotto;

import java.util.List;

public class Application {
    private static int inPayment;
    private static List<Integer> inLottoNum;
    private static List<Integer> lottoNum;
    private static int inBonusNum;
    private static int bonusNum;
    private static double yield;

    public static void main(String[] args) {
        try {
            // 구입 금액 입력
            inPayment = Input.inputPayment();

            // 구입 내역 출력
            Purchase purchase = new Purchase(inPayment);
            Print.printPurchase(purchase.ticketAmount, purchase.ticketList);

            // 당첨 번호 입력
            inLottoNum = Input.inputLottoNumbers();
            Lotto lotto = new Lotto(inLottoNum);
            lottoNum = lotto.getLottoNumbers();

            // 보너스 번호 입력
            inBonusNum = Input.inputBonusNumber();
            Bonus bonus = new Bonus(inBonusNum, lottoNum);
            bonusNum = bonus.getBonusNumber();
            
            // 당첨 결과 계산 및 통계 출력
            Result result = new Result(purchase.ticketList, lottoNum, bonusNum);
            yield = Yield.getYield(purchase.payment, result.totalPrize);
            Print.printResult(result.rankResults, yield);

        } catch (IllegalArgumentException e) {
            System.out.println("\n[ERROR] " + e.getMessage());
            // throw e;
        } 
    }
}
