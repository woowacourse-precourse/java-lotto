package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        lottoStart();

        int numberLotto = valueMoney();


    }

    public static void lottoStart() {
        System.out.println("구매금액을 입력해 주세요.");
    }

    public static int valueMoney() {
        int money = 0;

        try {

            money = Integer.parseInt(Console.readLine());

        } catch (IllegalArgumentException e) {

            System.out.println("[ERROR] 숫자 입력!");
        }


        return buyLotto(money);
    }

    public static int buyLotto(int money) {

        return money / 1000;
    }

    public static void validMoney(int money) {
        if (money % 1000 > 0) {

            System.out.println("[ERROR] 1,000단위의 수를 입력하세요");

            throw new IllegalArgumentException("[ERROR] 1,000단위의 수를 입력하세요");
        }

    }
}



