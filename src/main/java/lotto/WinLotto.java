package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WinLotto {
    Lotto inputLottto;
    int bonusLotto;
    static String lottoinputMessage = "로또번호 입력하세요.";
    static String bonusinputMessage = "보너스번호 입력하세요.";
    static String totalrateMessage = "총 수익률은 %s%%입니다.";

    WinLotto(){
        System.out.println(lottoinputMessage);
        String inputLotto = Console.readLine();
        this.inputLottto = convertLottos(inputLotto);
        System.out.println(bonusinputMessage);
        String bonusLotto = Console.readLine();
        this.bonusLotto = convertBonus(bonusLotto);
    }
    Lotto convertLottos(String inputLotto){
        String[] inputLottosTemp = inputLotto.split(",");
        List<Integer> lottos = new ArrayList<>();
        for (String stringToint : inputLottosTemp){
            lottos.add(Integer.valueOf(stringToint));
        }
        Lotto lotto = new Lotto(lottos);
        return lotto;
    }
    int convertBonus(String bonusLotto){
        return Integer.valueOf(bonusLotto);
    }
    List<Integer> winLotto(List<Lotto> lottos){
        int[] correctNumber = {0,0,0,0,0};
        for (Lotto lotto : lottos){
            boolean isBonus = false;
            List<Integer> list =lotto.getNumbers().stream().filter( i -> (inputLottto.getNumbers().stream().anyMatch(Predicate.isEqual(i))))
                    .collect(Collectors.toList());
            if(lotto.getNumbers().contains(bonusLotto) && list.size()== 5) {
                isBonus =true;
            }
            int index = gradeNumber(list.size(),isBonus);
            if(index>=0)correctNumber[index] +=1;
        }
        return Arrays.stream(correctNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    public int gradeNumber(int count, boolean isBonus){ // 3
        if(isBonus==true) return 3;
        if(count==6) return 4;
        if(isBonus==false&&count<6) return count-3;
        return -1;
    }
    void printWinLotto(List<Integer> winLottos, double rateLotto){
        //System.out.printf(lottoStatisticMessage);
        for(WinnerbyLottoRank lottowinner : WinnerbyLottoRank.values()){
            lottowinner.printWinnerbyLottoRank(winLottos.get(lottowinner.ordinal()));
        }
        System.out.printf(totalrateMessage,String.format("%.1f", rateLotto));
    }
    double rateLotto(int numberOflottos, List<Integer> winLottos){
        double getPrizeMoney = 0;
        for(WinnerbyLottoRank lottowinner : WinnerbyLottoRank.values()){
            getPrizeMoney+=lottowinner.prizeValue()*winLottos.get(lottowinner.ordinal());
        }
        return (getPrizeMoney / (numberOflottos*1000.0))*100;
    }


}