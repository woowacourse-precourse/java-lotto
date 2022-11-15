package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

//    @Test
//    void 기능_테스트() {
//        assertRandomUniqueNumbersInRangeTest(
//                () -> {
//                    run("8000", "1,2,3,4,5,6", "7");
//                    assertThat(output()).contains(
//                            "8개를 구매했습니다.",
//                            "[8, 21, 23, 41, 42, 43]",
//                            "[3, 5, 11, 16, 32, 38]",
//                            "[7, 11, 16, 35, 36, 44]",
//                            "[1, 8, 11, 31, 41, 42]",
//                            "[13, 14, 16, 38, 42, 45]",
//                            "[7, 11, 30, 40, 42, 43]",
//                            "[2, 13, 22, 32, 38, 45]",
//                            "[1, 3, 5, 14, 22, 45]",
//                            "3개 일치 (5,000원) - 1개",
//                            "4개 일치 (50,000원) - 0개",
//                            "5개 일치 (1,500,000원) - 0개",
//                            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
//                            "6개 일치 (2,000,000,000원) - 0개",
//                            "총 수익률은 62.5%입니다."
//                    );
//                },
//                List.of(8, 21, 23, 41, 42, 43),
//                List.of(3, 5, 11, 16, 32, 38),
//                List.of(7, 11, 16, 35, 36, 44),
//                List.of(1, 8, 11, 31, 41, 42),
//                List.of(13, 14, 16, 38, 42, 45),
//                List.of(7, 11, 30, 40, 42, 43),
//                List.of(2, 13, 22, 32, 38, 45),
//                List.of(1, 3, 5, 14, 22, 45)
//        );
//    }
//
//    @Test
//    void 예외_테스트() {
//        assertSimpleTest(() -> {
//            runException("1000j");
//            assertThat(output()).contains(ERROR_MESSAGE);
//        });
//    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void 구매금액_숫자_확인() {
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        assertThat(purchaseAmount.checkNumeric("123")).isEqualTo(true);
        assertThat(purchaseAmount.checkNumeric("123a")).isEqualTo(false);
    }

    @Test
    public void 구매금액_1000단위_확인() {
        PurchaseAmount purchaseAmount = new PurchaseAmount();
        assertThat(purchaseAmount.checkUnit(123000)).isEqualTo(true);
        assertThat(purchaseAmount.checkUnit(12300)).isEqualTo(false);
    }

    @Test
    public void 발행로또수량_계산_확인() {
        PurchaseAmount purchaseAmount = new PurchaseAmount();

        assertThat(purchaseAmount.calculatePurchaseNumber(123000)).isEqualTo(123);
    }

    @Test
    public void 로또_발행_확인() {
        Publishing publishing = new Publishing();

        int length = 8;
        publishing.publishingLotto(length);
        assertThat(publishing.getLottoList().size()).isEqualTo(length);
    }

    @Test
    public void 각_로또번호_발행_확인() {
        Publishing publishing = new Publishing();

        List<Integer> numbers = publishing.makeLottoNumber();

        assertThat(numbers.size()).isEqualTo(6);

        for (int i=0; i< numbers.size(); i++) {
            assertThat(numbers.get(i))
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(45);
        }
    }

    @Test
    public void 당첨번호_입력_확인() {
        LuckyNumber luckyNumber = new LuckyNumber();

        List<Integer> numbers = luckyNumber.changeStringToInteger("1,2,3,4,5,6");

        assertThat(numbers.size()).isEqualTo(6);

        for (int i=0; i< numbers.size(); i++) {
            assertThat(numbers.get(i))
                .isGreaterThanOrEqualTo(1)
                .isLessThanOrEqualTo(45);
        }
    }

    @Test
    public void 두_리스트_같은값_개수세기_확인() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.countEqualLottoNumber(List.of(3,4,5,6,7,8))).isEqualTo(4);
    }

    @Test
    public void 보너스번호_일치_확인() {
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));

        assertThat(lotto.isEqualBonusNumber(4)).isEqualTo(true);
        assertThat(lotto.isEqualBonusNumber(7)).isEqualTo(false);
    }

    @Test
    public void 당첨통계_계산() {
        LuckyCheck luckyCheck = new LuckyCheck();

        List<Lotto> lottoList = new ArrayList<Lotto>();

        Lotto lotto1 = new Lotto(List.of(1,7,8,9,10,11));
        Lotto lotto2 = new Lotto(List.of(1,2,7,8,9,10));
        Lotto lotto3 = new Lotto(List.of(1,2,3,7,8,9));
        Lotto lotto4 = new Lotto(List.of(1,2,3,4,7,8));
        Lotto lotto5 = new Lotto(List.of(1,2,3,4,5,7));
        Lotto lotto6 = new Lotto(List.of(1,2,3,4,5,6));
        Lotto lotto7 = new Lotto(List.of(1,2,3,4,5,17));

        lottoList.add(lotto1);
        lottoList.add(lotto2);
        lottoList.add(lotto3);
        lottoList.add(lotto4);
        lottoList.add(lotto5);
        lottoList.add(lotto6);
        lottoList.add(lotto7);

        List<Integer> luckyNumber = List.of(1,2,3,4,5,6);
        Integer bonusNumber = 17;

        luckyCheck.checkLuckyLottos(lottoList, luckyNumber, bonusNumber);

        assertThat(luckyCheck.getLuckyLotto()).isEqualTo(List.of(1,1,1,1,1));
        assertThat(luckyCheck.getLuckyMoney()).isEqualTo(2031555000);
    }
}
