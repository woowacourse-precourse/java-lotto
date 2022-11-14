package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.message.ErrorMessage;
import lotto.message.Message;

public class LottoKiosk {
    private final int LOTTO_PRICE = 1000;

    private String moneyInput;
    private long money;
    private long howMany;
    private List<Lotto> lottos;

    public void getMoney() throws IllegalArgumentException {
        askHowMuch();
        moneyInserted();
        validateMoneyInput();
        chargeMoney();
        validateMoney();
    }

    void askHowMuch() {
        System.out.println(Message.REQUEST_MONEY.message);
    }

    void moneyInserted() {
        this.moneyInput = Console.readLine();
    }

    void validateMoneyInput() {
        this.moneyInput.chars().forEach(o -> {
            if (!Character.isDigit(o)) {
                throw new IllegalArgumentException(ErrorMessage.MONEY_NOT_A_NUMBER.message);
            }
        });
    }

    void chargeMoney() {
        money = Long.parseLong(moneyInput);
    }

    void validateMoney() {
        if (this.money < 1000) {
            throw new IllegalArgumentException(ErrorMessage.MORE_THAN_THOUSAND.message);
        }
        if (this.money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVIDE_DISABLE.message);
        }
    }

    long showInsertedMoney() {
        return this.money;
    }

    void sellLotto(Customer customer) {
        calculateLottoAmount();
        showHowManyLotto();
        makeAllLotto();
        printAllLottoNumber();
        customer.getLotto(lottos);
    }

    void calculateLottoAmount() {
        this.howMany = money / LOTTO_PRICE;
    }

    void showHowManyLotto() {
        System.out.println("\n" + howMany + Message.HOW_MANY_SOLD.message);
    }

    void makeAllLotto() {
        lottos = new ArrayList<>();
        for (int i = 0; i < this.howMany; i++) {
            lottos.add(makeLotto(makeLottoNumbers()));
        }
    }

    Lotto makeLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    List<Integer> makeLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList());
    }

    void printAllLottoNumber() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.showNumbers());
        }
    }

    List<Lotto> showAllLotto() {
        return new ArrayList<>(lottos);
    }

    long showHowMany() {
        return this.howMany;
    }
}
