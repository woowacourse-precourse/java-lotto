package lotto;

import static lotto.Lotto.printLotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class Application {

    static double income = 0;
    static String ERROR_MESSAGE = "[ERROR] 구입금액은 숫자만 입력 가능합니다.";

    public static int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String strAmount = Console.readLine();
        for (int i = 0; i < strAmount.length(); ++i) {
            if (!Character.isDigit(strAmount.charAt(i))) {
                System.out.println(ERROR_MESSAGE);
//                throw new IllegalArgumentException(ERROR_MESSAGE);
                throw new NoSuchElementException(ERROR_MESSAGE);
            }
        }
        int amount = Integer.parseInt(strAmount);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000의 배수만 입력 가능합니다.");
        }
        return amount;
    }


    public static int printNumberOfTickets(int amount) {

        int cnt = amount / 1000;
        System.out.println(cnt + "개를 구매했습니다.");
        return cnt;
        
    }


    public static boolean isValidateNum(String s) {

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
        return true;
    }

    public static int[] enterWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String strWinningNums = Console.readLine();
        String[] tmpArr = strWinningNums.split(",");
        int[] winningNums = new int[tmpArr.length];

        for (int i = 0; i < tmpArr.length; ++i) {
            isValidateNum(tmpArr[i]);
            winningNums[i] = Integer.parseInt(tmpArr[i]);
        }

        validateLotto(winningNums);
        return winningNums;
    }


    public static boolean validateLotto(int[] winningNums) {

        List<Integer> list = new ArrayList<>();
        for (int winningNum : winningNums) {
            list.add(winningNum);
        }
        Lotto lotto = new Lotto(list);
        return true;

    }


    public static int enterBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String tmp = Console.readLine();
        for (char c : tmp.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
            }
        }
        int bonusNum = Integer.parseInt(tmp);
        List<Integer> winningNumsList = new ArrayList<>();
        if (winningNumsList.contains(bonusNum) || bonusNum < 1 || 45 < bonusNum) {
            throw new IllegalArgumentException(
                "[ERROR] 보너스 번호는 1 부터 45 사이의 숫자이며 당첨 번호와 중복될 수 없습니다.");
        }
        return bonusNum;
    }


    public static int validateBonusNum(int[] winningNums) {

        List<Integer> winningNumsList = new ArrayList<>();

        for (int winningNum : winningNums) {
            winningNumsList.add(winningNum);
        }
        int bonusNum = enterBonusNum();

        return bonusNum;
    }


    public static Lotto generateLotto() {

        List<Integer> lottoList = new ArrayList<>();
        lottoList = Randoms.pickUniqueNumbersInRange(1, 45, 6);   // 1, 45 포함
        Lotto lotto = new Lotto(lottoList); // 생성한 로또에 대해 유효성 검사
        Lotto.sortLotto(lotto);
        return lotto;

    }


    public static List<Lotto> generateAllLotto(int numberOfTickets) {

        List<Lotto> allLottoList = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; ++i) {
            Lotto lotto = generateLotto();   // 로또 랜덤으로 생성
            allLottoList.add(lotto);
            printLotto(lotto);

        }

        return allLottoList;
    }


    public static void getIncomeOfLotto(Lotto lotto, int bonusNum, int cnt) {
        if (cnt == 6) {
            income += 2000000000;
            LottoRank.SIX.setCnt(LottoRank.SIX.getCnt() + 1);
        } else if (cnt == 5 && Lotto.contains(lotto, bonusNum)) {
            income += 30000000;
            LottoRank.FIVE_WITH_BONUS.setCnt(LottoRank.FIVE_WITH_BONUS.getCnt() + 1);
        } else if (cnt == 5) {
            income += 1500000;
        } else if (cnt == 4) {
            income += 50000;
            LottoRank.FOUR.setCnt(LottoRank.FOUR.getCnt() + 1);
        } else if (cnt == 3) {
            income += 5000;
            LottoRank.THREE.setCnt(LottoRank.THREE.getCnt() + 1);
        }
    }


    public static int contLottoNum(Lotto lotto, int[] winningNums) {
        int cnt = 0;
        for (int winningNum : winningNums) {
            if (Lotto.contains(lotto, winningNum)) {
                ++cnt;
            }
        }
        return cnt;
    }


    public static double getTotalIncome(List<Lotto> allLotto, int[] winningNums, int bonusNum) {

        for (Lotto lotto : allLotto) {
            int cnt = contLottoNum(lotto, winningNums);
            getIncomeOfLotto(lotto, bonusNum, cnt);
        }
        return income;
    }


    public static void printResult(double rateOfReturn) {

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(LottoRank.THREE.getMessage() + " - " + LottoRank.THREE.getCnt() + "개");
        System.out.println(LottoRank.FOUR.getMessage() + " - " + LottoRank.FOUR.getCnt() + "개");
        System.out.println(LottoRank.FIVE.getMessage() + " - " + LottoRank.FIVE.getCnt() + "개");
        System.out.println(
            LottoRank.FIVE_WITH_BONUS.getMessage() + " - " + LottoRank.FIVE_WITH_BONUS.getCnt()
                + "개");
        System.out.println(LottoRank.SIX.getMessage() + " - " + LottoRank.SIX.getCnt() + "개");
        System.out.print("총 수익률은 ");
        System.out.printf("%.1f", rateOfReturn);
        System.out.println("%입니다.");

    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int amount = enterPurchaseAmount();
        int numberOfTickets = printNumberOfTickets(amount);
        List<Lotto> allLotto = generateAllLotto(numberOfTickets);
        int[] winningNums = enterWinningNumber();
        int bonusNum = validateBonusNum(winningNums);
        double income = getTotalIncome(allLotto, winningNums, bonusNum);
        printResult((double) (income / amount * 100));

    }
}
