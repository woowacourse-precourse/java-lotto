package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoKiosk {
    private final int LOTTO_PRICE = 1000;

    private String moneyInput;
    private long money;
    private long howMany;
    private List<Lotto> lottos;

    public void insertMoney() throws IllegalArgumentException{
        askHowMuch();
        moneyInserted();
        validateMoneyInput();
        chargeMoney();
        validateMoney();
    }

    void askHowMuch() {
        System.out.println(Messages.REQUEST_MONEY.message);
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
        if (this.money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.DIVIDE_DISABLE.message);
        }
    }

    long showInsertedMoney() {
        return this.money;
    }

    void calculateLottoAmount() {
        this.howMany = money / LOTTO_PRICE;
    }

    long showHowMany() {
        return this.howMany;
    }

    void showHowManyLotto() {
        System.out.println("\n" + howMany + Messages.HOW_MANY_SOLD.message);
    }

    void sellLotto() {
        calculateLottoAmount();
        showHowManyLotto();
        makeAllLotto();
        printAllLottoNumber();
    }

    List<Integer> makeUniqueSixLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    List<Integer> sortUniqueSixLottoNumbers(List<Integer> uniqueSixNumbers) {
        return uniqueSixNumbers.stream().sorted().collect(Collectors.toList());
    }

    void makeAllLotto() {
        lottos = new ArrayList<>();
        for (int i = 0; i < this.howMany; i++) {
            lottos.add(makeLotto(sortUniqueSixLottoNumbers(makeUniqueSixLottoNumbers())));
        }
    }

    Lotto makeLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    List<Lotto> showAllLotto() {
        return this.lottos.stream().map(o -> (Lotto) o).collect(Collectors.toList());
    }

    void printAllLottoNumber() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.showNumbers());
        }
    }
}
