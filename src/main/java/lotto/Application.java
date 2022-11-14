package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            programStart();
            Integer cost = inputCost();
            Purchase purchase = new Purchase();
            purchase.lotto(cost);

            Render.purchaseLottoResultPrint(purchase.getMyLotto());

            Lotto winningNumber = inputWinningNumber();
            Integer bonus = inputBonusNumber(winningNumber);

            LottoStats lottoStats = new LottoStats();
            lottoStats.calculationStats(purchase, winningNumber, bonus);

            Render.StatsResultPrint(lottoStats.statistics(), lottoStats.getEarning());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
    public static void programStart(){
        System.out.print("구입금액을 입력해주세요.");
    }
    public static Integer inputCost() {
        return Convert.costConvert(Console.readLine());
    }
    public static Lotto inputWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Convert.winningConvert(Console.readLine());
    }
    public static Integer inputBonusNumber(Lotto winningNumber){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Convert.bonusConvert(Console.readLine(),winningNumber);
    }

}
