package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

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
    private static int coin;
    private static int buyCount;
    private static List<Integer> lottoNumber;
    private static int lottoBonusNumber;
    private static String inputCoinString = "구입금액을 입력해 주세요.";
    private static String coinErrorMessage = "[ERROR] 구입금액은 천원단위만 가능합니다.";
    private static String inputNumberString = "당첨 번호를 입력해 주세요.";
    private static String inputBonusNumberString = "보너스 번호를 입력해 주세요.";

    public static void inputCoin() {
        System.out.println(inputCoinString);
        coin = Integer.parseInt(Console.readLine());
        // 입력받은 금액이 1000원 단위가 아닐 때 예외 처리
        coinError(coin);
        // 입력받은 금액이 로또를 몇번 살 수 있는지 리턴
        buyCount = coin / 1000;
    }

    public static void coinError(int coin) {
        if (coin % 1000 != 0) {
            System.out.println(coinErrorMessage);
            throw new IllegalArgumentException();
        }
    }

    public static void inputWinningNumber() {
        System.out.println(inputNumberString);
        // 당첨 번호를 입력 받음. (,)를 기준으로 구분 후 lottoNumber add
        for (String item : Console.readLine().split(",")) {
            lottoNumber.add(Integer.parseInt(item));
        }
    }

    public static void inputBonusNumber() {
        System.out.println(inputBonusNumberString);
        // 보너스 번호를 입력 받음
        lottoBonusNumber = Integer.parseInt(Console.readLine());
    }
}
