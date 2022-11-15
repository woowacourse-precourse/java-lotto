package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String ERROR_CHECKNUM = " 숫자가 아닌 수가 존재합니다.";
    private static final String ERROR_CHECKPRICE = " 1000원 단위로 입력해 주세요.";
    private static final String ERROR_CHECKLOTTONUM =  " 1부터 45사이의 수가 아니다.";
    private static final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTOSIZE_MESSAGE = "개를 구매했습니다.";

    public static void main(String[] args) {
        Application main = new Application();

        System.out.println(START_MESSAGE);
        int price = main.checkNum(main.userInputNumber());
        int lottoNum = main.checkPrice(price);

        System.out.println(lottoNum + LOTTOSIZE_MESSAGE);
        List<List<Integer>> myLottoArr = main.lottoArr(lottoNum);

    }
    public String userInputNumber() {
        return Console.readLine();
    }

    public int checkNum(String userInputNumber) {
        try {
            return Integer.parseInt(userInputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_CHECKNUM);
        }
    }

    public int checkPrice(int price){
        if (0 < price % 1000 && price % 1000 < 1000){
            throw new IllegalArgumentException(ERROR_MESSAGE + ERROR_CHECKPRICE);
        }
        return price / 1000;
    }

    public List<List<Integer>> lottoArr(int lottoNum) {
        List<Integer> myLotto;
        List<List<Integer>> myLottoArr = new ArrayList<>();
        for (int i = 0; i < lottoNum; i++) {
            myLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            myLotto.sort(Comparator.naturalOrder());
            myLottoArr.add(myLotto);
            System.out.println(myLottoArr.get(i));
        }
        return myLottoArr;
    }


}
