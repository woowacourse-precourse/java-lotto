package ui;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import lotto.Lotto;
import lotto.PurchaseLotto;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UiTest {

    @Test
    void printLottoNumber() {
        List<Lotto> lottos = new LinkedList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(7, 8, 9, 10, 11, 12)));
        lottos.add(new Lotto(List.of(13, 14, 15, 16, 17, 18)));
        //System.out.println(PurchasePrint.printLottoNumber(lottos));
        assertThat("[1, 2, 3, 4, 5, 6]"+"\n"+
                         "[7, 8, 9, 10, 11, 12]"+"\n"+
                         "[13, 14, 15, 16, 17, 18]").
                contains(PurchasePrint.printLottoNumber(lottos));
    }
}