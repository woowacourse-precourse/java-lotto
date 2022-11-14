package lotto;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User {

    private static final String INFORMATION_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INFORMATION_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";

    private int lottoCount;
    private int price;
    private final Exception exception;
    private List<List<Integer>> randomLottoNumbers;

    public User(){
        exception = new Exception();
        randomLottoNumbers = new ArrayList<>();
    }

    public void setPrice(){
        System.out.println(INFORMATION_MESSAGE);
        String strPrice = Console.readLine();
        exception.validateInteger(strPrice);
        this.price = Integer.parseInt(strPrice);
    }

    public int getPrice(){
        return this.price;
    }

    public void setLottoCount(){
        exception.validatePrice(this.price);
        this.lottoCount = price / 1000;
        System.out.println(lottoCount + INFORMATION_LOTTO_COUNT_MESSAGE);
    }

    public int getLottoCount(){
        return this.lottoCount;
    }

}
