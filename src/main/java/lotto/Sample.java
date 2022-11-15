package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Sample {
    private static final String HOW_MANY_BUY_STRING = "개를 구매했습니다." + System.lineSeparator(); // Lotto-print-001
    private static final String ILLEGAL_ARGUMENT_ERROR_MESSAGE = "[ERROR] Illegal Argument";
    private static final String WINNING_STATISTICS_START_MESSAGE = "당첨 통계" + System.lineSeparator() + "---" + System.lineSeparator();
    private static final String WINNING_STATISTICS_PRINT_FORM = "%correctNumber개 일치 (%money원) - %count개" + System.lineSeparator();
    private static final String WINNING_STATISTICS_PRINT_BONUS_FORM = "%correctNumber개 일치, 보너스 볼 일치 (%money원) - %count개" + System.lineSeparator();
    private static final String WINNING_YIELD_PRINT_FORM = "총 수익률은 %yield%입니다." + System.lineSeparator();
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
            boolean bonus = false;
            if (lottoCorrectNumber == 5)
                hitBonus(lotto, bonusNumber);
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

    public String printWinningStatistics(List<LottoWinning> winningStatistics){ //WinningStatistics-print-001
        String message = WINNING_STATISTICS_START_MESSAGE;
        NumberFormat numberFormat = NumberFormat.getInstance();
        for (LottoWinningEnum lottoWinningEnum : LottoWinningEnum.values()){
            String nowMessage = WINNING_STATISTICS_PRINT_FORM;
            int correctNumber = lottoWinningEnum.getCorrectNumber();
            boolean hitBonus = lottoWinningEnum.isHitBonus();
            LottoWinning lottoWinning = new LottoWinning(correctNumber, hitBonus);

            if (hitBonus){
                nowMessage = WINNING_STATISTICS_PRINT_BONUS_FORM;
            }
            nowMessage = nowMessage.replace("%correctNumber", String.valueOf(lottoWinningEnum.getCorrectNumber()));
            nowMessage = nowMessage.replace("%money", numberFormat.format(lottoWinningEnum.getMoney()));
            nowMessage = nowMessage.replace("%count", String.valueOf(Collections.frequency(winningStatistics, lottoWinning)));
            message += nowMessage;
        }
        return message;
    }

    public String printYield(List<LottoWinning> winningStatistics, int buyPrice){
        String message = WINNING_YIELD_PRINT_FORM;
        message = message.replace("%yield",String.valueOf(getYield(winningStatistics, buyPrice)));
        return message;
    }
    public double getYield(List<LottoWinning> winningStatistics, int buyPrice){
        double getPrice = 0;
        for (LottoWinningEnum lottoWinningEnum : LottoWinningEnum.values()){
            int correctNumber = lottoWinningEnum.getCorrectNumber();
            boolean hitBonus = lottoWinningEnum.isHitBonus();
            getPrice += Collections.frequency(winningStatistics, new LottoWinning(correctNumber, hitBonus)) * lottoWinningEnum.getMoney();
        }
        double yield = getPrice / buyPrice * 100;
        return Math.round(yield * 10) / 10.0;
    }
}
