package lotto.layer;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.layer.db.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {

    @DisplayName("테이블 정보 저장 및 읽기 테스트")
    @Test
    void TableSaveAndReadTest() {
        // given
        Table table = new Table();
        saveTable(table);

        //expect
        assertThat(table.getLotteries()).isNotEmpty();
        assertThat(table.getFrequency()).isNotEmpty();
        assertThat(table.getMoney()).isNotNull();
    }

    private void saveTable(Table table) {
        Money money = new Money(1000);
        Map<WinningLotto, Integer> frequency = new HashMap<>();
        frequency.put(WinningLotto.PLACE_1, 1);
        List<Lotto> lotteries = new ArrayList<>();
        Lotto lotto = new Lotto(List.of(1,2,3,45,5,6));
        lotteries.add(lotto);

        table.saveMoney(money);
        table.saveFrequency(frequency);
        table.saveLottoAll(lotteries);
    }

}