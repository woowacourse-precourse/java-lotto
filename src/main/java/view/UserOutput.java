package view;

import java.util.List;

public class UserOutput {
    private static final String BUYING_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void printLottoCount(int lottoCount){
        System.out.println(lottoCount + BUYING_LOTTO_MESSAGE);
    }

    public void printRandomLottoList(List<List<Integer>> randomLottos){
        for(int i = 0; i < randomLottos.size(); i++){
            System.out.println(randomLottos.get(i));
        }
    }
}
