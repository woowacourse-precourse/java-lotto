package lotto;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Integer money = getMoney();
        Integer lottoCount = calculateLottoCount(money);

        String[] winNumbers = getWinNumbers();
    }



    static Integer getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();

        Integer money = Integer.valueOf(userInput);
        return money;
    }
    static String[] getWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String[] winNumbers = userInput.split(",");
        return winNumbers;
    }

    static Integer calculateLottoCount(Integer money) {

        Integer lottoPrice = 1000;
        Integer lottoCount = money / lottoPrice;

        System.out.println(lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }
}
