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
    private static final int[] PROFIT = {5000, 50000, 1500000, 30000000, 2000000000};

    public List<Integer> GenerateLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputLottoNumbers = Console.readLine();
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : inputLottoNumbers.split(",")) {
            lottoNumbers.add(Integer.valueOf(number));
        }
        return lottoNumbers;
    }

    public int GenerateBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumbers = Console.readLine();
        return Integer.parseInt(inputBonusNumbers);
    }

    public List<Integer> GenerateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        return numbers;
    }

    public int getMoney() throws IllegalArgumentException {
        System.out.println("구매금액을 입력해 주세요.");
        String inputMoney = Console.readLine();

        for (int i = 0; i < inputMoney.length(); i++) {
            char charNum = inputMoney.charAt(i);

            // 숫자가 아닐 경우 예외
            int ascii = (int) charNum;
            if (ascii < 48 || ascii > 57) {
                System.out.println("[ERROR] 금액은 숫자로만 입력해 주세요.");
                throw new IllegalArgumentException();
            }
        }

        int money = Integer.parseInt(inputMoney);

        if (money%1000 != 0) {
            System.out.println("[ERROR] 금액은 1000으로 나누어 떨어져야 합니다.");
            throw new IllegalArgumentException();
        }

        return money;

    }

    public void sortLottoNumbers(List<Integer> lotto) {
        Collections.sort(lotto);
    }

    public List<Lotto> publishLottoForPrice(int money) {
        List<Lotto> result = new ArrayList<>();
        int numberOfLotto = money/LOTTO_PRICE;
        System.out.println(numberOfLotto + "개를 구매했습니다.");

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

    public void printProfit(int userMoney, Map<Integer, Integer> result) {
        //{0=3, 1=4, 2=1, 3=0, 4=0, 5=0, 6=0, 7=0}
        int totalProfit = 0;
        for (int i = 3; i < 8; i++) {
            totalProfit += PROFIT[i-3] * result.get(i);
        }
        double totalRate = ((double) totalProfit/userMoney)*100;
        System.out.printf("총 수익률은 %.1f%%입니다.", totalRate);
    }
}
