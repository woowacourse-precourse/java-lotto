package lotto;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("일치하는 번호에 따른 Wins 값 확인")
    @Nested
    class getWinsTest {

        @DisplayName("일치하는 번호가 하나도 없는 경우")
        @Test
        void caseWinNone() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getWins(new Lotto(List.of(10, 11, 12, 13, 14, 15))), 0);
        }

        @DisplayName("일치하는 번호가 한개인 경우")
        @Test
        void caseWinOne() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getWins(new Lotto(List.of(6, 11, 12, 13, 14, 15))), 1);
        }

        @DisplayName("일치하는 번호가 두개인 경우")
        @Test
        void caseWinTwo() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getWins(new Lotto(List.of(6, 11, 12, 13, 14, 3))), 2);
        }

        @DisplayName("일치하는 번호가 세개인 경우")
        @Test
        void caseWinThree() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getWins(new Lotto(List.of(6, 11, 5, 13, 14, 3))), 3);
        }

        @DisplayName("일치하는 번호가 네개인 경우")
        @Test
        void caseWinFour() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getWins(new Lotto(List.of(6, 11, 5, 13, 1, 3))), 4);
        }

        @DisplayName("일치하는 번호가 다섯개인 경우")
        @Test
        void caseWinFive() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getWins(new Lotto(List.of(6, 11, 5, 2, 1, 3))), 5);
        }

        @DisplayName("일치하는 번호가 여섯개인 경우")
        @Test
        void caseWinSix() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getWins(new Lotto(List.of(6, 4, 5, 2, 1, 3))), 6);
        }

        @DisplayName("일치하는 번호가 다섯개이면서 보너스 번호가 일치하는 경우")
        @Test
        void caseWinSeven() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getWins(new Lotto(List.of(6, 4, 5, 7, 1, 3))), 7);
        }
    }

    @DisplayName("로또 번호에 따른 등수 확인")
    @Nested
    class getRankTest {

        @DisplayName("낙첨인 경우")
        @Test
        void caseUnranked() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getRank(new Lotto(List.of(10, 11, 12, 13, 14, 15))),
                Rank.UNRANKED.getMessage());
        }

        @DisplayName("5등인 경우")
        @Test
        void caseFifth() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getRank(new Lotto(List.of(6, 11, 5, 13, 14, 3))),
                Rank.FIFTH.getMessage());
        }

        @DisplayName("4등인 경우")
        @Test
        void caseFourth() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getRank(new Lotto(List.of(6, 11, 5, 13, 1, 3))),
                Rank.FOURTH.getMessage());
        }

        @DisplayName("3등인 경우")
        @Test
        void caseThird() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getRank(new Lotto(List.of(6, 11, 5, 2, 1, 3))),
                Rank.THIRD.getMessage());
        }

        @DisplayName("2등인 경우")
        @Test
        void caseSecond() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getRank(new Lotto(List.of(6, 4, 5, 7, 1, 3))),
                Rank.SECOND.getMessage());
        }

        @DisplayName("1등인 경우")
        @Test
        void caseFirst() {
            Game.setWinningNumber("1,2,3,4,5,6");
            Game.setBonusNumber("7");
            assertEquals(Game.getRank(new Lotto(List.of(6, 4, 5, 2, 1, 3))),
                Rank.FIRST.getMessage());
        }
    }
}