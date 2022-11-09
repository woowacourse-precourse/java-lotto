package lotto;

/*
 * [필요 기능 명세]
 * [O] 랜덤 로또 번호 생성
 * [O] 당첨금 enum class 생성
 * [X] 당첨 로또 번호 입력
 * [X] 당첨 통계 계산
 * [X] 총 수익률 계산
 * [O/X] 입력 예외 처리(로또 구매 갯수 / 당첨 로또번호 입력)
 * [X] 단위 테스트 생성
 * [X] 테스트 확인
 */

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int LOTTO_PRICE = 1000;

    public enum WINNINGS{
        FIRST(2000000000),
        SECOND(30000000),
        THIRD(1500000),
        FOURTH(50000),
        FIFTH(5000);

        int value;

        private WINNINGS(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Lotto> userLotto = new ArrayList<>();

        try {
            int purchaseLottoPrice= Integer.parseInt(Console.readLine());
            int purchaseLottoAmount = purchaseLottoPrice / LOTTO_PRICE;

            validateLottoPrice(purchaseLottoPrice);
            purchaseLotto(userLotto, purchaseLottoAmount);
            printUserLottoList(userLotto, purchaseLottoAmount);

        } catch(IllegalArgumentException e){
            System.out.println(ERROR_MESSAGE + " " + e.getMessage());
        }
    }

    private static void purchaseLotto(List<Lotto> userLotto, int purchaseLottoAmount) {
        for(int i = 0; i < purchaseLottoAmount; i++)
            userLotto.add(createRandomLottoList());
    }

    private static void printUserLottoList(List<Lotto> userLotto, int purchaseLottoAmount) {
        System.out.println(purchaseLottoAmount + "개를 구매했습니다.");

        for (Lotto lotto : userLotto) {
            lotto.printLottoNumbers();
        }
    }

    private static void validateLottoPrice(int purchaseLottoPrice) {
        if(purchaseLottoPrice < LOTTO_PRICE)
            throw new IllegalArgumentException("1개 이상 구매해야 합니다.");
        if(purchaseLottoPrice % LOTTO_PRICE != 0)
            throw new IllegalArgumentException(LOTTO_PRICE + "단위로 입력하여야 합니다.");
    }

    private static Lotto createRandomLottoList() {
        Lotto newLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6).stream().sorted().collect(Collectors.toList()));

        // System.out.println(numbers.toString());

        return newLotto;
    }
}
