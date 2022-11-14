package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int buyPrice = enterPrice();
        if(buyPrice == 0) return;


    }

    private static int enterPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        if(!validateMoney(money))
            return 0;
        return Integer.parseInt(money);
    }

    public static boolean validateMoney(String money) {
        for (int i = 0; i < money.length(); i++) {
            if (!('0' <= money.charAt(i) && money.charAt(i) <= '9')) {
                System.out.println("구입 금액이 잘못 되었습니다.");
                return false;
            }
        }
        if (Integer.parseInt(money) % 1000 != 0) {
            System.out.println("구입 금액이 잘못 되었습니다.");
            return false;
        }
        return true;
    }

    private static List<Lotto> buyLotto(int money) {
        LottoMachine lottoMachine = new LottoMachine();
        return lottoMachine.buyLotto(money);
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return Arrays.stream(Console.readLine().split(","))
                .map(n -> Integer.parseInt(n))
                .collect(Collectors.toList());
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

}
