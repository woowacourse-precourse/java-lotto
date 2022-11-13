package lotto;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.stream.Collectors;

public class calculateLotto {
    Lotto inputLottto;
    int bonusLotto;

    calculateLotto(){
        System.out.println("로또번호 입력하세요");
        String inputLotto = Console.readLine();
        this.inputLottto = convertLottos(inputLotto);
        System.out.println("보너스번호 입력하세요");
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
            int count =0;
            Set<Integer> set= new HashSet<>(inputLottto.getNumbers());
            for(int i = 0; i<lotto.getNumbers().size();i++){
                if(!set.add(lotto.getNumbers().get(i))) count++;
            }
            if(count<3) count=-1;
            if(count>=3) count = count -3;
            if(count == 6) count = 4;
            if(lotto.getNumbers().contains(bonusLotto) && count== 5) {
                count = 3;
            }
            System.out.println(count);
            if(count>=0) correctNumber[count] +=1;
        }

        return Arrays.stream(correctNumber)
                .boxed()
                .collect(Collectors.toList());
    }
}
