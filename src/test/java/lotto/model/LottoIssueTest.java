package lotto.model;

import lotto.model.Issue.LottoIssue;
import lotto.model.Issue.LottoIssueImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class LottoIssueTest {

    @Test
    @DisplayName("로또 발행 권수 확인")
    void case1(){
        //given
        LottoIssue lottoIssue = new LottoIssueImpl("10000");

        //when
        List<Lotto> result = lottoIssue.getLotto();

        //then
        Assertions.assertThat(result.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("발행 로또 유효 범위 테스트")
    void case2(){
        //given
        LottoIssue lottoIssue = new LottoIssueImpl("10000");

        //when
        List<Lotto> result = lottoIssue.getLotto();

        //then
        for (Lotto lotto : result) {
            Assertions.assertThat(lotto.getNumbers()).allMatch(number -> 1<=number&&number<=45);
        }
    }

    @Test
    @DisplayName("발행 중복 테스트")
    void case3(){
        //given
        LottoIssue lottoIssue = new LottoIssueImpl("10000");

        //when
        List<Lotto> result = lottoIssue.getLotto();

        //then
        for (Lotto lotto : result) {
            Assertions.assertThat(lotto.getNumbers().stream().distinct().count()).isEqualTo(6);
        }
    }
}
