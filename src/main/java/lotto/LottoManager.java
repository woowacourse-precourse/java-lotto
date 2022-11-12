package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private static final int LOTTO_PRICE = 1000;
    private static final String WINNING_MESSAGE_3 = "3개 일치 (5,000원) - ";
    private static final String WINNING_MESSAGE_4 = "4개 일치 (50,000원) - ";
    private static final String WINNING_MESSAGE_5 = "5개 일치 (1,500,000원) - ";
    private static final String WINNING_MESSAGE_5BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String WINNING_MESSAGE_6 = "6개 일치 (2,000,000,000원) - ";
    private static final String[] MESSAGE = {WINNING_MESSAGE_3,
            WINNING_MESSAGE_4, WINNING_MESSAGE_5,
            WINNING_MESSAGE_5BONUS, WINNING_MESSAGE_6};

    public List<Integer> GenerateLottoNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String inputLottoNumbers = Console.readLine();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : inputLottoNumbers.split(",")) {
            lottoNumbers.add(Integer.valueOf(number));
        }
        return lottoNumbers;
    }

    public int GenerateBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String inputBonusNumbers = Console.readLine();
        return Integer.parseInt(inputBonusNumbers);
    }

    public List<Integer> GenerateRandomNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public int getMoney() {
        System.out.println("구매금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        return Integer.parseInt(inputMoney);
    }

    public void sortLottoNumbers(List<Integer> lotto) {
        Collections.sort(lotto);
    }

    public List<Lotto> publishLottoForPrice(int money) {
        List<Lotto> result = new ArrayList<>();
        int numberOfLotto = money/LOTTO_PRICE;
        System.out.println("\n" + numberOfLotto + "개를 구매했습니다.");

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> newLotto = GenerateRandomNumbers();
            sortLottoNumbers(newLotto);
            System.out.println(newLotto);
            Lotto lotto = new Lotto(newLotto);
            result.add(lotto);
        }

        return result;
    }

    public void  printWinningMessage(Map<Integer, Integer> result) {
        //{0=3, 1=4, 2=1, 3=0, 4=0, 5=0, 6=0, 7=0}
        System.out.println("\n당첨 통계\n---");
        for (int i = 3; i < 8; i++) {
            System.out.println(MESSAGE[i-3] + result.get(i) + "개");
        }
    }
}
