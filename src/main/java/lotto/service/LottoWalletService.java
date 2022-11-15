package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Constants;
import lotto.domain.ExceptionMessage;
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

        int howManyLotto = payment / Constants.PRICE;

        System.out.println(howManyLotto + Constants.PURCHASE_QUANTITY_NOTICE);

        return howManyLotto;
    }

    private static void getInputOfMoney() throws IllegalArgumentException {

        System.out.println(Constants.INPUT_REQUEST_PAY);

        String moneyAsString = Console.readLine();

        isNumeric(moneyAsString);
        rangeCheck();
        validateUnit();
    }

    private static void rangeCheck() {
        if (payment < Constants.PRICE){
            System.out.println(ExceptionMessage.PURCHASE_RANGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void isNumeric(String moneyAsString) {
        try {
            payment = Integer.parseInt(moneyAsString);
        } catch (Exception e) {
            System.out.println(ExceptionMessage.NUMERIC.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private static void validateUnit() throws IllegalArgumentException {
        if (payment % Constants.PRICE != 0) {
            System.out.println(ExceptionMessage.DIVIDE.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
