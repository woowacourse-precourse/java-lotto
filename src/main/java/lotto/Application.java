package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        programStart();
        Integer cost = Convert.costConvert(Console.readLine());

        Purchase purchase = new Purchase();
        purchase.lotto(cost);

        Render.purchaseLottoResultPrint(purchase.getMyLotto());




    }
    public static void programStart(){
        System.out.print("구입금액을 입력해주세요.");
    }
}
