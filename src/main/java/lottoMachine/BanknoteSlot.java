package lottoMachine;

import static lottoMachine.enums.Messages.ERROR_MESSAGE_PREFIX;
import static lottoMachine.enums.Messages.PRICE_UNIT_ERROR_MESSAGE;
import static lottoMachine.enums.Messages.PRICE_RANGE_ERROR_MESSAGE;
import static lottoMachine.enums.Numbers.LOTTO_PRICE;
import static lottoMachine.enums.Numbers.LOTTO_PRICE_MAX;
import static lottoMachine.enums.Numbers.LOTTO_PRICE_MIN;
import static lottoMachine.enums.Format.NUMBER_FORMAT;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class BanknoteSlot {

    private int money;

    public BanknoteSlot() {
    }

    public void receiveMoney() {
        String money = Console.readLine();
        validate(money);
        setMoney(money);
    }

    public int getMoney() {
        return money;
    }

    private void validate(String money) {
        String prefix = ERROR_MESSAGE_PREFIX.toString();
        if (!isValidateRegex(money)) {
            throw new IllegalArgumentException(prefix + PRICE_UNIT_ERROR_MESSAGE);
        }
        if (!isValidateRange(money)) {
            throw new IllegalArgumentException(prefix + PRICE_RANGE_ERROR_MESSAGE);
        }
        if (!isValidateUnit(money)) {
            throw new IllegalArgumentException(prefix + PRICE_UNIT_ERROR_MESSAGE);
        }
    }

    private boolean isValidateRegex(String money) {
        return (Pattern.matches(NUMBER_FORMAT.toString(), money));
    }

    private boolean isValidateUnit(String money) {
        int inputMoney = toInt(money);
        return inputMoney % LOTTO_PRICE.getValue() == 0;
    }

    private boolean isValidateRange(String money) {
        long moneyTemp = Long.parseLong(money);
        return moneyTemp >= LOTTO_PRICE_MIN.getValue() && moneyTemp < LOTTO_PRICE_MAX.getValue();
    }

    private void setMoney(String money) {
        this.money = toInt(money);
    }

    private int toInt(String money) {
        return Integer.parseInt(money);
    }
}
