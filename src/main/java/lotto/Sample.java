package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
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
    public void validWinningNumbers(List<Integer> winningNumbers){ // WinningStatistics-valid-001
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

    public int getBonusNumber(String line){ // WinningStatistics-valid-002
        try{
            int bonusNumber = Integer.parseInt(line);
            validBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }
    public void validBonusNumber(int bonusNumber){ // WinningStatistics-valid-002
        if (bonusNumber < 1 || bonusNumber > 45){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public List<LottoWinning> getWinningStatistics(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber){ // WinningStatistics-compare-001
        List<LottoWinning> winningStatistics = new ArrayList<>();
        for (Lotto lotto : lottos){
            int lottoCorrectNumber = getCorrectNumber(lotto, winningNumbers);
            boolean bonus = hitBonus(lotto, bonusNumber);
            LottoWinning lottoWinning = new LottoWinning(lottoCorrectNumber, bonus);
            winningStatistics.add(lottoWinning);
        }
        return winningStatistics;
    }
    public int getCorrectNumber(Lotto lotto, List<Integer> winningNumbers){ // WinningStatistics-compare-001
        List<Integer> lottoNumbers = lotto.getNumbers();
        int correctTime = 0;
        for (Integer winningNumber : winningNumbers){
            if (lottoNumbers.contains(winningNumber)){
                correctTime += 1;
            }
        }
        return correctTime;
    }

    public boolean hitBonus(Lotto lotto, int bonus){ // WinningStatistics-compare-001
        return lotto.getNumbers().contains(bonus);
    }
}
