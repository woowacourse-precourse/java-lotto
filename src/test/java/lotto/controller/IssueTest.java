package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class IssueTest {
    @DisplayName("구매가격이 1000원 단위가 아닐 때")
    @Test
    public void Not1000() {
        assertThat((Issue.Check1000(1500) == false));
    }

    @DisplayName("로또 장수 세기")
    @Test
    public void CountPapaer() {
        assertThat((Issue.CountLotto(3000) == 3));
    }

}