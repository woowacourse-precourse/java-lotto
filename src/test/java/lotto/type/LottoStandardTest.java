package lotto.type;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoStandardTest {

    @Test
    public void findByMatchCountAndBonus() {
        //given
        int firstMatchCount = LottoStandard.FIRST.getMatchCount();
        int secondMatchCount = LottoStandard.SECOND.getMatchCount();
        int thirdMatchCount = LottoStandard.THIRD.getMatchCount();
        int fourthMatchCount = LottoStandard.FOURTH.getMatchCount();
        int fifthMatchCount = LottoStandard.FIFTH.getMatchCount();
        int nothingMatchCount = 2;

        boolean secondBonus = true;
        boolean thirdBonus = false;

        //when
        LottoStandard first = LottoStandard.findByMatchCountAndBonus(firstMatchCount, false);
        LottoStandard second = LottoStandard.findByMatchCountAndBonus(secondMatchCount, secondBonus);
        LottoStandard third = LottoStandard.findByMatchCountAndBonus(thirdMatchCount, thirdBonus);
        LottoStandard fourth = LottoStandard.findByMatchCountAndBonus(fourthMatchCount, false);
        LottoStandard fifth = LottoStandard.findByMatchCountAndBonus(fifthMatchCount, false);
        LottoStandard nothing = LottoStandard.findByMatchCountAndBonus(nothingMatchCount, false);

        //then
        Assertions.assertThat(first).isEqualTo(LottoStandard.FIRST);
        Assertions.assertThat(second).isEqualTo(LottoStandard.SECOND);
        Assertions.assertThat(third).isEqualTo(LottoStandard.THIRD);
        Assertions.assertThat(fourth).isEqualTo(LottoStandard.FOURTH);
        Assertions.assertThat(fifth).isEqualTo(LottoStandard.FIFTH);
        Assertions.assertThat(nothing).isEqualTo(LottoStandard.NOTHING);
    }

    @Test
    public void judge() {
        //given
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = i; j <= i + 5; j++) {
                numbers.add(j);
            }
            lottos.add(new Lotto(numbers));
        }
        List<Integer> winningNumbers = List.of(2, 3, 4, 5, 6, 7);
        int bonusNumber = 8;

        //when
        List<LottoStandard> standards = new ArrayList<>();
        for (Lotto lotto : lottos) {
            standards.add(LottoStandard.judge(lotto, winningNumbers, bonusNumber));
        }

        //then
        Assertions.assertThat(standards.get(0)).isEqualTo(LottoStandard.THIRD);
        Assertions.assertThat(standards.get(1)).isEqualTo(LottoStandard.FIRST);
        Assertions.assertThat(standards.get(2)).isEqualTo(LottoStandard.SECOND);
        Assertions.assertThat(standards.get(3)).isEqualTo(LottoStandard.FOURTH);
        Assertions.assertThat(standards.get(4)).isEqualTo(LottoStandard.FIFTH);
        Assertions.assertThat(standards.get(5)).isEqualTo(LottoStandard.NOTHING);
    }
}