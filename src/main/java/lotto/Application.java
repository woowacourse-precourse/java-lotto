package lotto;
import camp.nextstep.edu.missionutils.Randoms;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static final String ERROR_MESSAGE = "[ERROR]";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 사용자에게 구입금액 입력받기
        String purchaseAmount = UserInputString.ENTERPURCHASEAMOUNT.getString();
        int numberOfPurchases = GetUserInputOfPurchaseAmount(purchaseAmount);

        // 잘못된 입력 예외 처리
        if(numberOfPurchases == -1)
            return;

        // 발행한 로또 수량 및 번호를 출력
        List<List> lottoNumberList = LottoQuantityAndNumberOutput(numberOfPurchases);



    }

    public static int GetUserInputOfPurchaseAmount(String purchaseAmount) {
        try {
            int numberOfPurchases = Integer.parseInt(purchaseAmount) / 1000;
            System.out.println(numberOfPurchases + "개를 구매했습니다.");

            if (Integer.parseInt(purchaseAmount) % 1000 != 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "1000원 단위가 아닙니다.");
            }
            return numberOfPurchases;
        }
        catch (NumberFormatException e){
            System.out.println(ERROR_MESSAGE + "숫자가 아닙니다.");
            return -1;
        }
    }

    public static List<List> LottoQuantityAndNumberOutput(int numberOfPurchases){
        List<List> lottoNumberList = new ArrayList<>();
        for (int i = 0; i < numberOfPurchases; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumberList.add(numbers);
            System.out.println(numbers);
        }
        return lottoNumberList;
    }

}