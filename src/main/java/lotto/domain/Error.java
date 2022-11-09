package lotto.domain;

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

    public static boolean coinError(int coin){
        if(coin % 1000 != 0){
            System.out.println(coinErrorMessage);
            throw new IllegalArgumentException();
        }
        return false;
    }
}
