# 기능목록

## 예외처리
### LottoException
validate
1. isNotRightLength : 리스트의 길이가 6이 아니면 참을 반환
2. containsSameNumber : 리스트의 숫자를 셋에 담았을 때, 둘의 사이즈가 다르면 참을 반환
3. containsNumberOutOfRange : 리스트의 숫자가 1부터 45사이가 아닌게 있으면 참을 반환
4. notRightNumberException : 예외처리 문구를 가지고 예외처리한다.

### PaymentException
1. validate
   1. isNotDividedByThousand : 값이 0이거나 1000으로 나누었을때 나머지가 0이 아니면 참을 반환
   2. isZero : 값이 0일 경우 참을 반환한다. 
   3. paymentNotAcceptableException : 예외처리한다.

### BonusNumberException
1. validate
   1. isOutOfRange : 1부터 45까지가 아닐 경우 예외처리한다. 
   2. isAlreadyInNumbers : Computer.getComputerNumber에 값이 이미 있을 경우 참을 반환한다. 
   3. outOfRangeException : 에외처리한다. 
   4. alreadyInNumberException : 예외처리한다. 

## 도메인
### Lotto
1. validate : LottoException에서 validate한다. 
2. 생성자 : 정수형 리스트를 입력받아 validate후에 저장한다.
3. getNumbers : 정수형 리스트를 반환한다. 

### BonusNumber
1. 생성자 : 정수형 입력변수를 저장한다. 컴퓨터 엔티티에서 로또번호에 포함되어있을 경우 예외처리
2. getBonusNumber : 저장한 정수형 변수를 리턴한다. 

### Profit
정수형 전역변수 payment, price를 가진다. 
1. checkPayment : 플레이어가 구매한 로또의 금액을 전역변수에 저장한다. 
2. addPrice : 입력변수 Ranking에 따른 상금을 price와 더해 저장한다.
3. getProfit : 입력변수로 당첨금액의 총합을 구해 로또 구매금액으로 백분율을 소수점 첫째 자리까지 문자열로 리턴한다. 

### Winning
HashMap<Ranking, Integer>를 가진다. 
1. 생성자 : HashMap에 모든 Ranking을 키로 가지는 value = 0의 맵을 초기화시킨다. 
2. addRankingOfPlayer : 입력받은 Ranking을 키로 가지는 value를 1씩 증가시킨다. 
3. getWinningResult : 해시맵을 반환한다. 

## enum
### Ranking
THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_MATCH_WITH_BONUS, SIX_MATCH를 가진다.

## 모델
### Player
List<Lotto>, Profit, Winning을 참조한다. 
1. buyTickets
   1. payTickets : Profit.checkPayment로 금액을 저장한다. 
   2. countTickets : 금액을 1,000으로 나눈 값을 리턴한다. 
   3. makeTickets : 입력변수로 받은 티켓의 개수만큼 로또를 만들어 List<Lotto>에 저장한다. 
2. showWinningStatistic : Winning.figureSameRanking를 리턴한다. 
3. getPlayersProfit : Profit.getProfit을 리턴한다. 
4. addLottoRanking
   1. addPlayersTicketRank : Winning.addRankingOfPlayer해준다. 
   2. addPriceOfTicket : ChangeLottoPriceService를 통해 랭킹을 금액으로 바꾸어 당첨금액을 누적시킨다.  
5. getPlayerLotto : 플레이어의 로또 리스트를 반환한다. 

### Computer
Lotto, BonusNumber를 참조한다. 
1. saveWinningTicket : 문자열로 입력받은 값을 정수형 리스트로 바꾸어 저장한다. 
   1. splitTicket : ','로 문자열을 나누어 문자열의 배열로 리턴한다. 
   2. createTicket : 정수형 리스트로 바꾸어 Lotto의 생성자에 입력변수로 사용해 저장한다. 
2. saveBonusNumber
   1. validateBonusNumber : BonusNumberException.validate을 통해 예외처리한다. 
   2. addBonusNumber : BonusNumber에 입력변수값을 정수형 변수로 저장한다.
3. getComputerNumber : 컴퓨터의 당첨번호를 Lotto타입으로 반환한다. 
4. getBonusNumber : 보너스 넘버를 정수형으로 반환한다. 

## 서비스
### MatchLotteryService
1. matchPlayerWithComputer : 컴퓨터와 플레이어를 비교해 등수를 만들어준다. 
   1. matchEachTicketWithComputer : 컴퓨터와 동일하게 가지고 있는 숫자의 개수를 리턴한다.
   2. convertCountToRanking : 같은 숫자의 개수를 받아 Ranking으로 리턴시킨다. 
      1. isFiveMatch : 같은 숫자의 개수가 5개면 참을 반환한다. 
      2. separateByBonusNumber
         1. containsBonusNumber : 로또가 보너스 넘버를 가지면 참을 반환한다.
2. makePlayerLottoByPayment : 플레이어.checkPayment한다. 
3. saveComputerNumber : 로또번호와 보너스 번호를 입력받아 컴퓨터 객체에 저장한다.

### ChangeLottoPriceService
1. changeRankingToPrice
   1. isThreeMatch : enum타입이 THREE_MATCH 면 참을 반환
   2. isFourMatch : enum타입이 FOUR_MATCH 면 참을 반환
   3. isFiveMatch : enum타입이 FIVE_MATCH 면 참을 반환
   4. isFiveMatchWithBonusNumber : enum타입이 FIVE_MATCH_WITH_BONUS_NUMBER 면 참을 반환
   5. isSixMatch : enum타입이 SIX_MATCH 면 참을 반환

## 뷰
### PlayerView
1. payMoney
   1. inquirePrice : '구입금액을 입력해 주세요.' 를 출력시킨다. 
   2. scanPrice : 가격을 입력받아 문자열로 리턴시킨다.
   3. validate : PaymentException을 통해 예외처리한다. 
2. showPlayersLotto : 플레이어 로또 구매 결과를 보여준다. 
   1. showPlayersLottoCount : 'n개를 구매했습니다.'를 출력한다. 
   2. showLottoNumbers : Lotto리스트를 한개씩 문자열로 출력한다. 

### ComputerView
1. getNumbers
   1. printRequest : 입력 변수로 '당첨 번호를 입력해 주세요.'를 넣어 출력시킨다.
   2. scanInput : 입력 문자열을 반환한다. 
   3. giveSpaceOnView : 공백 문자열을 하나 넣어준다. 
2. getBonusNumber
   1. inquireBonusNumber : 입력 변수로 '보너스 번호를 입력해 주세요.'를 넣어 출력시킨다. 
   2. scanInput : 입력 문자열을 반환한다.
   3. giveSpaceOnView : 공백 문자열을 하나 넣어준다.

### RankingView
1. startWinningStatistics : '당첨 통계\n---'를 출력한다. 
2. showPriceToPlayer : 'n개 일 (금액) - m개'를 금액이 낮은 것부터 순서대로 출력해준다.
3. showProfit : 실수형 입력변수를 '총 수익률은 x%입니다.' 를 출력한다. 

## Controller
### LotteryController