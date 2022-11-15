package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public enum lottoResult {
        FIRST(6), SECOND(0), THIRD(5), FOURTH(4), FIFTH(3);

        private final int score;

        lottoResult(int score) {
            this.score = score;
        }

        public int score() {
            return score;
        }
    }

    public static int validatePayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String payment = readLine();
        if (Integer.parseInt(payment) % 1000 != 0) {
            System.out.println("[ERROR] 유효한 구입금액이 아닙니다.");
            throw new IllegalArgumentException();
        }
        System.out.println();
        return Integer.parseInt(payment) / 1000;
    }

    public static void checkLottoNumber(int checkNumber) {
        if (checkNumber < 1 || checkNumber > 45) {
            System.out.println("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumbersInput = readLine();
        List<Integer> winningNumbers = Arrays.stream(winningNumbersInput.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int number: winningNumbers) {
            checkLottoNumber(number);
        }
        System.out.println();
        return winningNumbers;
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        checkLottoNumber(bonusNumber);
        System.out.println();
        return bonusNumber;
    }

    public static List<Lotto> buyLottos(int count) {
        List<Lotto> boughtLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> selectedNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(selectedNumbers);
            Lotto newLotto = new Lotto(selectedNumbers);
            boughtLottos.add(newLotto);
        }
        System.out.printf("%d개를 구매했습니다.\n", count);
        return boughtLottos;
    }

    public static void printBoughtLottos(List<Lotto> boughtLottos) {
        for (Lotto boughtLotto: boughtLottos) {
            boughtLotto.printLottoNumbers();
        }
        System.out.println();
    }

    public static void printResult(List<Integer> lottoWinnings, String percentage) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", lottoWinnings.get(4));
        System.out.printf("4개 일치 (50,000원) - %d개\n", lottoWinnings.get(3));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", lottoWinnings.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", lottoWinnings.get(1));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", lottoWinnings.get(0));
        System.out.printf("총 수익률은 %s입니다.\n", percentage);
    }

    public static void main(String[] args) {
        int payment = validatePayment();
        List<Lotto> boughtLottos = buyLottos(payment);
        printBoughtLottos(boughtLottos);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
    }
}
