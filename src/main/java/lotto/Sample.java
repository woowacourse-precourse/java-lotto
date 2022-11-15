package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Sample {
    private static final String HOW_MANY_BUY_STRING = "개를 구매했습니다." + System.lineSeparator(); // Lotto-print-001
    private static final String ILLEGAL_ARGUMENT_ERROR_MESSAGE = "[ERROR] Illegal Argument";
    private static final String WINNING_STATISTICS_START_MESSAGE = "당첨 통계" + System.lineSeparator() + "---" + System.lineSeparator();
    private static final String WINNING_YIELD_PRINT_FORM = "총 수익률은 %yield%입니다." + System.lineSeparator();
    public int stringToInt(String line){ // Lotto-valid-001, WinningStatistics-valid-002
        try{
            int number = Integer.parseInt(line);
            return number;
        } catch (NumberFormatException e){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }

    public int getPayMoney(String line){ // Lotto-valid-001
        int payMoney = stringToInt(line);
        if (payMoney % 1000 != 0) {
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        return payMoney;
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

    public Lotto getWinningNumber(String line){ // WinningStatistics-valid-001
        try {
            List<Integer> winningNumbers = Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());
            return new Lotto(winningNumbers);
        } catch (NumberFormatException e){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
    }


    public int validBonusNumber(String line){ // WinningStatistics-valid-002
        int bonusNumber = stringToInt(line);
        if (bonusNumber < 1 || bonusNumber > 45){
            System.out.println(ILLEGAL_ARGUMENT_ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }




    public String printWinningStatistics(List<LottoWinning> winningStatistics){ //WinningStatistics-print-001
        String message = WINNING_STATISTICS_START_MESSAGE;
        List<Integer> countWinning = getCountWinning(winningStatistics);
        List<LottoWinningEnum> lottoWinningEnum = List.of(LottoWinningEnum.values());
        for (int index = 0; index < countWinning.size(); index++){
            int count = countWinning.get(index);
            message += lottoWinningEnum.get(index).getPrintString(count);
        }
        return message;
    }

    public List<Integer> getCountWinning(List<LottoWinning> winningStatistics){ // WinningStatistics-print-001, -yield-001
        List<Integer> countWinning = new ArrayList<>();
        for (LottoWinningEnum lottoWinningEnum : LottoWinningEnum.values()){
            int correctNumber = lottoWinningEnum.getCorrectNumber();
            boolean hitBonus = lottoWinningEnum.isHitBonus();

            int count = Collections.frequency(winningStatistics, new LottoWinning(correctNumber, hitBonus));
            countWinning.add(count);
        }
        return countWinning;
    }

    public String printYield(List<LottoWinning> winningStatistics, int buyPrice){ // WinningStatistics-yield-001
        String message = WINNING_YIELD_PRINT_FORM;
        message = message.replace("%yield",String.valueOf(getYield(winningStatistics, buyPrice)));
        return message;
    }
    public double getYield(List<LottoWinning> winningStatistics, int buyPrice){ //WinningStatistics-yield-001
        double getPrice = 0;
        List<Integer> countWinning = getCountWinning(winningStatistics);
        List<LottoWinningEnum> lottoWinningEnum = List.of(LottoWinningEnum.values());
        for (int index = 0; index < countWinning.size(); index++){
            int count = countWinning.get(index);
            int money = lottoWinningEnum.get(index).getMoney();
            getPrice += count * money;
        }
        double yield = getPrice / buyPrice * 100;
        return Math.round(yield * 10) / 10.0;
    }
}
