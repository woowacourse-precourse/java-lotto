<h1>로또 게임 기능 단위 목록 작성</h1>
<hr>

## Domain

### Lotto
- setWinLottoNumbers() : 당첨번호의 6개 넘버를 입력받고 저장해주는 메서드
- getWinLottoNumbers() : 당첨번호의 6개 넘버를 반환해주는 메서드
- getWinBonusLottoNumbers() : 보너스 넘버를 입력받고 저장해주는 메서드


### User
- setUserLottoNumbers() : 유저가 구매한 로또의 6개의 랜덤 넘버를 정해주는 메서드  
- getUserLottoNumbers() : 6개의 로또 넘버를 반환해주는 메서드

## Enum

Rank : 순위 결정 : FIRST, SECOND, THIRD, FOURTH, FIFTH

## Service

### GameService 

- countContainUserNumberAndComputerNumber() : 유저넘버에 컴퓨터넘버가 포함되는지 check 해주는 메서드
- countContainUserNumberAndComputerBonusNumber() : 유저넘버에 컴퓨터보너스넘버가 포함되는지 check 해주는 메서드
- calculateEarningRate() : 수익률을 계산해주는 메서드
- calculateLottoCount() : 로또 개수를 계산해주는 메서드


## Controller

### GameController 

- StartLottoGame() : 로또 게임을 실행해주는 메서드
## View

### InputView
- printMoneyOfLotto() : 로또 금액을 입력하는 메서드
- printLuckyNumber() : 로또 당첨 번호 리스트를 입력하는 메서드
- printBonusNumber() : 로또 보너스 넘버를 입력하는 메서드 



### OutputView 
- printOutputOfUserNumber() : 로또를 구매한 개수에 따라서 리스트를 반환해주는 메서드
- printOutputOfLottoScore() : 당첨 통계를 출력해주는 메서드 
- printEarningRateOfLottoGame() : 로또 게임의 총 수익률를 출력해주는 메서드 


## Exception


### lottoException  
- checkNumberAboutOnlyNumber() : 당첨번호의 입력받은 값이 숫자로만 이루어져 있는지 check 해주는 메서드
- checkNumberAboutAscendingOrder() : 당첨번호의 입력받은 값의 리스트가 오름차순 정렬 되어있는지 check 해주는 메서드
- checkNumberBetweenOneAndFortyFive() : 당첨번호의 입력받은 값의 범위가 1~45인지 check 해주는 메서드