## 기능목록

### 예외처리 - IllegalArgumentException
- [X] 모든 예외 메시지의 "[ERROR]" 를 앞에 붙여 출력. - ExceptionUtil.class

### 어플리케이션 (비즈니스 로직)
#### Lotto 관련 서비스 - LottoServiceUseCase
- [X] buyLotto 구현 
- [X] matchWinningNumber 구현
- [X] ConvertLotto 구현

#### Lotto 결과 분석 관련 서비스 - LottoWinningStatisticsUseCase
- [X] analyzeRevenue 구현

### 도메인 
#### Money
- [X] 유효성 검사

#### Bonus
- [X] 유효성 검사

#### Lotto

### View - 화면에 보여지는 것을 담당하는 클래스.
- [X] 로또 거래 View - BuyLottoView
  - [X] 구입금액 입력 View
  - [X] 구매한 로또의 정보를 보여주는 View
    - [X] 구매한 로또의 개수를 보여주는 View
    - [X] 구매한 로또의 번호를 보여주는 View

- [X] 당첨 로또에 대한 View - LottoAnswerView
  - [X] 당첨 번호 View
  - [X] 보너스 번호 View

- [X] 당첨 결과에 대한 View - ResultView
  - [X] 당첨 결과에 대한 View
  - [X] 수익률에 대한 View
