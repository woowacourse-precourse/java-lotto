package lotto.utils;

import lotto.Enum.LottoInfo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {

    public static boolean validatePurchaseAmount(String input) {
        if (!isMultipleOfThousand(input)) {
            throwException("1000원 단위의 금액을 입력해 주세요.");
        }
        if (isNumeric(input)) {
            throwException("숫자를 입력해 주세요.");
        }
        return true;
    }

    public static void validateSeperatedNumbers(String[] seperated) {
        if (isUnique(Parser.ArrayToList(seperated))) {
            throwException("중복된 번호는 입력할 수 없습니다.");
        }
        for (String s : seperated) {
            if (isNumeric(s)) {
                throwException("콤마로 구분한 숫자를 입력해 주세요.");
            }
            if (isValidRange(s)) {
                throwException(LottoInfo.START+"~"+LottoInfo.END+"사이의 번호를 입력해주세요");
            }
        }
    }

    public static void validateBonusNumber(String number, List<Integer> userNumber) {
        if (!isNumeric(number)) {
            throwException("숫자를 입력해 주세요.");
        }
        if (isValidRange(number)) {
            throwException(LottoInfo.START+"~"+LottoInfo.END+"사이의 번호를 입력해주세요");
        }
        if (!isUnique(Parser.unionUserNumber(userNumber,number))) {
            throwException("당첨번호와 중복되는 보너스 번호는 입력할 수 없습니다.");
        }
    }

    public static boolean isMultipleOfThousand(String input) {
        return Parser.StringToInt(input) % 1000 == 0 ;
    }
    public static void throwException(String message) {
        throw new IllegalArgumentException(message);
    }
    public static boolean isNumeric(String input) {
        return !input.chars()
                .allMatch(Character::isDigit);
    }
    public static boolean isValidRange(String input) {
        int intInput = Parser.StringToInt(input);
        return intInput < LottoInfo.START.getInfo() || intInput > LottoInfo.END.getInfo();
    }
    public static boolean isUnique(List<String> inputList) {
        Set<String> numberSet = new HashSet<>(inputList);
        return numberSet.size() != inputList.size();
    }
    public static boolean isValidLength(int input) {

        return true;
    }
}
