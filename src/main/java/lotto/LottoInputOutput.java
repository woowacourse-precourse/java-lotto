package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import camp.nextstep.edu.missionutils.Console;

public class LottoInputOutput {

    public int getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = Console.readLine();
        int money = gameStringToInt(inputMoney);
        return money;
    }

    private int gameStringToInt(String inputMoney) {
        int money = 0;

        money = stringToInt(inputMoney);

        checkIsDevineable1000(money);

        return money;
    }

    private int stringToInt(String string) {
        int interger = 0;
        try {
            interger = Integer.parseInt(string);
        } catch (Exception e) {
            System.out.println("[ERROR] 숫자를 입력해주세요.");
            throw new NoSuchElementException();
            // throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        return interger;
    }

    private void checkIsDevineable1000(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 떨어지는 숫자를 입력해주세요.");
        }
    }

    public void printLotto(List<Lotto> buyerLotto) {
        Stream<Lotto> stream = buyerLotto.stream();
        stream.forEach(lotto -> lotto.printLotto());
    }

    public List<Integer> getWinnigLottoAndCheck() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winnigLottoString = Console.readLine();

        String[] split = winnigLottoString.split(",");

        List<Integer> winningNumbers = arrayStringToIntList(split);

        return winningNumbers;
    }

    private List<Integer> arrayStringToIntList(String[] split) {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int index = 0; index < split.length; index++) {
            String singleNumString = split[index];
            int num = stringToIntAndCheckError(winningNumbers, singleNumString);
            winningNumbers.add(num);
        }
        return winningNumbers;
    }

    private int stringToIntAndCheckError(List<Integer> winningNumbers, String string) {
        int num = stringToInt(string);

        checkNumInRange(num);

        checkDuplication(winningNumbers, num);
        return num;
    }

    private void checkNumInRange(int num) {
        if (num < 1 || num > 45)
            throw new IllegalArgumentException("[ERROR] 1~45의 범위에 있는 숫자를 입력해주세요.");
    }

    private void checkDuplication(List<Integer> winningNumbers, int num) {
        if (winningNumbers.contains(num))
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
    }

    public int getBonusNumberAndCheck(List<Integer> winningNumber) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumString = Console.readLine();
        int bonusNum = stringToIntAndCheckError(winningNumber, bonusNumString);
        return bonusNum;
    }

    public void printWinningList(Map<LottoPrize, Integer> prizeList) {
        System.out.println("당첨 통계\n---");
        LottoPrize[] prizeValues = LottoPrize.values();

        for (int i = prizeValues.length - 2; i >= 0; i--) {
            String str = prizeValues[i].getDescription();
            System.out.println(str + " - " + prizeList.get(prizeValues[i]) + "개");
        }
    }

    public void printWinningRate(int winMoney, int money) {
        DecimalFormat roundBySecond = new DecimalFormat("##.#");
        double winRate = ((double) winMoney / (double) money) * 100;

        System.out.println("총 수익률은 " + roundBySecond.format(winRate) + "%입니다.");
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

}
