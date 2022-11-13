package util;

import camp.nextstep.edu.missionutils.Console;
import domain.Lotto;
import domain.Rank;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import static values.Constants.Digit.*;
import static values.Constants.Error.*;
import static values.Constants.Util.LOTTO_NUMBER_SEPARATOR;

public class LottoUtils {

    public static void validate(List<Integer> numbers) {
        validateNumbersSize(numbers);
        validateDuplication(numbers);
        validateNumbersRange(numbers);
    }

    public static void validate(int bonusNumber){
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException(RANGE_ERROR);
        }
    }


    private static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(SIZE_ERROR);
        }
    }

    private static void validateDuplication(List<Integer> numbers) {
        List<Integer> duplicationRemoved = numbers.stream().distinct().collect(Collectors.toList());

        if (duplicationRemoved.size() != 6) {
            throw new IllegalArgumentException(DUPLICATION_ERROR);
        }
    }

    private static void validateNumbersRange(List<Integer> numbers) {
        numbers.forEach(num -> {
            if (!(num >= 1 && num <= 45)) {
                throw new IllegalArgumentException(RANGE_ERROR);
            }
        });
    }

    public static int getLottoCnt() {
        return getMoney() / LOTTO_PRICE;
    }

    private static int getMoney() {
        int money = Integer.parseInt(Console.readLine());
        validateMoney(money);

        return money;
    }

    private static void validateMoney(int money) {
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(System.out::println);
    }

    public String getTotalRevenueMessage(Double percent) {
        StringBuilder message = new StringBuilder();
        String roundedPercent = String.format("%.1f", percent);

        message.append("총 수익률은 ");
        message.append(roundedPercent);
        message.append("%입니다.");

        return message.toString();
    }

    public static List<Integer> getWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        String inputNumbers = Console.readLine();
        String[] splitNumbers = inputNumbers.split(LOTTO_NUMBER_SEPARATOR);

        for (String splitNumber : splitNumbers) {
            int number = Integer.parseInt(splitNumber);
            winningNumbers.add(number);
        }

        return winningNumbers;
    }

    public static int getBonusNumber(){
        int bonusNumber = Integer.parseInt(Console.readLine());
        return bonusNumber;
    }

    public static Rank compareLottoNumber(Lotto winningNumber, int bonusNumber, List<Lotto> lottos){
        LinkedHashMap<Integer, Integer> ranking = new LinkedHashMap<>();
        List<Integer> winningLottoNumbers = winningNumber.getLottoNumbers();
        List<Integer> rightNumbers = new ArrayList<>();
        List<Integer> wrongNumbers = new ArrayList<>();
        lottos.forEach(lotto -> {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            for(int i = 0;i < LOTTO_NUMBER_COUNT; i++) {
                if (lottoNumbers.get(i) == winningLottoNumbers.get(i)) {
                    rightNumbers.add(lottoNumbers.get(i));
                    continue;
                }
                wrongNumbers.add(lottoNumbers.get(i));
            }
            //checkFirstPlace
            if(rightNumbers.size() == LOTTO_NUMBER_COUNT){
                if(!ranking.containsKey(FIRST_PLACE)){
                    ranking.put(FIRST_PLACE, 1);
                    return;
                }
                ranking.put(FIRST_PLACE,ranking.get(FIRST_PLACE)+1);
            }
            //checkSecondPlace
            if(rightNumbers.size() == 5 && wrongNumbers.contains(bonusNumber)){
                if(!ranking.containsKey(SECOND_PLACE)){
                    ranking.put(SECOND_PLACE, 1);
                    return;
                }
                ranking.put(SECOND_PLACE,ranking.get(SECOND_PLACE)+1);
            }
            //checkOtherPlace
            int rank = rightNumbers.size();

            if(!ranking.containsKey(rank)){
                ranking.put(rank, 1);
                return;
            }
            ranking.put(rank, ranking.get(rank)+1);
        });
        return new Rank(ranking);
    }


}
