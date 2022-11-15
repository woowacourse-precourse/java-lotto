package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoController {
    private LottoView lottoView = new LottoView();
    private Prize[] prizes = Prize.values();
    private int NumberOfLotto = 0;
    private double profit = 0;


    public void run() {
        try {
            lottoView.printMoneyQuestion();
            NumberOfLotto = getNumberOfLotto();
            List<Lotto> lottoList = makeBunchOfLotto(NumberOfLotto);
            lottoView.printLottoList(lottoList);
            lottoView.printWinNumberQuestion();
            Lotto winNumber = getWinLottoNumber(inputWinNumber());
            lottoView.printBonusNumberQuestion();
            int bonusNumber = inputBonusNumber(winNumber);
            getStatistics(lottoList,winNumber,bonusNumber);
            lottoView.printStatistics(prizes, profit);
        } catch (IllegalArgumentException e) {
            return ;
        }
    }

    public String inputMoney() {
        String input = Console.readLine();
        int money;
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            lottoView.printNumberFormatError();
            throw new IllegalArgumentException();
        }
        money = Integer.parseInt(input);
        if (money < 1000 || money % 1000 != 0) {
            lottoView.printInvalidNumberError();
            throw new IllegalArgumentException();
        }
        return input;
    }

    public int getNumberOfLotto() {
        String input = inputMoney();
        int money = Integer.parseInt(input);

        return money / 1000;
    }

    public Lotto makeLottoNumbers() {
        Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1,45,6));

        return lotto;
    }

    public List<Lotto> makeBunchOfLotto(int number) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            lottos.add(makeLottoNumbers());
        }
        return lottos;
    }

    public String[] inputWinNumber() {
        String input = Console.readLine();
        String[] result = input.split(",");
        if (result.length != 6) {
            lottoView.printWinNumberCountError();
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < result.length; i++) {
            checkNumber(result[i]);
        }
        if (isDuplicatedNumber(result)) {
            lottoView.printDuplicatedNumberError();
            throw new IllegalArgumentException();
        }
        return result;
    }

    public Lotto getWinLottoNumber(String[] input) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }
        return new Lotto(numbers);
    }

    public void checkNumber(String input) {
        int number = 0;

        try {
            number = Integer.parseInt(input);
            if (number > 45 || number < 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            lottoView.printNotProperNumberError();
            throw new IllegalArgumentException();
        }
    }

    public boolean isDuplicatedNumber(String[] input) {
        Set<String> set = new HashSet<>(Arrays.asList(input));

        return input.length != set.size();
    }

    public int inputBonusNumber(Lotto winNumber) {
        String input = Console.readLine();
        checkNumber(input);
        int bonusNumber = Integer.parseInt(input);

        if (isDuplicatedInBonus(winNumber, bonusNumber)) {
            lottoView.printDuplicatedNumberError();
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    public boolean isDuplicatedInBonus(Lotto win, int bonus) {
        Set<Integer> winNumber = new HashSet<>(win.getNumbers());
        Set<Integer> bonusNumber = new HashSet<>(List.of(bonus));

        winNumber.retainAll(bonusNumber);
        if (winNumber.size() == 0) {
            return false;
        }
        return true;
    }

    public void compareLotto(Lotto number, Lotto winNumber, int bonusNumber) {
        int index = 0;
        Set<Integer> thisSet = new HashSet<>(number.getNumbers());
        Set<Integer> win = new HashSet<>(winNumber.getNumbers());
        Set<Integer> bonus = new HashSet<>(List.of(bonusNumber));
        win.retainAll(thisSet);
        if (win.size() == 5 && thisSet.retainAll(bonus)) {
            index = 5;
        }
        if (win.size() - 2 >= 0) {
            index = win.size() - 2;
        }
        prizes[index].addCount();
    }

    public void getStatistics(List<Lotto> lottoList, Lotto winNumber, int bonusNumber) {
        List<Integer> stats = new ArrayList<>();
        int[] prices = {0,5000,50000,1500000,2000000000,30000000};

        for (Lotto lotto : lottoList) {
            compareLotto(lotto, winNumber, bonusNumber);
        }

        for (int i = 1; i < prizes.length; i++) {
            profit += prizes[i].getCount() * prices[i];
        }
        profit = profit / (NumberOfLotto * 1000) * 100;
    }
}
