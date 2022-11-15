package lotto;
import lotto.domain.LottoGenerator;

import java.util.List;

public class Application {
    
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<List<Integer>> numList = null;
        int count = lottoGenerator.count;

        try{
            for(int i =0 ; i< count; i++){
                lottoGenerator.LottoNumbers();
            }



        }catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
