package lotto;

import java.util.ArrayList;
import java.util.List;

// 사용자의 입력과 그에 대한 예외처리 담당
public class UserManager {

    /**
     * 로또 구매
     *
     * @return 로또 구입 금액
     */
    public static int getPrice() throws IllegalArgumentException {
        int price = 0;
        return price;
    }

    /**
     * 당첨 번호 입력
     *
     * @return 당첨 번호 List
     */
    public static List<Integer> getPredict_lottoNumber() {
        List<Integer> userPredict_lottoNumber = new ArrayList<>();
        return userPredict_lottoNumber;
    }

    /**
     * 보너스 번호 입력
     *
     * @return 보너스 번호
     */
    public static Integer getPredict_bonusLottoNumber() {
        int userPredict_bonusLottoNumber = 0;
        return userPredict_bonusLottoNumber;
    }

}
