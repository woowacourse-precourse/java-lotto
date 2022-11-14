package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.stream.Collectors;

public class calculateLotto {
    Lotto inputLottto;
    int bonusLotto;
    static String lottoinputMessage = "로또번호 입력하세요.";
    static String bonusinputMessage = "보너스번호 입력하세요.";
    static String totalrateMessage = "총 수익률은 %s%%입니다.";

    calculateLotto(){
        //System.out.println(lottoinputMessage);
        String inputLotto = Console.readLine();
        this.inputLottto = convertLottos(inputLotto);
        //System.out.println(bonusinputMessage);
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
            int[] count ={0,0};
            Set<Integer> set= new HashSet<>(inputLottto.getNumbers());
            for(int i = 0; i<lotto.getNumbers().size();i++){
                if(!set.add(lotto.getNumbers().get(i))) count[0]++;
            }
            if(lotto.getNumbers().contains(bonusLotto) && count[0]== 5) {
                count[1]=1;
            }
            int index = gradeNumber(count);
            if(index>=0)correctNumber[index] +=1;
        }
        return Arrays.stream(correctNumber)
                .boxed()
                .collect(Collectors.toList());
    }

    public int gradeNumber(int[] count){ // 3
        if(count[1]==1) return 3;
        if(count[0]==6) return 4;
        if(count[1]!=1&&count[0]<6) return count[0]-3;
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