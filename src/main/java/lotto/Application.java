package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        programStart();
        Integer cost = inputCost();
        Purchase purchase = new Purchase();
        purchase.lotto(cost);

        Render.purchaseLottoResultPrint(purchase.getMyLotto());

        Lotto winningNumber = inputWinningNumber();

    }
    public static void programStart(){
        System.out.print("구입금액을 입력해주세요.");
    }
    public static Integer inputCost() {
        return Convert.costConvert(Console.readLine());
    }
    public static Lotto inputWinningNumber(){
        return Convert.winningConvert(Console.readLine());
    }


}
