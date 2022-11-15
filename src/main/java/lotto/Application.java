package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {

    public static int validatePayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String payment = readLine();
        if (Integer.parseInt(payment) % 1000 != 0) {
            System.out.println("[ERROR] 유효한 구입금액이 아닙니다.");
            throw new IllegalArgumentException();
        }
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
        return winningNumbers;
    }

    public static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해주세요.");
        int bonusNumber = Integer.parseInt(readLine());
        checkLottoNumber(bonusNumber);
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

    public static void main(String[] args) {
        int payment = validatePayment();
        List<Lotto> myLottos = buyLottos(payment);
        printBoughtLottos(myLottos);
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();
    }
}
