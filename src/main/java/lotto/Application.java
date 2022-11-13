package lotto;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        int userPrice = Integer.parseInt(Console.readLine());

        Buy userBuy = new Buy(userPrice);
        userBuy.printRandomLotto();

        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
