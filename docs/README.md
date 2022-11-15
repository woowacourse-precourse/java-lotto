# 기능 구현 목록

## 구현 방식

- **Lotto, LottoManager, Exception, View** 네가지 패키지를 만들어 이전에 했던 과제보다 더 유지보수가 쉽게 하였다. (이전에는 한개의 파일에 여러개의 메소드를 만들어 구현하였다.)
- **Lotto** : 로또와 관련된 기능을 구현하였다.
- **LottoManager** 로또 발행과 관련된 기능을 구현하였다.
- **Execption** : 예외 처리를 담당하는 기능을 구현하였다.
- **View** : 입출력 관련한 기능을 구현하였다.

## 기능 목록

**Lotto**

    Lotto
        checkOverlap : 번호 6개가 서로 중복되는지 확인한다.
        validate : 번호 6개가 넘는지 점검한다.
    
    Application
        main : Lotto 프로젝트 실행

   
**LottoManager**

    LottoMaker
        makeLottoNumber : 1 ~ 45 사이의 로또 넘버를 생성한다.
        makeLotto : 중복되지 않은 6개의 로또 넘버를 생성한다.
        drawLotto : 받은 금액에 해당하는만큼의 로또를 발행한다.
    
    LottoChecker
        getTargetLotto : 당첨번호와 보너스 번호를 얻는다.
        compareLotto : 당첨번호와 보너스 번호를 발행한 로또와 비교한다.
        getRank : 당첨 통계를 낸다.

**Exception**    

    PurchaseMoneyException : 지불한 금액이 1000으로 나눠지지 않을경우 에러를 발생시킨다.
    WinningNumberException : 당첨 번호가 적절한 양식으로 입력되지 않을경우 에러를 발생시킨다
    BonusNumberException : 적절한 보너스 번호가 아닐경우 에러를 발생시킨다.

**View**   
    
    InputView : 구입금액, 당첨번호, 보너스 번호 입력을 받는 기능들을 구현하였다.
    OutputView : 구매한 로또, 당첨 통계, 안내문 등을 출력하는 기능을 구현하였다.