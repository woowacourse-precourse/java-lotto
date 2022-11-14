package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Objects;

public class Controller {
    View view = new View();
    Domain domain = new Domain();
    Lotto lotto;
    Exception ex = new Exception();
    int inMoney;
    int bonus;
    long result;
    String input;
    String[] str;
    List<Integer> lottoList = new ArrayList<>();
    EnumMap<Money, Integer> map = new EnumMap<>(Money.class);
    Computer[] computers;

    void start() {
        try {
            startMoney();
            startMoneyException();
            inMoney();
            getComputers();
            winningNumber();
            winningNumberException();
            Bonus();
            BonusException();
            inBonus();
            checkWinning();
            Result();
        } catch (IllegalArgumentException e) {
            if (!Objects.equals(e.getMessage(),null)) System.out.println(e.getMessage());
        }
    }

    private void Result() {
        result = domain.checkWinningMoney(map);
        view.printBenfit(inMoney, result);
    }

    private void checkWinning() {
        domain.checkWinning(computers, map, lotto);
        view.printResult(map);
    }

    private void inBonus() {
        bonus = Integer.parseInt(input);
        lotto.getNumbers().add(bonus);
    }

    private void inMoney() {
        inMoney = Integer.parseInt(input);
    }

    private void getInput() {
        input = Console.readLine();
    }

    public void BonusException() throws IllegalArgumentException {
        ex.inputWinningBonus(input);
    }

    private void Bonus() {
        view.inputBonus();
        getInput();
    }

    public void startMoneyException() throws IllegalArgumentException {
        ex.initialInput(input);
    }

    private void startMoney() {
        view.startMention();
        getInput();
    }

    private void getComputers() {
        computers = new Computer[inMoney / 1000];
        for (int i = 0; i < inMoney / 1000; i++) computers[i] = new Computer();
        view.purchaseNumber(inMoney / 1000, computers);
        System.out.println();
    }


    public void winningNumberException() throws IllegalArgumentException {
        str = input.split(",");
        addWinningNum();
        lotto = new Lotto(lottoList);
        System.out.println();
    }

    private void winningNumber() {
        view.inputNumber();
        getInput();
    }

    private void addWinningNum() throws IllegalArgumentException {
        for (String s : str) {
            try {
                lottoList.add(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 공백없이 숫자와 ,를 입력해주세요.");
            }
        }
    }
}
