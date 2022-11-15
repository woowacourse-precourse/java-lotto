package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

public class LottoController {
    public void start(){
        Number_of_Lotto number_of_lotto = inputMoney();
        int Number_of_Purchase = number_of_lotto.Count_Number_of_Lotto();
        if(Number_of_Purchase > 0){
            LottoView.printNumber_of_Purchase(Number_of_Purchase);
            List<Lotto> lottos = generateLottoNumbers.generate(Number_of_Purchase);
            LottoView.printLottos(lottos);
            WinningNumbers winningNumbers = createWinningNumber();
            List<Rank> ranking = initialRank(winningNumbers, lottos);
            HashMap<Rank,Integer> resultRank = resultRank(ranking);
            LottoView.printWinningResult(resultRank);
            resultProfit(resultRank, number_of_lotto);
        }
    }
    private Number_of_Lotto inputMoney(){
        return new Number_of_Lotto(LottoView.inputMoney());
    }
    private WinningNumbers createWinningNumber(){
        return new WinningNumbers(inputWinningNumber(), inputBonusNumber());
    }
    private Lotto inputWinningNumber(){
        LottoView.printInputWinningNumber();
        int[] WiningNumber = Arrays.stream(Console.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        return new Lotto(Arrays.stream(WiningNumber).boxed().collect(Collectors.toList()));
    }
    private int inputBonusNumber(){
        LottoView.printInputBonusNumber();
        return Integer.parseInt(Console.readLine());
    }
    private List<Rank> initialRank(WinningNumbers winningNumbers, List<Lotto> lottos){
        List<Rank> ranking = new ArrayList<>();
        for (Lotto lotto : lottos){
            ranking.add(winningNumbers.match(lotto, winningNumbers.getBonusNumber()));
        }
        return ranking;
    }
    private HashMap<Rank,Integer> resultRank(List<Rank> ranking){
        HashMap<Rank,Integer> rank_count = new HashMap<>();
        int count = 1;

        for (Rank rank : ranking){
            if (rank_count.containsKey(rank.getMatchCount())){
                count = rank_count.get(rank.getMatchCount())+1;
            }
            rank_count.put(rank,count);
        }
        return rank_count;
    }

    private void resultProfit(HashMap<Rank,Integer> result, Number_of_Lotto number_of_lotto){
        int sum = 0;
        for (Map.Entry<Rank, Integer> entry: result.entrySet()){
            sum += entry.getValue()*entry.getKey().getPrize();
        }
        LottoView.printProfitResult((double) (sum*100)/number_of_lotto.getMoney());
    }
}
