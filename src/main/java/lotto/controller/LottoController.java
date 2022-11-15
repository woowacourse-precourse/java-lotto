package lotto.controller;

import lotto.domain.*;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class LottoController {
    private static final int LOTTO_PRICE_DEFAULT_UNIT = 1000;
    private static int price;
    private static int lottoQuantity;
    private static List<Lotto> lottoContainer;
    static Lotto winningLotto;
    static Bonus bonusNumber;

    //로또 프로그램 실행 메서드
    public static void execute() {
        //금액 입력 받기
        LottoController.getPrice();
        //입력한 금액에 대한 로또 개수 구하기
        getLottoQuantity(price);
        //입력한 로또에 대한 출력 기능
        Output.printQuantity(lottoQuantity);
        //입력한 로또에 대한 목록 출력하기
        getSavedLotto(lottoQuantity);
        //당첨 번호 입력하기
        getWinningLotto();
        //보너스 번호 입력하기
        getBonusNumber();
        //당첨 통계 출력
        getResult();
    }

    public static void getPrice() {
        price = Input.inputPrice();
    }

    public static void getLottoQuantity(int price) {
        lottoQuantity = price / LOTTO_PRICE_DEFAULT_UNIT;
    }

    public static void getSavedLotto(int lottoQuantity) {
        lottoContainer = LottoCreator.saveLotto(lottoQuantity);
        Output.printAllLottoNumber(lottoContainer);
    }

    public static void getWinningLotto() {
        winningLotto = new Lotto(Input.inputWinningNumber());
    }

    public static void getBonusNumber() {
        bonusNumber = new Bonus(Input.inputBonusNumber(), winningLotto);
    }

    public static void getResult() {

        // 로또 컨테이너 안에 있는 로또 번호들과 당첨 번호를 비교해서 몇 개 일치하는지 리스트 형태로 저장
        List<Integer> countMatchNumber = LottoProcess.putMatchNumber(winningLotto, lottoContainer);
        //보너스 로또 리스트 있는지 조사
        List<Boolean> bonusInLotto = LottoProcess.putAvailableBonus(bonusNumber, lottoContainer);
        //수익률 계산하기
        double rateOfProfit = LottoProcess.calculateRateOfProfit(countMatchNumber,bonusInLotto, price);
        //결과 계산하기
        LinkedHashMap<MapMatchPrize, Integer> winningResult = LottoResult.getWinningResult(countMatchNumber, bonusInLotto);

        Output.printWinningStatics(winningResult);
        Output.printRateOfProfit(rateOfProfit);
    }
}
