package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class Controller {
    Lotto lotto;
    String input;
    EnumMap<Money, Integer> map = new EnumMap<>(Money.class);
    Computer[] computers;

    void start() {
        int inMoney;
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

    private void Result(int inMoney) {
        View view = new View();
        Domain domain = new Domain();
        long result = domain.checkWinningMoney(map);
        view.printBenfit(inMoney, result);
    }

    private void checkWinning() {
        View view = new View();
        Domain domain = new Domain();
        domain.checkWinning(computers, map, lotto);
        view.printResult(map);
    }

    private void inBonus() {
        int bonus = Integer.parseInt(input);
        lotto.getNumbers().add(bonus);
    }

    private int inMoney() {
        return Integer.parseInt(input);
    }

    private String getInput() {
        return Console.readLine();
    }

    public void BonusException() throws IllegalArgumentException {
        Exception ex = new Exception();
        ex.inputWinningBonus(input);
    }

    private void Bonus() {
        View view = new View();
        view.inputBonus();
        input = getInput();
    }

    public void startMoneyException() throws IllegalArgumentException {
        Exception ex = new Exception();
        ex.initialInput(input);
    }

    private void startMoney() {
        View view = new View();
        view.startMention();
        input = getInput();
    }

    private void getComputers(int inMoney) {
        View view = new View();
        computers = new Computer[inMoney / 1000];
        for (int i = 0; i < inMoney / 1000; i++) computers[i] = new Computer();
        view.purchaseNumber(inMoney / 1000, computers);
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
        View view = new View();
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
