package lotto;

import java.util.List;

public class Render {
    public static void purchaseLottoResultPrint(List<Lotto> lotto){
        StringBuffer response = new StringBuffer();
        for(int i = 0;i<lotto.size();i++) {
            response.append(lotto.get(i) + "\n");
        }
        System.out.println(response);
    }
}
