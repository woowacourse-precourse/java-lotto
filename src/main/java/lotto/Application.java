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

        // 사용자에게 당첨 번호 입력받기
        String winningNumber = UserInputString.ENTERWINNINGNUMBER.getString();

        // 사용자에게 보너스 번호 입력받기
        int bonusNumber = Integer.parseInt(UserInputString.ENTERBONNUSNUMBER.getString());

        // 입력받은 당첨번호를 int형 리스트화 시키기
        List<Integer> winningNumberList = IntListOfTheReceivedWinningNumbers(winningNumber);

        // 당첨번호를 통해 lotto 객체 생성
        Lotto lotto = new Lotto(winningNumberList);

        // 사용자의 로또 번호와 당첨 번호를 비교
        List<Integer> winningStatus = CompareUserLottoNumberWithWinningNumber(lottoNumberList,bonusNumber,lotto);
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

    public static List<Integer> IntListOfTheReceivedWinningNumbers(String winningNumber){
        List<Integer> winningNumberList = new ArrayList<>();
        String[] winningNumberStringList = winningNumber.split(",");
        for (int i = 0; i < winningNumberStringList.length; i++) {
            winningNumberList.add(Integer.parseInt(winningNumberStringList[i]));
        }
        return winningNumberList;
    }

    public static List<Integer> CompareUserLottoNumberWithWinningNumber(List<List> lottoNumberList,int bonusNumber, Lotto lotto){
        List<Integer> winningStatus = new ArrayList<>();
        for(int i = 0; i < lottoNumberList.size(); i++) {
            List<Integer> lottoNumber = lottoNumberList.get(i);
            winningStatus.add(lotto.CountAfterComparison(lottoNumber,bonusNumber));
        }
        return winningStatus;
    }


}