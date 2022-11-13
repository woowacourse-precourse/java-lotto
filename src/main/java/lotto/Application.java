package lotto;

import java.util.List;

public class Application {

    /**
     * 입력한 금액을 바탕으로 구매한 로또의 개수를 반환(로또 1장 당 1000원)
     * @return 구매한 로또의 개수
     */
    public static int buyLotto(){
        // TODO: 구입 금액을 입력 받고, 입력한 금액으로 살 수 있는 로또의 개수 반환
        // TODO: 구입 금액이 1000 단위로 떨어지지 않을 경우 예외처리
        return 0;
    }

    /**
     * 1~45 사이의 랜덤한 로또 번호 6자리를 선택
     * @param count 구매한 로또의 개수
     * @return 구매한 로또 개수 크기의 로또 번호가 들어있는 리스트
     */
    public static List<Lotto> pickLottoNumber(int count){
        // TODO: 구매한 로또 당 로또 번호 6자리를 랜덤으로 선택
        return null;
    }

    /**
     * 당첨 번호를 입력받음
     * @return 당첨 번호
     */
    public static Lotto pickLuckyNumber(){
        // TODO: 쉼표로 구분된 1~45 사이의 숫자 6개를 입력받아 리턴
        // TODO: 잘못된 값을 입력했을 경우 예외처리
        return null;
    }

    /**
     * 보너스 번호를 입력받음
     * @return 보너스 번호
     */
    public static int pickBonusNumber(){
        // TODO: 보너스 숫자 하나를 입력받아 리턴
        // TODO: 잘못된 값을 입력했을 경우 예외처리
        return 0;
    }

    /**
     * 로또 번호들과 당첨 번호를 비교하여 당첨 결과를 반환
     * @param lottos 로또 번호들
     * @param luckyNumber 당첨 번호
     * @param BonusNumber 보너스 숫자
     * @return
     */
    public static List<Prize> getLottoResult(List<Lotto> lottos, Lotto luckyNumber, int BonusNumber){
        // TODO: 로또 번호들과 당첨 번호 및 보너스 숫자를 비교하여 결과 도출
        return null;
    }

    /**
     * 로또 구매 금액과 당첨 금액을 바탕으로 수익률을 계산
     * @return 수익률
     */
    public static float getProfitRate(int buyingCharge, int profit){
        // TODO: 로또 구매 금액과 당첨 금액을 바탕으로 수익률 계산
        return 0f;
    }

    /**
     * 당첨 결과 상수를 정의하고 있는 enum
     */
    enum Prize{
        // TODO: 당첨 결과 enum 구현
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
