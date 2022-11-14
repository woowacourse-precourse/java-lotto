package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    LottoView lottoView = new LottoView();

    public void run() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int NumberOfLotto = getNumberOfLotto();
            List<Lotto> lottoList = makeBunchOfLotto(NumberOfLotto);

            lottoView.printLottoList(lottoList);
        } catch (IllegalArgumentException e) {
            return ;
        }
    }

    public static String inputMoney() {
        String input;
        input = Console.readLine();
        return input;
    }

    public static void validateMoney(String input) {
        int money;
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            System.out.println("[ERROR] 금액은 숫자만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }
        money = Integer.parseInt(input);
        if (money < 1000 || money % 1000 != 0) {
            System.out.println("[ERROR] 금액은 1000원 이상이어야 하며 1000원 단위여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public int getNumberOfLotto() {
        String input = inputMoney();
        validateMoney(input);
        int money = Integer.parseInt(input);

        return money / 1000;
    }

    public Lotto makeLottoNumbers() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));

        return lotto;
    }

    public List<Lotto> makeBunchOfLotto(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottos.add(makeLottoNumbers());
        }
        return lottos;
    }

    public String[] inputWinNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        String[] result = input.split(",");

        return result;
    }
}
