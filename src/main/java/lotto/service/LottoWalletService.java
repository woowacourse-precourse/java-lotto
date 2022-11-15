package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;


public class LottoWalletService {

    public static int payment = 0;

    public List<Lotto> putLottoInWallet() {
        int numberOfLottoToMake = getNumberOfLottoToMake();
        List<Lotto> wallet = new ArrayList<>();

        for (int i = 0; i < numberOfLottoToMake; i++) {
            List<Integer> numbers = newLottoNumber();
            Lotto newLotto = new Lotto(numbers);
            wallet.add(newLotto);
        }
        return wallet;
    }

    private List<Integer> newLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    private int getNumberOfLottoToMake() {

        try {
            getInputOfMoney();
        } catch (IllegalArgumentException ignored) {
        }

        int howManyLotto = payment / Lotto.PRICE;

        System.out.println(howManyLotto + "개를 구매했습니다.");

        return howManyLotto;
    }

    private static void getInputOfMoney() throws IllegalArgumentException {

        System.out.println("구입금액을 입력해 주세요.");

        String moneyAsString = Console.readLine();

        try {
            payment = Integer.parseInt(moneyAsString);
        } catch (Exception e) {
            System.out.println("[ERROR] 구입금액은 숫자만 입력 가능합니다.");
            throw new IllegalArgumentException();
        }
        validateUnit();
    }

    private static void validateUnit() throws IllegalArgumentException {
        if (payment % Lotto.PRICE != 0) {
            System.out.println("[ERROR] 구입금액은 1000원으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }
    }
}
