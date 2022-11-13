package lottoMachine.device;

import static lottoMachine.enums.Messages.BONUS_NUMBER_COUNT_ERROR_MESSAGE;
import static lottoMachine.enums.Messages.ERROR_MESSAGE_PREFIX;
import static lottoMachine.enums.Messages.LOTTO_NUMBER_COUNT_ERROR_MESSAGE;
import static lottoMachine.enums.Messages.NUMBER_RANGE_ERROR_MESSAGE;
import static lottoMachine.enums.Messages.RECEIVE_BONUS_NUMBER_MESSAGE;
import static lottoMachine.enums.Messages.RECEIVE_PRICE_MESSAGE;
import static lottoMachine.enums.Messages.RECEIVE_WINNING_NUMBER_MESSAGE;
import static lottoMachine.enums.Messages.RESULT_OF_PURCHASE_MESSAGE;
import static lottoMachine.enums.Messages.WINNING_NUMBER_FORMAT_ERROR_MESSAGE;
import static lottoMachine.enums.Numbers.LOTTO_NUMBER_END;
import static lottoMachine.enums.Numbers.LOTTO_NUMBER_START;
import static lottoMachine.enums.Numbers.WINNING_NUMBER_SIZE;
import static lottoMachine.enums.Regex.NUMBER_REGEX;
import static lottoMachine.enums.Regex.WINNING_NUMBER_REGEX;
import static lottoMachine.enums.Separator.WINNING_NUMBER_SEPARATOR;

import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lotto.Lotto;

public class LottoMachineDevices implements LottoMachineOutputDevice, LottoMachineInputDevice {

    private List<Lotto> lottoTickets;
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoMachineDevices() {
        winningNumbers = new ArrayList<>();
    }

    public void setLottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    @Override
    public void printReceivePriceMessage() {
        System.out.println(RECEIVE_PRICE_MESSAGE);
    }

    @Override
    public void printPurchaseAmount() {
        String format = MessageFormat.format(RESULT_OF_PURCHASE_MESSAGE.toString(),
                lottoTickets.size());
        System.out.println(format);
    }

    @Override
    public void printLottoTickets() {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printReceiveWinningNumberMessage() {
        System.out.println(RECEIVE_WINNING_NUMBER_MESSAGE);
    }

    @Override
    public void printReceiveBonusNumberMessage() {
        System.out.println(RECEIVE_BONUS_NUMBER_MESSAGE);
    }

    @Override
    public void receiveWinningNumber() {
        String winningNumber = Console.readLine();
        setWinningNumbers(winningNumber);
    }

    @Override
    public void receiveBonusNumber() {
        String bonusNumber = Console.readLine();
        setBonusNumber(bonusNumber);
    }

    private void setBonusNumber(String bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = toInt(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber) {
        String prefix = ERROR_MESSAGE_PREFIX.toString();
        if (!isValidateBonusNumberFormat(bonusNumber)) {
            throw new IllegalArgumentException(prefix + BONUS_NUMBER_COUNT_ERROR_MESSAGE);
        }
        if (!isValidateNumber(toInt(bonusNumber))) {
            throw new IllegalArgumentException(prefix + NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isValidateBonusNumberFormat(String bonusNumber) {
        return Pattern.matches(NUMBER_REGEX.toString(), bonusNumber);
    }

    private void setWinningNumbers(String winningNumber) {
        validateWinningNumber(winningNumber);
        String[] numbers = winningNumber.split(WINNING_NUMBER_SEPARATOR.toString());
        for (String number : numbers) {
            int lottoNumber = toInt(number);
            winningNumbers.add(lottoNumber);
        }
    }

    private void validateWinningNumber(String winningNumber) {
        String prefix = ERROR_MESSAGE_PREFIX.toString();
        if (!isValidateWinningNumberFormat(winningNumber)) {
            throw new IllegalArgumentException(prefix + WINNING_NUMBER_FORMAT_ERROR_MESSAGE);
        }
        if (containDuplicatedNumber(winningNumber)) {
            throw new IllegalArgumentException(prefix + LOTTO_NUMBER_COUNT_ERROR_MESSAGE);
        }
        if (!isValidateRangeOfNumbers(winningNumber)) {
            throw new IllegalArgumentException(prefix + NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isValidateWinningNumberFormat(String winningNumber) {
        return Pattern.matches(WINNING_NUMBER_REGEX.toString(), winningNumber);
    }

    private boolean containDuplicatedNumber(String winningNumber) {
        String[] numbers = winningNumber.split(WINNING_NUMBER_SEPARATOR.toString());
        Set<String> checkSize = new HashSet<>(Arrays.asList(numbers));
        return checkSize.size() != WINNING_NUMBER_SIZE.getValue();
    }

    private boolean isValidateRangeOfNumbers(String winningNumber) {
        for (String number : winningNumber.split(WINNING_NUMBER_SEPARATOR.toString())) {
            if (!isValidateNumber(toInt(number))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidateNumber(int number) {
        return number >= LOTTO_NUMBER_START.getValue() && number <= LOTTO_NUMBER_END.getValue();
    }

    private int toInt(String number) {
        return Integer.parseInt(number);
    }
}
