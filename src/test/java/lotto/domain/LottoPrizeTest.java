package lotto.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoPrizeTest {

  @Test
  void 일치하는번호가_3개면_5등이된다(){
    int givenMatchCount = 3;
    int givenBonusCount = 0;

    LottoPrize result = LottoPrize.of(givenMatchCount, givenBonusCount);

    assertThat(result).isEqualTo(LottoPrize.FIFTH);
  }

  @Test
  void 일치하는번호가_4개면_3등이된다(){
    int givenMatchCount = 4;
    int givenBonusCount = 0;

    LottoPrize result = LottoPrize.of(givenMatchCount, givenBonusCount);

    assertThat(result).isEqualTo(LottoPrize.FOURTH);
  }

  @Test
  void 일치하는번호가_5개면_3등이된다(){
    int givenMatchCount = 5;
    int givenBonusCount = 0;

    LottoPrize result = LottoPrize.of(givenMatchCount, givenBonusCount);

    assertThat(result).isEqualTo(LottoPrize.THIRD);
  }

  @Test
  void 일치하는번호가_5개_보너스번호가일치하면_2등이된다(){
    int givenMatchCount = 5;
    int givenBonusCount = 1;

    LottoPrize result = LottoPrize.of(givenMatchCount, givenBonusCount);

    assertThat(result).isEqualTo(LottoPrize.SECOND);
  }

  @Test
  void 일치하는번호가_6개면_1등이된다(){
    int givenMatchCount = 6;
    int givenBonusCount = 0;

    LottoPrize result = LottoPrize.of(givenMatchCount, givenBonusCount);

    assertThat(result).isEqualTo(LottoPrize.FIRST);
  }

  @Test
  void 일치하는번호가없으면_아무것도_받지못한다(){
    int givenMatchCount = 0;
    int givenBonusCount = 0;

    LottoPrize result = LottoPrize.of(givenMatchCount, givenBonusCount);

    assertThat(result).isEqualTo(LottoPrize.MATCH_NOTING);
  }
}