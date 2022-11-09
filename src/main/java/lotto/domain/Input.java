package lotto.domain;

import camp.nextstep.edu.missionutils.Console;

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
    public static void inputCoin() {
        coin = Integer.parseInt(Console.readLine());
    }

    public static void inputNumber() {

    }
}
