package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class ScreenPrinter {
    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            return Integer.valueOf(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 구입 금액은 숫자 형식이어야 합니다.");
            throw new NoSuchElementException();

            //IllegalArgument?????????
        }
    }

    public void showReceipt(List<Lotto> userLottos) {
        int lottoCount = userLottos.size();
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
        for (Lotto userLotto : userLottos) {
            System.out.println(userLotto);
        }
    }

    public List<Integer> inputPrizeNums() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            List<Integer> prizeNums = Arrays.stream(Console.readLine().split(","))
                    .map(string -> Integer.valueOf(string))
                    .collect(Collectors.toList());
            validateNumberCount(prizeNums);
            return prizeNums;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 당첨 번호는 쉼표(,)로만 구분된 6개의 숫자여야 합니다");
            throw new NoSuchElementException();
        }
    }

    private void validateNumberCount(List<Integer> prizeNums) {
        if(prizeNums.size() != 6) {
            System.out.println("[ERROR] 당첨 번호는 6개의 숫자여야 합니다");
            throw new NoSuchElementException();
        }
    }

    public int inputBonusNum() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            return Integer.valueOf(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 보너스 번호는 숫자 형식이어야 합니다.");
            throw new NoSuchElementException();
        }
    }

    public void showResult(LottoResult lottoResult) {
        System.out.println(lottoResult);
    }
}
