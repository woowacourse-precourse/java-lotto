package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private final String seperator = ",";
    private final LottoVendingMachine machine;
    private final ArrayList<Integer> winningNumber;
    private int bonusNumber;
    private ArrayList<Lotto> purchasedLotto;

    public LottoGame() {
        machine = new LottoVendingMachine();
        winningNumber = new ArrayList<>();
    }

    public void start() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int inputMoney = Integer.parseInt(input);
        purchasedLotto = machine.publishLotto(inputMoney);
        printPurchasedLotto();

        System.out.println("당첨 번호를 입력해 주세요");
        String numbersInput = Console.readLine();
        getWinnerNumber(numbersInput);

        System.out.println("보너스 번호를 입력해 주세요");
        String bonusInput = Console.readLine();
        bonusNumber = Integer.parseInt(bonusInput);

    }

    private void printPurchasedLotto() {
        for(Lotto l : purchasedLotto)
            System.out.println("[" + l + "]");
    }

    private void getWinnerNumber(String numbersInput) {
        String[] numbers = numbersInput.split(seperator);
        ArrayList<String> values = new ArrayList<>(Arrays.asList(numbers));
        for(String s : values)
            winningNumber.add(Integer.parseInt(s));

        validate(winningNumber);
    }

    // 입력한 번호가 6개인지 확인하는 함수
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
}
