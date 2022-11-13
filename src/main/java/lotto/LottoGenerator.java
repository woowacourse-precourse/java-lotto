package lotto;

import static lotto.Validator.validateInputMoney;
import static lotto.Validator.validateInteger;
import static lotto.Validator.validateMaxInputMoney;
import static lotto.Validator.validateNegativePrice;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoGenerator {
    private static final int MIN_LOTTO_NUM = 1;
    private static final int MAX_LOTTO_NUM = 45;
    private static final int LOTTO_NUM_LENGTH = 6;
    public static List<Integer> oneLottoNum = new ArrayList<>();
    public static List<List> myLottoNumbers = new ArrayList<>(); // 로또 번호들 List

    // 구입한 개수만큼 로또 생성
    public static List<List> myLottoNumber() {
        for (int i = 0; i < LottoInput.numberOfLotto; i++) {
            oneLottoNum = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUM, MAX_LOTTO_NUM, LOTTO_NUM_LENGTH);
            Collections.sort(oneLottoNum);
            myLottoNumbers.add(oneLottoNum);
        }
        for (int i = 0; i < myLottoNumbers.size(); i++) {
            System.out.println(myLottoNumbers.get(i));
        }
        return myLottoNumbers;
    }


}

