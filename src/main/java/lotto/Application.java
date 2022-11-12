package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");

            int lottoCount = getLottoCount(Console.readLine());
            System.out.println();

            System.out.println(lottoCount + "개를 구매했습니다.");

            Set<Lotto> lotteries = new HashSet<>();
            for (int i = 0; i < lottoCount; i++) {
                lotteries.add(new Lotto(getRandomUniqueNumbers()));
            }

            for (Lotto lottery : lotteries) {
                System.out.println(lottery.getLottoNumbers().toString());
            }
            System.out.println();

            System.out.println("당첨 번호를 입력해 주세요.");

            Lotto winningLotto = getWinningLotto(Console.readLine());
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int getLottoCount(String string) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 숫자 형식 또는 정수가 아닙니다.");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 양수가 아닙니다.");
        }
        if (number % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 1,000원으로 나누어떨어지지 않습니다.");
        }
        return number / 1000;
    }

    public static List<Integer> getRandomUniqueNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public static Lotto getWinningLotto(String string) throws IllegalArgumentException {
        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitString : string.split(",")) {
            winningNumbers.add(getWinningNumber(splitString));
        }
        return new Lotto(winningNumbers);
    }

    private static int getWinningNumber(String string) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 숫자 형식이 아닙니다.");
        }
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 1부터 45 사이의 수가 아닙니다.");
        }
        return number;
    }

    public static int getBonusNumber(String string) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 숫자 형식이 아닙니다.");
        }
        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 1부터 45 사이의 수가 아닙니다.");
        }
        return number;
    }
}
