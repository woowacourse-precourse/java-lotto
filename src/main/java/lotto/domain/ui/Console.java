package lotto.domain.ui;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Console {
    public int inputCellCount() {
        int amount = inputCellAmount();
        return calculateCount(amount);
    }

    private int calculateCount(int amount) {
        int count;
        try {
            if (amount % Lotto.PRICE != 0) {
                throw new IllegalArgumentException();
            }
            count = amount / Lotto.PRICE;
        } catch (Exception e) {
            System.out.println("[ERROR] : 1장에 " + Lotto.PRICE + "원 입니다. 딱 맞게 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        return count;
    }

    private int inputCellAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String line = camp.nextstep.edu.missionutils.Console.readLine();

        int amount;
        try {
            amount = Integer.parseInt(line);
        } catch (Exception e) {
            System.out.println("[ERROR] : 숫자를 입력해 주세요.");
            throw new IllegalArgumentException();
        }
        return amount;
    }

    public WinningNumber inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto lottoNumber = inputLottoNumber();

        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = inputBonusNumber();

        return new WinningNumber(lottoNumber, bonusNumber);
    }

    private int inputBonusNumber() {
        String line = camp.nextstep.edu.missionutils.Console.readLine();
        int bonusNumber;
        try {
            bonusNumber = Integer.parseInt(line);
        } catch (Exception e) {
            System.out.println("[ERROR]: 정확한 숫자를 입력하세요.");
            throw new IllegalArgumentException();

        }

        return bonusNumber;
    }

    private Lotto inputLottoNumber() {
        String line = camp.nextstep.edu.missionutils.Console.readLine();

        List<Integer> numbers;
        try {
            String[] data = line.split(",");
            numbers = Arrays.stream(data).mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println("[ERROR]: 정확한 숫자를 입력하세요.");
            throw new IllegalArgumentException();
        }

        return new Lotto(numbers);
    }


}
