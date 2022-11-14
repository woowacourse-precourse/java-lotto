package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * packageName : lotto.domain
 * fileName : Input
 * author : gim-yeong-geun
 * date : 2022/11/09
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/09         gim-yeong-geun          최초 생성
 */
public class Input {
    public static int coin;
    public static int buyCount;
    public static List<Integer> lottoNumber = new ArrayList<>();
    public static int lottoBonusNumber;
    private static String errorPattern = "^[0-9]*$";
    private final static String inputCoinString = "구입금액을 입력해 주세요.";
    private final static String inputErrorMessage = "[ERROR] 문자를 입력할 수 없습니다.";
    private final static String coinErrorMessage = "[ERROR] 구입금액은 천원단위만 가능합니다.";
    private final static String bonusNumberRangeError = "[ERROR] 보너스 번호는 1~45 사이의 번호만 입력 가능합니다.";
    private final static String bonusNumberDupleError = "[ERROR] 보너스 번호는 당첨 번호와 같을 수 없습니다.";
    private final static String inputNumberString = "당첨 번호를 입력해 주세요.";
    private final static String inputBonusNumberString = "보너스 번호를 입력해 주세요.";

    public static void inputCoin() {
        System.out.println(inputCoinString);
        String input = Console.readLine();
        // 문자를 포함하여 입력받았을 경우 예외 처리
        coinStringError(input);
        coin = Integer.parseInt(input);
        // 입력받은 금액이 1000원 단위가 아닐 때 예외 처리
        coinError(coin);
        // 입력받은 금액이 로또를 몇번 살 수 있는지 저장
        buyCount = coin / 1000;
        // 구입한 로또의 개수 출력
        System.out.println(buyCount + "개를 구매했습니다.");
    }

    public static void coinStringError(String input) {
        if (!Pattern.matches(errorPattern, input)) {
            System.out.println(inputErrorMessage);
            throw new IllegalArgumentException();
        }
    }

    public static void coinError(int coin) {
        if (coin % 1000 != 0) {
            System.out.println(coinErrorMessage);
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> inputWinningNumber() {
        System.out.println(inputNumberString);
        // 당첨 번호를 입력 받음. (,)를 기준으로 구분 후 lottoNumber add
        String inputString = Console.readLine();
        for (String item : inputString.split(",")) {
            lottoNumber.add(Integer.parseInt(item));
        }
        return lottoNumber;
    }

    public static int inputBonusNumber() {
        System.out.println(inputBonusNumberString);
        // 보너스 번호를 입력 받음
        lottoBonusNumber = Integer.parseInt(Console.readLine());
        return lottoBonusNumber;
    }

    public static void bonusRangeError(int bonusNumber) {
        if (bonusNumber < 0 || bonusNumber > 45) {
            System.out.println(bonusNumberRangeError);
            throw new IllegalArgumentException();
        }
    }

    public static void bonusDupleError(List<Integer> lottoNumber, int lottoBonusNumber) {
        if (lottoNumber.contains(lottoBonusNumber)) {
            System.out.println(bonusNumberDupleError);
            throw new IllegalArgumentException();
        }
    }
}
