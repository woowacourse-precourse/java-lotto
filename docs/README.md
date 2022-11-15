## 🎱 로또 게임

<br/>

### Model

>#### 🎰 Lotto
| No. |   변수명   |      역할      |
|-----|:-------:|:------------:|
| 1   | numbers | 로또 번호 6자리 저장 |       

>#### 🧑🏻‍💻 User
| No. |      변수명       |     역할     |   
|-----|:--------------:|:----------:|
| 1   |   lotteries    | 보유한 로또 리스트 |
| 2   | purchase | 구매 금액|
| 3   | winningHistory |   당첨 내역    |



>#### 🏦 Host
| No. |      변수명       |  역할   |   
|-----|:--------------:|:-----:|
| 1   | winningNumber  | 당첨 번호 |
| 2   |bonusNumber|보너스 번호|

>#### 🏆 Prize (Enum)
| No. |   변수명   |        기능        | 
|-----|:-------:|:----------------:|
| 1   |   HIT   |  등수별 일치한 숫자의 개수  |
| 2   |  MONEY  |    등수별 당첨 상금     |
| 3   | MESSAGE | 등수별 당첨 내역 안내 메시지 |
| 4   | BY_HIT  | hit -> Prize로 매핑 |



<br/></br>



### View

> #### 🎰 LottoUI
| No. |       함수명       |      기능      | 예외처리 |
|-----|:---------------:|:------------:|:----:|
| 1   |  printLottery   |    로또 출력     |  -   |


> #### 🧑🏻‍💻 UserUI
| No. |         함수명         |       기능       |  예외처리   |
|-----|:-------------------:|:--------------:|:-------:|
| 1   |  getPurchaseMoney   | 로또 구매액을 입력받음 |  4   |
| 2   | printWinningHistory |    당첨 내역 출력    |    -    |
| 3   |  printEarningsRate  |     수익률 출력     |    -    |
| 4   | printWinningResult  | 당첨 내역 + 수익률 출력 |    -    |
| 5   |   printLotteries    | 보유한 로또 출력 | - |

>#### 🏦 HostUI
| No. |         함수명         |       기능       |  예외처리   |
|-----|:-------------------:|:--------------:|:-------:|
| 1   |  getWinningNumber   | 당첨 번호 6자리를 입력받음  | 1, 2, 3 |
| 2   |   getBonusNumber    | 하나의 보너스 번호를 입력받음 |  1, 2   |


>#### 💣 ExceptionHandlerUI
| No. |        함수명        |            기능            |
|-----|:-----------------:|:------------------------:|
| 1   | printErrorMessage | 에러 메시지 출력 |

<br/></br>

### Controller

>#### 🎰 LottoController
| No. |     함수명     |    기능    |
|-----|:-----------:|:--------:|
| 1   | makeLottery | 로또 모델 생성 |
| 2   | getLottery  | 로또 모델 리턴 |


>#### 🧑🏻‍💻 UserController
| No. |         함수명          |           기능         |  
|-----|:--------------------:|:--------------------:|
| 1   |   purchaseLottery    |         로또 구매        |
| 2   |       howMuch        |         로또 발행        |
| 3   |   calWinningPrize    |         당첨금 계산       |
| 4   |   calEarningsRate    |         수익률 계산       |
| 5   | updateWinningHistory |       당첨 내역 업데이트     |
| 6   |   getWinningTimes    |      등수별 당첨 횟수 리턴    |
| 7   | convertLotteries | 로또 리스트를 출력 형식에 맞게 변경 |


>#### 🏦 HostController
| No. |      함수명      |          기능          |  
|-----|:-------------:|:--------------------:|
| 1   |  makeWinning  |       당첨 번호 생성       |
| 2   |   winOrNot    |  로또의 당첨 등수 및 여부 판별   |

>#### 💣 ExceptionHandler
| No. |           함수명           |            기능            |
|-----|:-----------------------:|:------------------------:|
| 1   |    validNumberRange     | 입력한 숫자 검증 (1 <= n <= 45) |
| 2   | validNumberDupplication |       입력한 숫자 중복 검증       |
| 3   |    validWinningForm     |       로또 입력 형식 검증        |
| 4   |    validPurchaseForm    |      입력한 구매액 형식 검증       |



>#### 🕹 Application
| No. |       함수명       |    기능     |  
|-----|:---------------:|:---------:|
| 1   |      main       | 어플리케이션 실행 | 
