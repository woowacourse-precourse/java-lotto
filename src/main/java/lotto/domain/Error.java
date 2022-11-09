package lotto.domain;

import java.util.List;

/**
 * packageName : lotto.domain
 * fileName : Error
 * author : gim-yeong-geun
 * date : 2022/11/09
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/09         gim-yeong-geun          최초 생성
 */
public class Error {
    private static String coinErrorMessage = "[ERROR] 구입금액은 천원단위만 가능합니다.";
    private static String numberRangeErrorMessage = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static String numberRepeatErrorMessage = "[ERROR] 반복되는 번호가 있습니다.";

    public static boolean coinError(int coin){
        if(coin % 1000 != 0){
            System.out.println(coinErrorMessage);
            throw new IllegalArgumentException();
        }
        return false;
    }
    public static boolean numberRepeatError(List<String> lottoNumber){

    }
    public static boolean numberRangeError(List<String> lottoNumber){

    }
}
