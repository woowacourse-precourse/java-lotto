package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        User user = new User();
        user.inputMoney();
        int money = user.getMoney();
        Lotto winningLotto = inputLottoNumber();
        int bonus = inputBonusNumber(winningLotto);
        List<Integer> winningInfo;

        List<Lotto> issuedLotto = issueLotto(money);
        printIssuedLotto(issuedLotto);

        winningInfo = checkWinnings(issuedLotto, winningLotto, bonus);
        printWinnings(winningInfo);
        printYield(winningInfo, money);

    }

    public static Lotto inputLottoNumber() {
        String inputNumberString = Console.readLine();
        String[] numbers = inputNumberString.split(",");
        Lotto lotto;
        boolean inputLottoError = false;
        try {
            lotto = createLotto(numbers);
        } catch (Exception e) {
            inputLottoError = true;
            throw new IllegalArgumentException();
        } finally {
            if (inputLottoError) {
                System.out.println("[ERROR] 잘못된 로또번호 입력");
            }
        }
        return lotto;
    }

    public static Lotto createLotto(String[] numbers) throws IllegalArgumentException {
        List<Integer> lottoList = new ArrayList<>();
        Lotto lotto;
        try {
            for (String s : numbers) {
                lottoList.add(Integer.parseInt(s));
            }
            lottoList.sort(Comparator.naturalOrder());
            lotto = new Lotto(lottoList);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return lotto;
    }

    public static int inputBonusNumber(Lotto lotto) {
        String inputBonus = Console.readLine();
        int bonus;
        boolean inputBonusError = false;
        try {
            bonus = Integer.parseInt(inputBonus);
            lotto.checkBonusExists(bonus);
        } catch (Exception e) {
            inputBonusError = true;
            throw new IllegalArgumentException();
        } finally {
            if (inputBonusError) {
                System.out.println("[ERROR] 잘못된 보너스 번호");
            }
        }
        return bonus;
    }

    public static List<Lotto> issueLotto(int money) {
        int numberOfLotto = money / 1000;
        System.out.println(numberOfLotto + "개를 구매했습니다.");

        return createNewLotto(numberOfLotto);
    }

    public static List<Lotto> createNewLotto(int numberOfLotto) {
        List<Lotto> issuedLotto = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> newLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto newLotto = new Lotto(newLottoNumber);
            issuedLotto.add(newLotto);
        }
        return issuedLotto;
    }

    public static void printIssuedLotto(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            lotto.printLotto();
        }
    }

    public static void printWinnings(List<Integer> winningInfo) {
        System.out.println("3개 일치 (5,000원) - " + winningInfo.get(0) + "개");
        System.out.println("4개 일치 (50,000원) - " + winningInfo.get(1) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningInfo.get(2) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningInfo.get(3) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningInfo.get(4) + "개");

    }

    public static List<Integer> checkWinnings(List<Lotto> issuedLotto, Lotto lotto, int bonus) {
        List<Integer> winningInfo = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            winningInfo.add(0);
        }
        for (Lotto currentLotto : issuedLotto) {
            int winningIndex;
            winningIndex = computeWinningIndex(currentLotto, lotto, bonus);
            if (winningIndex != -1) {
                int currentCount = winningInfo.get(winningIndex);
                winningInfo.set(winningIndex, currentCount + 1);
            }
        }


        return winningInfo;
    }

    private static int computeWinningIndex(Lotto currentLotto, Lotto lotto, int bonus) {

        int winningCount = 0;
        boolean bonusFlag = false;
        for (int lottoNumber : currentLotto.getNumbers()) {
            if (lotto.getNumbers().contains(lottoNumber)) {
                winningCount++;
            }
            if (lottoNumber == bonus) {
                bonusFlag = true;
            }
        }
        return generateWinningCount(winningCount, bonusFlag);
    }

    public static int generateWinningCount(int winningCount, boolean bonusFlag) {
        if (winningCount == 3) {
            return 0;
        }
        if (winningCount == 4) {
            return 1;
        }
        if (winningCount == 5 && !bonusFlag) {
            return 2;
        }
        if (winningCount == 5) {
            return 3;
        }
        if (winningCount == 6) {
            return 4;
        }
        return -1;
    }

    public static void printYield(List<Integer> winningInfo, int money) {
        float profit;
        profit = winningInfo.get(0)*5000;
        profit += winningInfo.get(1)*50000;
        profit += winningInfo.get(2)*1500000;
        profit += winningInfo.get(3)*30000000;
        profit += winningInfo.get(4)*2000000000;
        System.out.println("총 수익률은 "+ (profit/money)*100 + "%입니다.");
    }

}
