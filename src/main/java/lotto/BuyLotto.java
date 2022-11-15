package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BuyLotto {

    public static int numberOfLottoGames(int money){
        int games = money;

        games = games / 1000;

        return games;
    }

    public static void saveEachLottoNumbers(List<List<Integer>> userLottoNumbers,List <Integer> eachLottoNumbers){
        userLottoNumbers.add(eachLottoNumbers);
    }

    public static List<Integer> sortingNumbers(List<Integer> originNumbers){
        List<Integer> sortedNumbers = new ArrayList<>(originNumbers);

        sortedNumbers.sort(Comparator.naturalOrder());

        return sortedNumbers;
    }

    public static List<Integer> makeLotto(List<List<Integer>> userLottoNumbers){
        List<Integer> eachLottoNumbers = Randoms
                .pickUniqueNumbersInRange(1, 45, 6);

        eachLottoNumbers = sortingNumbers(eachLottoNumbers);
        saveEachLottoNumbers(userLottoNumbers,eachLottoNumbers);

        return eachLottoNumbers;
    }

    public static void winStatisticDefault(Map <Integer,Integer> winStatistics){
        int numberOfCasesPrize = 9;

        for(int i = 0 ; i < numberOfCasesPrize; i++){
            winStatistics.put(i,0);
        }
    }

}
