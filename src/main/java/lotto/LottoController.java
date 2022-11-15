package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static java.lang.Integer.parseInt;

public class LottoController {
    private static int number;
    private static List<List<Integer>> lottos = new java.util.ArrayList<>(Collections.emptyList());
    private static List<Integer> winNumberList = new java.util.ArrayList<>(Collections.emptyList());


    LottoController(String moneyStr) {
        this.number = moneyExceptionHandling(moneyStr);
    }

    public static int moneyExceptionHandling(String moneyString) {
        int money = 0;
        try {
            money = parseInt(moneyString);
        } catch (Exception e) {
            System.out.println("[ERROR] 금액을 다시 확인해주세요.");
            throw new NoSuchElementException("[ERROR] 금액을 다시 확인해주세요.");
        }
        if (money % 1000 != 0) {
            System.out.println("[ERROR] 금액을 1000원 단위로 입력해주세요.");
            throw new IllegalArgumentException("[ERROR] 금액을 1000원 단위로 입력해주세요.");
        }
        return money / 1000;
    }

    public static List<List<Integer>> makeLottoList() {
        for (int i = 0; i < number; i++) {
            List<Integer> newLotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(newLotto);
        }
        return lottos;
    }

    public static List<Integer> makeWinNumberList(String winNumberString) {
        winNumberList = new java.util.ArrayList<>(Collections.emptyList());
        try {
            String[] numListStr = winNumberString.split(",");
            for (int i = 0; i < numListStr.length; i++) {
                winNumberList.add(Integer.parseInt(numListStr[i]));
            }
        } catch (Exception e) {
            System.out.println("[ERROR] 당첨번호를 쉼표(,)를 사용해 구분해 입력해주세요.");
            throw new IllegalArgumentException("[ERROR] 당첨번호를 쉼표(,)를 사용해 구분해 입력해주세요.");
        }
        return winNumberList;
    }

    public static int getNum() {
        return number;
    }

    public static int bonusNumber(String bonusNumStr) {
        int bonusNumber = 0;
        try {
            bonusNumber = Integer.parseInt(bonusNumStr);
        } catch (Exception e) {
            System.out.println("[ERROR] 보너스 번호를 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        if (bonusNumber < 0 || bonusNumber > 45) {
            System.out.println("[ERROR] 보너스 번호를 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public static String printString(List<Integer> winTimes, float returnRate) {
        String returnStr = "당첨 통계\n---\n";
        String str[] = {"3개 일치 (5,000원) - ", "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - ",
                "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - "};
        for (int i = 0; i < 5; i++) {
            returnStr += str[i] + winTimes.get(i) + "개\n";
        }
        returnStr += String.format("총 수익률은 %.1f%%입니다.", returnRate);
        return returnStr;
    }

    public static String start(String winNumberString, String bonusNumString) {
        List<Integer> winNumberList = makeWinNumberList(winNumberString);
        int bonusNumber = bonusNumber(bonusNumString);
        Lotto currentLotto = new Lotto(winNumberList);
        currentLotto.setBonus(bonusNumber);
        for (int i = 0; i < number; i++) {
            currentLotto.lottoNumberCompare(lottos.get(i));
        }
        return printString(currentLotto.getWinNums(), currentLotto.getReturnRate(number));
    }
}
