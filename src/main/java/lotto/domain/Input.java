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
    private static String coinErrorMessage = "[ERROR] 구입금액은 천원단위만 가능합니다.";
    private static String numberRangeErrorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static String numberRepeatErrorMessage = "[ERROR] 반복되는 번호가 있습니다.";
    public static void inputCoin() {
        System.out.println(inputCoinString);
        coin = Integer.parseInt(Console.readLine());
        // 입력받은 금액이 1000원 단위가 아닐 때 예외 처리
        if(coin % 1000 != 0){
            System.out.println(coinErrorMessage);
            throw new IllegalArgumentException();
        }
    }

    public static void inputNumber() {
        System.out.println(inputNumberString);
        for(String item : Console.readLine().split(",")){
            lottoNumber.add(item);
        }
    }
}
