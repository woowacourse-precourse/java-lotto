package lotto.dao;

import lotto.vo.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseNumberTest {
    @DisplayName("데이터 삽입")
    @Test
    void insert() {
        PurchaseNumber dao = PurchaseNumber.newInstance();

        assertThat(dao.insert(new Lotto(Lotto.createNumbers()))).isTrue();
    }

    @DisplayName("최근 데이터 가져오기")
    @Test
    void getLatest() {
        PurchaseNumber dao = PurchaseNumber.newInstance();
        dao.insert(new Lotto(Lotto.createNumbers()));

        assertThat(dao.getLatest()).isInstanceOf(Lotto.class);
    }

    @DisplayName("데이터 모두 가져오기")
    @Test
    void getAll() {
        PurchaseNumber dao = PurchaseNumber.newInstance();
        dao.insert(new Lotto(Lotto.createNumbers()));
        dao.insert(new Lotto(Lotto.createNumbers()));

        List<Lotto> lotteries = dao.getAll();

        assertThat(lotteries.size() == 2).isTrue();
    }

    @DisplayName("DB가 비어있다면 패스")
    @Test
    void isEmpty() {
        PurchaseNumber dao = PurchaseNumber.newInstance();

        assertThat(dao.isEmpty()).isTrue();
    }

    @DisplayName("데이터 삭제")
    @Test
    void delete() {
        PurchaseNumber dao = PurchaseNumber.newInstance();
        dao.insert(new Lotto(Lotto.createNumbers()));
        Lotto lotto = dao.getLatest();

        assertThat(dao.delete(lotto)).isTrue();
    }
}
