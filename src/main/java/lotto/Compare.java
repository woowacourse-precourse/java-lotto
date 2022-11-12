package lotto;

import java.util.List;

// 로또 번호 비교
public class compareNumbers {

    public static List<Integer> userNumber;
    public static List<Integer> lottoNumber;

    public static final String FIRST_PLACE = "6개 일치 (2,000,000,000원)";
    public static final String SECOND_PLACE = "5개 일치, 보너스 볼 일치 (30,000,000원)";
    public static final String THIRD_PLACE = "5개 일치 (1,500,000원)";
    public static final String FOURTH_PLACE = "4개 일치 (50,000원)";
    public static final String FIFTH_PLACE = "3개 일치 (5,000원)";

    public compareNumbers(List<Integer> userNumber, List<Integer> lottoNumber) {
        this.userNumber = userNumber;
        this.lottoNumber = lottoNumber;
    }

    

}
