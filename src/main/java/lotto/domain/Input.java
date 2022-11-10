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
    private static List<String> lottoNumber;
    private static String inputCoinString = "구입금액을 입력해 주세요.";
    private static String inputNumberString = "당첨 번호를 입력해 주세요.";

    public static void inputCoin() {
        System.out.println(inputCoinString);
        coin = Integer.parseInt(Console.readLine());
        // 입력받은 금액이 1000원 단위가 아닐 때 예외 처리
        Error.coinError(coin);
    }

    public static void inputNumber() {
        System.out.println(inputNumberString);
        // 당첨 번호를 입력 받음. (,)를 기준으로 구분 후 lottoNumber add
        for(String item : Console.readLine().split(",")){
            lottoNumber.add(item);
        }
    }
}
