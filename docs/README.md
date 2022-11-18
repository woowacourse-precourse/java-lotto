# 기능 구현 목록

```
완성된 기능 구현 항목은 x표시를 한다.
필요한 항목은 개발을 하다가 중간에 또한 추가하도록 한다.
```

- - -

## console : 입출력 처리

- Input 클래스
  - (x)inputNumber : 숫자 입력 메소드
  - (x)inputSixNumber : 쉼표로 구분된 6자 입력 메소드

- Output 클래스
  - (x)printLotto : 로또 리스트 출력 메소드
  - (x)printStatistics : 당첨 통계 --- 출력 메소드
  - (x)printGrading : 맞춘 개수와 가격 및 해당 개수 출력 메소드
  - (x)printRevenueRate : 수익률 출력 메소드
  - (x)printBuyLotto : 로또 살때 출력 메소드
  - (x)printInputWinningNumber : 당첨 번호를 입력 받을때 출력 메소드
  - (x)printInputBonusNumber : 보너스 번호를 입력 받을때 출력 메소드
  - (x)printInputCost : 구매 금액을 입력 받을때 출력 메소드

- - -

# controller : 데이터 입력에 맞는 서비스를 선택하여 처리

- BuyLottoController 클래스 
  - (x)inputCost : 구입금액에 입력 메소드
  - (x)createLottoNumber : 구입금액에 대한 로또 번호 생성 메소드
  - (x)runBuyLottoController : 해당 클래스의 로직 총 실행 메소드

- StatisticController 클래스
  - (x)updateStatisticCount : count 배열의 횟수 업데이트 메소드
  - (x)recordGrade : 숫자 맞춘 개수 기록 메소드
  - (x)recordRevenueRate : 수익률 기록 메소드
  - (x)runStatisticController : 해당 클래스의 로직 총 실행 메소드

- WinningLottoController 클래스
  - (x)createWinningLotto : 당첨 번호에 대한 당첨 로또 생성 메소드
  - (x)addBonusNumber : 보너스 번호에 대한 처리 메소드
  - (x)runWinningLottoController : 해당 클래스의 로직 총 실행 메소드

- - -

## domain : 어떤 특성들을 가지고 있는 클래스들 

- Lotto 클래스
  - (x)로또 번호 배열 반환 메소드
  - (x)getter 메소드

- Statistic enum 클래스
  - (x) msg, revenue를 가진 생성자들
  - (x) getRevenue : 인덱스에 맞는 수익 반환 메소드
  - (x) getMsg : 인덱스에 맞는 메시지 반환 메소드

- - -

## service : 비즈니스 로직 하나하나를 처리, 트랜잭션, 재사용 가능하게 작성, 따라서 java 의 내장함수만 사용하도록

- Calculator 클래스
  - (x)getCost : costMemory 에 기록한 cost 반환 메소드
  - (x)lottoNumbersPerCost : 가격을 넣으면 로또 개수가 나오는 메소드 정의
  - (x)scalingStatisticIndex : 당첨 번호와 보너스 번호에 따른 인덱스 리턴 메소드
  - (x)calculateRevenueRate : 수익률 계산 메소드 정의
  - (x)intersection : list 끼리 교집합 메소드 정의

- Validation 클래스
  - (x)isInRange : 숫자 범위 검증 메소드
  - (x)isUp : 최소보다 이상인지 검증하는 메소드
  - (x)isMultiplesOf1000 : 1000의 배수 검증 메소드
  - (x)isLotto : 리스트의 원소들이 로또 번호에 맞는지 검증 메소드
  - (x)isNumber : 문자열의 숫자 형태 검증 메소드
  - (x)isSixNumber : 리스트가 6개의 원소인지 검증 메소드
  - (x)isNonContains : 리스트에 숫자가 포함 안되어 있는지 검증 메소드

- - -

# Application : client 측면의 게임 실행자가 봤을때, 로또 게임을 할려는 수요자
- main 에서 Controller 의 LottoController 객체를 실행한다.

- - -

# LottoPlay : 로또 실행 객체
- (x)run : Controller 들을 순차적으로 실행하는 run 메소드
