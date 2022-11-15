package lotto.view;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {

    /** 사용자에게 로또를 살 금액을 입력 요청하는 메서드 */
    public static int askMoney() throws NumberFormatException {
        System.out.println(Messages.ASK_MONEY);
        return Integer.parseInt(readLine());
    }

    /** 복권 구매 */
    public static int inputMoney(int Money) {
        vaildMoney(Money);
        isZero(Money);
        int lotto = Money / 1000;
        return lotto;
    }

    /** 번호 입력 */
    public static Lotto askWinLotto() {
        System.out.println(Messages.ASK_WIN_NUMBER);
        String input = readLine();
        List<Integer> winNums = null;
        try {
            winNums = getWinNums(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_NUMBER);
        }

        // 예외사항 체크
        isVaildRange(winNums);
        isSize6(winNums);
        isDiffrent(winNums);

        return new Lotto (winNums);
    }

    /** 보너스 번호 입력 */
    public static int askBonusNum(Lotto winLotto) {
        System.out.println(Messages.ASK_BONUS_NUMBER);
        int number = getBonusNum(readLine());

        isVaildRange(number);
        isDiffrent(number, winLotto);

        return number;
    }

    private static List<Integer> getWinNums (String input) {
        List<Integer> winNums = new ArrayList<>();
        String[] strings = input.split(",");

        for (int i=0; i<strings.length; i++) {
            String string = strings[i].trim();
            winNums.add(Integer.parseInt(string));
        }
        return winNums;
    }

    public static int getBonusNum (String input) {
        int num=0;
        try {
            num = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_NUMBER);
        }
        return num;
    }

    private static void vaildMoney(int Money) {
        if (Money % 1000 != 0) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_DIVDE1000);
        }
    }

    private static void isZero(int Money) {
        if (Money == 0) {
            throw new IllegalArgumentException(Messages.ERROR_NULL);
        }
    }

    private static void isVaildRange(List<Integer> nums) {
        for (int num : nums) {
            if (num>45 || num<1) {
                throw new IllegalArgumentException(Messages.ERROR_NOT_VAILDRANGE);
            }
        }
    }

    private static void isVaildRange(int num) {
        if (num>45 || num<1) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_VAILDRANGE);
        }
    }

    private static void isSize6(List<Integer> nums) {
        if (nums.size()!=6) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_SIZE6);
        }
    }

    private static void isDiffrent(List<Integer> nums) {
        for (int i=0; i<nums.size()-1; i++) {
            List<Integer> compareNums = nums.subList(i+1,nums.size());
            if (compareNums.contains(nums.get(i))) {
                throw new IllegalArgumentException(Messages.ERROR_NOT_DIFFRENT);
            }
        }
    }

    private static void isDiffrent(int number, Lotto lotto) {
        if(lotto.getNumbers().contains(number)) {
            throw new IllegalArgumentException(Messages.ERROR_NOT_DIFFRENT_BONUS_NUMBER);
        }
    }
}
