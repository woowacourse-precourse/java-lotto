package lotto.domain.validator;

import java.util.List;
import lotto.domain.model.request.MoneyRequest;

public class RequestValidator {
    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int LOTTO_SIZE = 6;
    private static final int MONEY_UNIT = 1000;


    public static void moneyValidation(MoneyRequest moneyRequest) {
        int money = moneyRequest.getMoney();
        if (isNotEnough(money)) {
            throw new IllegalArgumentException("최소 구매금액은 1000원 입니다.");
        }
        if (isThousandOneUnit(money)) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    private static boolean isNotEnough(int money) {
        return Math.floorDiv(money, MONEY_UNIT) == 0;
    }

    private static boolean isThousandOneUnit(int money) {
        return Math.floorMod(money, MONEY_UNIT) != 0;
    }

    public static void lottoValidation(List<Integer> numbers) {

    }

    public static void numberValidation() {

    }

    private static void isDuplicate() {

    }

}
