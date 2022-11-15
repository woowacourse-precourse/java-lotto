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

    private static int getNumberOfMatch(List<Integer> oneLottoGame,List<Integer> winNumbers){
        int numberOfMatch = 0;

        for(int i = 0; i < winNumbers.size(); i++){
            if(oneLottoGame.contains(winNumbers.get(i))){
                numberOfMatch++;
            }
        }
        return numberOfMatch;
    }

    private static void putRank(List<Integer> oneLottoNumbers,int bonusNumber,int numberOfMatch,Map <Integer,Integer> winStatistics){
        int rank = oneLottoNumbers.size()-numberOfMatch + 1;
        if(rank == 1){
            winStatistics.put(rank,winStatistics.get(rank)+1);
        }
        if(rank == 2){
            if(oneLottoNumbers.contains(bonusNumber)){
                winStatistics.put(rank,winStatistics.get(rank)+1);
                return;
            }
            winStatistics.put(rank+1,winStatistics.get(rank)+1);
        }
        if(rank > 3){
            winStatistics.put(rank+1,winStatistics.get(rank)+1);
        }
    }

    public static List<Integer> howManyMatchNumbers(List<List<Integer>> userLottoNumbers, List<Integer> winNumbers,int bonusNumber,Map <Integer,Integer> winStatistics){
        List<Integer> allNumberOfMatch = new ArrayList<>();
        winStatisticDefault(winStatistics);

        for(int i = 0 ; i < userLottoNumbers.size(); i++){
            int numberOfMatch = getNumberOfMatch(userLottoNumbers.get(i),winNumbers);
            allNumberOfMatch.add(numberOfMatch);
            putRank(userLottoNumbers.get(i),bonusNumber,numberOfMatch,winStatistics);
        }
        return allNumberOfMatch;
    }

    public static int totalPrice(Map <Integer,Integer> winStatistics){
        int winMoney = 0;
        int noPrice = 4; // 0,1,2 개 맞춘 것 + rank는 1부터 있으므로 0 비워둠
        int [] priceMoney = {2000000000,30000000,1500000,50000,5000};

        for(int i = 1; i <= winStatistics.size()-noPrice; i++){
            winMoney+= priceMoney[i-1] * winStatistics.get(i);
        }
        return winMoney;
    }

    public static double yieldOfLotto(int inputMoney,Map <Integer,Integer> winStatistics){
        int totalMoney = totalPrice(winStatistics);
        double totalYeild = (double)totalMoney/(double)inputMoney;

        double roundTotalYeild = totalYeild*100;

        return roundTotalYeild;
    }
}
