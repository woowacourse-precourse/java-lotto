package lotto.controller;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.LottoCreator;
import lotto.view.Input;
import lotto.view.Output;

import java.util.ArrayList;
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

}
