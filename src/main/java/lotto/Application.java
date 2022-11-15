package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //저장소(LottoModel) 초기화
        LottoModel userLottoModel = new LottoModel();
        //구입 금액 입력
        String money = LottoView.moneyInput();
        //금액 유효성 검사
        if (money.matches("(.*)[^0-9](.*)")) {
            System.out.println("[ERROR] 금액은 1000원 단위만 가능합니다.");
            return;
        }
        if(Integer.parseInt(money)%LottoEnum.PRICE.getValue()!=0){
            System.out.println("[ERROR] 금액은 1000원 단위만 가능합니다.");
            return;
        }
        //금액만큼 로또 발행 및 저장
        int theNumberOfLotto = Integer.parseInt(money)/LottoEnum.PRICE.getValue();
        userLottoModel.saveIssueLotto(theNumberOfLotto);
        //당첨번호 입력
        List<Integer> winNumber = LottoView.winNumber();
        //당첨번호 저장
        userLottoModel.saveWinNumbers(winNumber);
        //보너스번호 입력
        Integer bonusNumber = LottoView.bonusNumber();
        //보너스번호 저장
        userLottoModel.saveBonusNumber(bonusNumber);
        //저장된 당첨,보너스 번호의 중복검사
        LottoView.sameValidation(userLottoModel.getSavedWinNumbers(),userLottoModel.getSavedBonusNumber());
        //당첨 프로세스 실행
        int first = LottoController.first(userLottoModel);
        int second = LottoController.second(userLottoModel);
        int third = LottoController.third(userLottoModel);
        int fourth = LottoController.fourth(userLottoModel);
        int fifth = LottoController.fifth(userLottoModel);
        //발행된 로또 출력
        LottoView.printIssueLotto(theNumberOfLotto,userLottoModel);
        //결과 출력
        LottoView.printResult(first,second,third,fourth,fifth);
        //수익률 출력
        LottoView.printEarningRate(theNumberOfLotto,first,second,third,fourth,fifth);
    }
}
