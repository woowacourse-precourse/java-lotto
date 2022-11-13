package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sample {
    private static final String HOW_MANY_BUY_STRING = "개를 구매했습니다." + System.lineSeparator(); // Lotto-print-001
    private static final String ILLEGAL_ARGUMENT_ERROR_MESSAGE = "[ERROR] Illegal Argument";
    public int stringToInt(String line){ // Lotto-valid-001
        try{
            int number = Integer.parseInt(line);
            if (number % 1000 != 0) {
                System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
            return number;
        } catch (NumberFormatException e){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getLottos(int numberPurchase){ // Lotto-create-001
        List<Lotto> lottos = new ArrayList<>();
        for (int nowPurchase = 0; nowPurchase < numberPurchase; nowPurchase++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lotto.sort(Comparator.naturalOrder());
            lottos.add(new Lotto(lotto));
        }
        return lottos;
    }

    public String printLottos(List<Lotto> lottos){ // Lotto-print-001
        String printString = lottos.size() + HOW_MANY_BUY_STRING;
        for (Lotto lotto : lottos){
            printString += lotto.getNumbers() + System.lineSeparator();
        }
        return printString;
    }

    public List<Integer> getWinningNumber(String line){ // WinningStatistics-valid-001
        try {
            List<Integer> winningNumbers = Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            validWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (NumberFormatException e){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
    public void validWinningNumbers(List<Integer> winningNumbers){
        if (winningNumbers.size() != 6){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        for (Integer winningNumber : winningNumbers){
            if (winningNumber < 1 || winningNumber > 45) {
                System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
                throw new IllegalArgumentException();
            }
        }
    }

    public int getBonusNumber(String line){
        try{
            int bonusNumber = Integer.parseInt(line);
            validBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
    public void validBonusNumber(int bonusNumber){
        if (bonusNumber < 1 || bonusNumber > 45){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
}
