package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    /** 사용자에게 로또를 살 금액을 입력 요청하는 메서드 */
    public static int askMoney() throws NumberFormatException {
        System.out.println(Messages.ASK_MONEY);
        return Integer.parseInt(scanner.nextLine());
    }

    /** 복권 구매 */
    public static int inputMoney(int Money) {
        vaildMoney(Money);
        isZero(Money);
        int lotto = Money / 1000;
        return lotto;
    }

    private static List<Integer> getWinNums (String input) {
        List<Integer> winNums = new ArrayList<>();
        String[] strings = input.split(",");

        for (int i=0; i<strings.length; i++) {
            winNums.add(Integer.parseInt(strings[i].trim()));
        }
        return winNums;
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
}
