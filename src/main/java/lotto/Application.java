package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String lotto = getLotto();
        if (lotto.equals("ERROR")) {
            return;
        }
        Integer price = Integer.valueOf(lotto);

        List<Integer> nums = getNums();

        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNum = Integer.getInteger(Console.readLine());
    }

    public static String getLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String price = Console.readLine();
        try {
            Integer.valueOf(price);
        } catch (Exception e) {
            System.out.println("[ERROR] 숫자 변환이 불가능한 경우");
            return "ERROR";
//            throw new IllegalArgumentException("[ERROR] 숫자 변환이 불가능한 경우");
        }
        if (Integer.valueOf(price)%1000 != 0) {
            System.out.println("[ERROR] 1000으로 나누어 떨어지지 않는 경우");
            return "ERROR";
//            throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지지 않는 경우");
        }
        return price;
    }

    public static List<Integer> getNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNums = Console.readLine();
        List<Integer> nums = new ArrayList<>();
        while (winningNums.contains(",")) {
            String substring = winningNums.substring(0, winningNums.indexOf(","));
            nums.add(Integer.valueOf(substring));
            winningNums = winningNums.substring(winningNums.indexOf(",") + 1, winningNums.length());
        }
        nums.add(Integer.valueOf(winningNums));
        Lotto lotto = new Lotto(nums);
        return nums;
    }
}
