package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoController {
    LottoView lottoView = new LottoView();

    public void run() {
        try {
            lottoView.printMoneyQuestion();
            int NumberOfLotto = getNumberOfLotto();
            List<Lotto> lottoList = makeBunchOfLotto(NumberOfLotto);
            lottoView.printLottoList(lottoList);
            lottoView.printWinNumberQuestion();
            Lotto winNumber = getWinLottoNumber(inputWinNumber());
            lottoView.printBonusNumberQuestion();
            int bonusNumber = inputBonusNumber(winNumber);
            Prize[] prizes = getStatistics(lottoList,winNumber,bonusNumber);
            lottoView.printStatistics(prizes);
            lottoView.printProfit(getProfit(prizes, NumberOfLotto * 1000));
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

    public Prize[] getStatistics(List<Lotto> lottoList, Lotto winNumber, int bonusNumber) {
        List<Integer> stats = new ArrayList<>();
        Prize[] prizes = Prize.values();
        for (Lotto i : lottoList) {
            prizes = i.compareLotto(winNumber, bonusNumber);
        }

        return prizes;
    }

    public double getProfit(Prize[] prizes, int money) {
        double sum = 0.;
        int[] prices = {0,5000,50000,1500000,2000000000,30000000};

        for (int i = 1; i < prizes.length; i++) {
            sum += prizes[i].getCount() * prices[i];
        }
        return sum / money * 100;
    }
}
