package lotto.view.output;

import java.util.List;
import lotto.domain.lotto.lotto.Lotto;

public class OutputImpl implements Output{

    @Override
    public void printMessage(String outputMessage) {
        System.out.println(outputMessage);
    }

    @Override
    public void printPublishedLotto(List<Lotto> publishedLotto) {
        System.out.println(publishedLotto.size()+"개를 구매했습니다.");
        for (Lotto lotto : publishedLotto) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
