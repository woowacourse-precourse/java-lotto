package lotto.client;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.InvalidInputMessage;
import lotto.Lotto;
import lotto.LottoNumber;

public class ConsoleUserInterface {

    private final static String MSG_REQUEST_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private final static String MSG_SHOW_PURCHASE_AMOUNT = "개를 구매했습니다.";

    public ConsoleUserInterface() {
    }

    protected void output(String message) {
        System.out.println(message);
    }

    protected String input() {
        String inputLine;
        try {
            inputLine = Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT + InvalidInputMessage.ERR_EMPTY_INPUT
            );
        }
        return inputLine;
    }

    public int requestPurchaseAmount() {
        output(MSG_REQUEST_PURCHASE_AMOUNT);
        String input = input();
        validatePurchasingAmount(input);
        return Integer.parseInt(input);
    }

    private void validateAs_JavaInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT + InvalidInputMessage.ERR_NOT_JAVA_INTEGER
            );
        }
    }

    private void validatePurchasingAmount(String input) {
        validateAs_JavaInteger(input);
        if (Integer.parseInt(input) % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(
                    InvalidInputMessage.ERR_DEFAULT + InvalidInputMessage.ERR_MONEY_UNIT
            );
        }
    }

    public void showPurchasedResult(List<Lotto> lottos) {
        output(lottos.size() + MSG_SHOW_PURCHASE_AMOUNT);
        for (Lotto lotto : lottos) {
            showPurchasedLotto(lotto);
        }
    }

    private void showPurchasedLotto(Lotto lotto) {
        List<Integer> convertedNumbers = lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
        output(convertedNumbers.toString());
    }
}
