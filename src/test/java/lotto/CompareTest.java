//package lotto;
//
//import camp.nextstep.edu.missionutils.test.NsTest;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
//import static org.assertj.core.api.Assertions.assertThat;
//
//class CompareTest extends NsTest {
//
//    @Test
//    void 기능_테스트2() {
//        assertRandomUniqueNumbersInRangeTest(
//                () -> {
//                    run("2000", "1,2,3,4,5,6", "7");
//                    assertThat(output()).contains(
//                            "2개를 구매했습니다.",
//                            "[1, 2, 3, 4, 9, 10]",
//                            "[1, 2, 3, 4, 5, 7]",
//                            "3개 일치 (5,000원) - 0개",
//                            "4개 일치 (50,000원) - 1개",
//                            "5개 일치 (1,500,000원) - 0개",
//                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개",
//                            "6개 일치 (2,000,000,000원) - 0개",
//                            "총 수익률은 1502500.0%입니다."
//                    );
//                },
//                List.of(1, 2, 3, 4, 9, 10),
//                List.of(1, 2, 3, 4, 5, 7)
//        );
//    }
//
//    @Test
//    void 기능_테스트3() {
//        assertRandomUniqueNumbersInRangeTest(
//                () -> {
//                    run("3000", "1,2,3,4,5,6", "7");
//                    assertThat(output()).contains(
//                            "3개를 구매했습니다.",
//                            "[1, 2, 3, 4, 9, 10]",
//                            "[1, 2, 3, 4, 5, 7]",
//                            "[1, 2, 3, 4, 6, 7]",
//                            "3개 일치 (5,000원) - 0개",
//                            "4개 일치 (50,000원) - 1개",
//                            "5개 일치 (1,500,000원) - 0개",
//                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 2개",
//                            "6개 일치 (2,000,000,000원) - 0개",
//                            "총 수익률은 2001666.7%입니다."
//                    );
//                },
//                List.of(1, 2, 3, 4, 9, 10),
//                List.of(1, 2, 3, 4, 5, 7),
//                List.of(1, 2, 3, 4, 6, 7)
//        );
//    }
//    @Override
//    public void runMain() {
//        Application.main(new String[]{});
//    }
//}
