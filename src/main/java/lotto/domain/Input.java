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
    }

    public static void inputNumber() {
        System.out.println(inputNumberString);
        for(String item:Console.readLine().split(",")){
            lottoNumber.add(item);
        }
    }
}
