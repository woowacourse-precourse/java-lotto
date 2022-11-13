package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        User user = new User();
        Lotto lotto;

        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        user.buyingLotto(input);
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNum = Console.readLine();
        lotto = new Lotto(user.choosingLottoNumber(inputLottoNum));
    }
}
