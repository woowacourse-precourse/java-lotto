package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;


public class Application {
    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyString = Console.readLine();
        LottoController lottoController = new LottoController(moneyString);
        List<List<Integer>> lottoList = lottoController.makeLottoList();
        System.out.printf("\n%d개를 구매했습니다.\n", lottoController.getNum());
        for (int i = 0; i < lottoList.size(); i++) {
            System.out.println(lottoList.get(i));
        }

        System.out.println("\n당첨 번호를 입력해주세요");
        String winNumberString = Console.readLine();
        System.out.println("\n보너스 번호를 입력해주세요");
        String bonusNumString = Console.readLine();
        String str = lottoController.start(winNumberString, bonusNumString);
        System.out.println(str);
    }


}
