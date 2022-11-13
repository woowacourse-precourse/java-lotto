package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // TODO: 프로그램 구현


        System.out.println("구매 금액을 입력해주세요");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        Game game = new Game();
        game.play(purchaseAmount/1000);
    }

}
