## 🎱 로또 게임


### Model

>#### 🎰 Lotto
| No. |   변수명   |      역할      |
|-----|:-------:|:------------:|
| 1   | numbers | 로또 번호 6자리 저장 |       

>#### 🏦 Host
| No. |      변수명       |  역할   |   
|-----|:--------------:|:-----:|
| 1   | winningNumber  | 당첨 번호 |
| 2   |bonusNumber|보너스 번호|
| 3   | winningHistory | 당첨 내역 |
| 4   |  earningsRate  |  수익률  |

>#### 🏆 PrizeEnum
| No. |   변수명   |        기능        | 
|-----|:-------:|:----------------:|
| 1   | message | 등수별 당첨 내역 안내 메시지 |
| 2   |  money  |    등수별 당첨 상금     |  
|3| hit|  등수별 일치한 숫자의 개수  |



<br/></br>



### View

> #### 🎰 LottoUI
| No. |       함수명       |        기능         | 예외처리 |
|-----|:---------------:|:-----------------:|:----:|
| 1   | getLotterySales | 로또 구매액을 입력받음 |  4   |
| 2   |  printLottery   | 발행한 로또 수량 및 번호 출력 |  -   |


>#### 🏦 HostUI
| No. |         함수명         |       기능       |  예외처리   |
|-----|:-------------------:|:--------------:|:-------:|
| 1   |  getWinningNumber   | 당첨 번호 6자리를 입력받음  | 1, 2, 3 |
| 2   |   getBonusNumber    | 하나의 보너스 번호를 입력받음 |  1, 2   | 
| 3   | printWinningHistory |    당첨 내역 출력    |    -    |
| 4   |  printEarningsRate  |     수익률 출력     |    -    |
| 5   | printLotteryResult  | 당첨 내역 + 수익률 출력 |    -    |

>#### 💣 ExceptionHandlerUI
| No. |        함수명        |            기능            |
|-----|:-----------------:|:------------------------:|
| 1   | printErrorMessage | 에러 메시지 출력 |

<br/></br>

### Controller

>#### 🎰 LottoController
| No. |     함수명     |      기능      |
|-----|:-----------:|:------------:|
| 1   | makeLottery | 로또 번호 6자리 생성 |
| 2   |   howMuch   |  로또 구매 및 발행  |    

>#### 🏦 HostController
| No. |        함수명        |        기능         |  
|-----|:-----------------:|:-----------------:|
| 1   |    makeWinning    |     당첨 번호 생성      |
| 2   |     winOrNot      | 로또의 당첨 등수 및 여부 판별 | 
| 3   | setWinningHistory |     당첨 내역 저장      |
| 4   |  calEarningsRate  |      수익률 계산       |  

>#### 💣 ExceptionHandler
| No. |           함수명           |            기능            |
|-----|:-----------------------:|:------------------------:|
| 1   |    validNumberRange     | 입력한 숫자 검증 (1 <= n <= 45) |
| 2   | validNumberDupplication |       입력한 숫자 중복 검증       |
| 3   |    validLotteryForm     |       로또 입력 형식 검증        |
| 4   |     validSalesForm      |      입력한 구매액 형식 검증       |



>#### 🕹 Application
| No. |       함수명       |    기능     |  
|-----|:---------------:|:---------:|
| 1   |      main       | 어플리케이션 실행 | 
