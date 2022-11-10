package lotto.view;

public class IntroduceView extends View {
    @Override
    public void Show() {
        printLine("┏━━━━━━━━━━┓");
        printLine("   로또 게임");
        printLine("┗━━━━━━━━━━┛");
        printLine("우아한테크코스 5기 프리코스 2주차 미션");
        printLine("만든이: 윤창욱 (Laeng)");
        printLine("");

        printLine("┏━━━━━━━━━━┓");
        printLine("    게임 소개");
        printLine("┗━━━━━━━━━━┛");
        printLine("로또를 시뮬레이션할 수 있는 놀라운 게임이에요.");
        printLine("금액과 당첨 번호와 보너스를 입력하면 당첨 내역 및 수익률를 확인할 수 있어요.");
        printLine("로또 1장의 가격은 1,000원입니다.");

        printLine("");
    }
}
