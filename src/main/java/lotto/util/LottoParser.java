package lotto.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class LottoParser {

    public static int parseToMoney(String rawString) {
        int money;
        try {
            money = Integer.parseUnsignedInt(rawString);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 음수를 제외한 정수만 입력해주세요.");
        }
        return money;
    }

    public static List<Integer> parseToIntegers(String rawInput) {
        final String splitter = ",";
        StringTokenizer st = new StringTokenizer(rawInput, splitter);
        List<Integer> lotto = new ArrayList<>();
        while (st.hasMoreTokens()) {
            try {
                lotto.add(Integer.parseUnsignedInt(st.nextToken()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분된 음수를 제외한 정수만 입력해주세요.");
            }
        }
        return lotto;
    }

    public static int parseToBonumNumber(String rawInput) {
        int bonusNumber;
        try {
            bonusNumber = Integer.parseUnsignedInt(rawInput);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 음수를 제외한 정수만 입력해주세요.");
        }
        return bonusNumber;
    }
}
