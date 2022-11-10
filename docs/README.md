# 기능 구현 목록

```
완성된 기능 구현 항목은 x표시를 한다.
필요한 항목은 개발을 하다가 중간에 또한 추가하도록 한다.
```

- - -

## console : 입출력 처리

- Input 클래스
  - (  )inputCost : 구입금액 입력 메소드
  - (  )inputWinningNumbers : 당첨 번호 입력 메소드
  - (  )inputBonusNumber : 보너스 번호 입력 메소드

- Output 클래스
  - BufferedWriter 내부클래스
    - (  )writeBuyLotto : ~개를 구매했습니다. streamWriter 메소드 정의
    - (  )writeLotto : 로또 번호 1개 streamWriter 메소드
    - (  )writeStatistics : 당첨 통계 streamWriter 메소드
    - (  )writeGrading : ~개 일치, ~원 streamWriter 메소드
    - (  )writeGradingWithBonusNumber : 5개 일치, 보너스 볼 일치, ~원 streamWriter 메소드
    - (  )writeRevenueRate : 총 수익률 streamWriter 메소드
    - (  )writeNewLine : 띄어쓰기 streamWriter 메소드

  - ErrorWriter 내부클래스
    - 에러가 나올 수 있는 경우들의 메소드들을 개발 진행에 따라 정의한다.

  - (  )printWhenInputWinningNumber : 당첨 번호를 입력 받을때 출력 메소드
  - (  )printWhenInputBonusNumber : 보너스 번호를 입력 받을때 출력 메소드
  - (  )printWhenInputCost : 구매 금액을 입력 받을때 출력 메소드
  - (  )printBufferdStream : Buffered 출력 메소드

- - -

# controller : 데이터 입력에 맞는 서비스를 선택하여 처리

- BuyLottoController 클래스 
  - (  )inputCost : 구입금액에 입력 메소드
  - (  )calculateLottoNumberPerCost : 구입금액에 대한 로또 개수 계산 메소드
  - (  )createLottoNumber : 구입금액에 대한 로또 번호 생성 메소드
  - (  )printLottoNumber : 구입금액에 대한 로또 번호 출력 메소드
  - (  )runBuyLottoController : 해당 클래스의 로직 총 실행 메소드

- WinningLottoController 클래스
  - (  )inputWinningLotto : 당첨 번호에 대한 입력 메소드
  - (  )createWinningLotto : 당첨 번호에 대한 당첨 로또 생성 메소드
  - (  )inputBonusNumber : 보너스 번호에 대한 입력 메소드
  - (  )recordBonusNumber : 보너스 번호 등록 메소드
  - (  )printStatistics : 당첨 통계 출력 메소드
  - (  )runWinningLottoController : 해당 클래스의 로직 총 실행 메소드

- - -

## domain : 어떤 특성들을 가지고 있는 클래스들 

- Lotto 클래스
  - (  )로또 번호 배열 반환 메소드

- WinningLotto 클래스
  - (  )로또 클래스 상속
  - (  )validate 클래스 오버라이딩

- - -

## service : 비즈니스 로직 하나하나를 처리, 트랜잭션, 재사용 가능하게 작성, 따라서 java 의 내장함수만 사용하도록

- Calculator 클래스
  - (  )lottoNumbersPerCost : 가격을 넣으면 로또 개수가 나오는 메소드 정의
  - (  )calculateRevenueRate : 수익률 계산 메소드 정의
  - (  )countMatchedLotto : 로또 번호와 당첨 번호 일치 개수 계산 메소드
  - (  )matchWithBonus : 보너스 번호 일치 계산 메소드

- Validation 클래스
  - (  )isInRange : 숫자 범위 검증 메소드
  - (  )isMultiplesOf1000 : 1000의 배수 검증 메소드
  - (  )isInLotto : 로또에 원소 포함 여부 메소드

- - -

# Application : client 측면의 게임 실행자가 봤을때, 로또 게임을 할려는 수요자
- main 에서 Controller 의 LottoController 객체를 실행한다.

- - -

# LottoPlay : 로또 실행 객체
- (  )run : Controller 들을 순차적으로 실행하는 run 메소드
