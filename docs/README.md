## 기능목록

### Starter
- 게임 시작 

### Controller
- LottoController (게임기능 관련 조작 컨트롤러)
- InputController (입력값 받을 때 사용 하는 컨트롤러)

### 예외처리 - IllegalArgumentException
- [X] 모든 예외 메시지의 "[ERROR]" 를 앞에 붙여 출력. 

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
- [X] 유효성 검사

#### Result
- [X] Reward 모델과 매칭.

#### Reward & RewardTable
- [X] 로또 당첨이 몇개 되었는지 확인 기능.


### View - 화면에 보여지는 것을 담당하는 클래스.
- [X] 로또 거래 View - BuyLottoView
  - [X] 구입금액 입력 View
  - [X] 구매한 로또의 정보를 보여주는 View
    - [X] 구매한 로또의 개수를 보여주는 View
    - [X] 구매한 로또의 번호를 보여주는 View

<br>

- [X] 당첨 로또에 대한 View - LottoAnswerView
  - [X] 당첨 번호 View
  - [X] 보너스 번호 View

<br>

- [X] 당첨 결과에 대한 View - ResultView
  - [X] 당첨 결과에 대한 View
