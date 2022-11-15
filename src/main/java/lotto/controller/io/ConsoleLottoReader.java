
package lotto.controller.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.info.Price;

import java.util.*;
import java.util.regex.Pattern;

import static lotto.domain.info.Rule.*;

public class ConsoleLottoReader implements LottoReader {
    @Override
    public int readAmount() {
        String stringAmount = Console.readLine();
        validateIsNumber(stringAmount);

        int amount = Integer.parseInt(stringAmount);
        validateAmount(amount);

        return amount;
    }

    @Override
    public Set<Integer> readLottoNumber() {
        Set<Integer> lottoNumber = splitNumber(Console.readLine());

        validateLottoNumber(lottoNumber);
        validateCount(lottoNumber);
        return lottoNumber;
    }

    @Override
    public int readBonus() {
        String stringBonus = Console.readLine();
        validateIsNumber(stringBonus);

        int bonus = Integer.parseInt(stringBonus);
        validateBonus(bonus);

        return bonus;
    }

    public Set<Integer> splitNumber(String number) {
        Set<Integer> lottoNumber = new HashSet<>();
        StringTokenizer st = new StringTokenizer(number, ",");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            validateIsNumber(token);
            lottoNumber.add(Integer.parseInt(token));
        }
        return lottoNumber;
    }

    private void validateAmount(int amount) {
        if (amount % Price.SINGLE_PRICE.getPrice() != 0) {
            String message = "[ERROR] 로또 구입 금액은 " + Price.SINGLE_PRICE.getPrice() + "원 단위여야 합니다.\"";
            throw new IllegalArgumentException(message);
        }
    }

    private void validateLottoNumber(Set<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < START_NUMBER.getNumber() || number > END_NUMBER.getNumber()) {
                String message = "[ERROR] 로또 번호는" + START_NUMBER.getNumber() + "부터" + END_NUMBER.getNumber() + "사이의 숫자여야 합니다.";
                throw new IllegalArgumentException(message);
            }
        }
    }

    private void validateBonus(int bonus) {
        if (bonus < START_NUMBER.getNumber() || bonus > END_NUMBER.getNumber()) {
            String message = "[ERROR] 보너스 번호는" + START_NUMBER.getNumber() + "부터" + END_NUMBER.getNumber() + "사이의 숫자여야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

    private void validateCount(Set<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT.getNumber()) {
            String message = "[ERROR] 로또 번호는 중복되지 않는 " + NUMBER_COUNT.getNumber() + "자리 숫자여야 합니다.";
            throw new IllegalArgumentException(message);
        }
    }

    private void validateIsNumber(String number) {
        if (!Pattern.matches("^[0-9]*$", number)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }
}