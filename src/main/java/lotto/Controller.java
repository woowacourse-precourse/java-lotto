package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class Controller {
    static View view = new View();
    Lotto lotto;
    static String input;
    static EnumMap<Money, Integer> map = new EnumMap<>(Money.class);
    static Computer[] computers;

    void start() {
        long inMoney;
        try {
            startMoney();
            startMoneyException();
            inMoney = inMoney();
            getComputers(inMoney);
            winningNumber();
            winningNumberException();
            Bonus();
            BonusException();
            inBonus();
            checkWinning();
            Result(inMoney);
        } catch (IllegalArgumentException e) {
            if (!Objects.equals(e.getMessage(), null)) System.out.println(e.getMessage());
        }
    }

    private void Result(long inMoney) {
        Domain domain = new Domain();
        long result = domain.checkWinningMoney(map);
        view.printBenfit(inMoney, result);
    }

    private void checkWinning() {
        Domain domain = new Domain();
        domain.checkWinning(computers, map, lotto);
        view.printResult(map);
    }

    private void inBonus() {
        int bonus = Integer.parseInt(input);
        lotto.getNumbers().add(bonus);
    }

    private Long inMoney() {
        return Long.parseLong(input);
    }

    private String getInput() {
        return Console.readLine();
    }

    public void BonusException() throws IllegalArgumentException {
        Exception ex = new Exception();
        ex.inputWinningBonus(input);
    }

    private void Bonus() {
        view.inputBonus();
        input = getInput();
    }

    public void startMoneyException() throws IllegalArgumentException {
        Exception ex = new Exception();
        ex.initialInput(input);
    }

    private void startMoney() {
        view.startMention();
        input = getInput();
    }

    private void getComputers(long inMoney) {
        computers = new Computer[(int)inMoney / 1000];
        for (int i = 0; i < inMoney / 1000; i++) computers[i] = new Computer();
        view.purchaseNumber((int)inMoney / 1000, computers);
        System.out.println();
    }


    public void winningNumberException() throws IllegalArgumentException {
        List<Integer> lottoList = new ArrayList<>();
        String[] str = input.split(",");
        addWinningNum(str, lottoList);
        lotto = new Lotto(lottoList);
        System.out.println();
    }

    private void winningNumber() {
        view.inputNumber();
        input = getInput();
    }

    private void addWinningNum(String[] str, List<Integer> lottoList) throws IllegalArgumentException {
        for (String s : str) {
            try {
                lottoList.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 공백없이 숫자와 ,를 입력해주세요.");
            }
        }
    }
}
