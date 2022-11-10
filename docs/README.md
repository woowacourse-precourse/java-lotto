# 기능목록
## 도메인 모델
### Lotto
1. validate : LottoException에서 validate한다. 
2. 생성자 : 정수형 리스트를 입력받아 validate후에 저장한다.

### BonusNumber
1. 생성자 : 정수형 입력변수를 저장한다. 컴퓨터 엔티티에서 로또번호에 포함되어있을 경우 예외처리
2. getBonusNumber : 저장한 정수형 변수를 리턴한다. 

### Winning
1. 생성자 : 개수와 등수 리스트를 입력받아 저장한다. 
2. getRankings : '3개 일치'부터 '6개 일치까지'를 리스트로 리턴한다. 
3. sumPrice : 리스트의 등수에 따라 금액을 합해 리턴한다. 

### Profit
1. checkPayment : 플레이어가 구매한 로또의 금액을 전역변수에 저장한다. 
2. getProfit : 입력변수로 당첨금액의 총합을 구해 로또 구매금액으로 백분율을 리턴한다. 

## 엔티티
### Player
List<Lotto>, Profit, Winning을 참조한다. 
1. buyTickets
   1. Profit.checkPayment로 금액을 저장한다. 
   2. countTickets : 금액을 1,000으로 나눈 값을 리턴한다. 
   3. makeTickets : 입력변수로 받은 티켓의 개수만큼 로또를 만들어 List<Lotto>에 저장한다. 
2. showWinningStatistic : Winning.getRankings를 리턴한다. 
3. getPlayersProfit : Winning.sumPrice의 값을 Profit.getProfit을 해 소수점 첫째 자리까지 리턴한다. 

### Computer
Lotto, BonusNumber를 참조한다. 
1. saveWinningTicket : 문자열로 입력받은 값을 정수형 리스트로 바꾸어 저장한다. 
   1. splitTicket : ','로 문자열을 나누어 문자열의 배열로 리턴한다. 
   2. createTicket : 정수형 리스트로 바꾸어 Lotto의 생성자에 입력변수로 사용해 저장한다. 
2. saveBonusNumber : BonusNumber에 입력변수값을 정수형 변수로 저장한다. 

## 예외처리
### LottoException
validate
1. isNotRightLength : 리스트의 길이가 6이 아니면 참을 반환
2. notRightLengthException : 맞지 않은 길이에 대한 예외처리
3. containsSameNumber : 리스트의 숫자를 셋에 담았을 때, 둘의 사이즈가 다르면 참을 반환
4. sameNumbersException : 같은 숫자를 가짐에 예외처리

## 서비스
### LottoService

### PlayerService

### WinningService

## 뷰
### PlayerView
1. inquirePrice : '구입금액을 입력해 주세요.' 를 출력시킨다. 
2. scanPrice : 가격을 입력받아 문자열로 리턴시킨다. 
3. showTicketCount
   1. calculateTicketCount : 가격 / 1000으로 티켓 개수를 리턴한다. 
   2. showCount : '가격/1000개를 구매했습니다' 를 출력한다. 
4. showPlayersTickets : StringBuilder에 정수형 리스트 티켓을 한개당 한줄씩 출력해준다.
### LottoView
1. inquireNumbers : '당첨 번호를 입력해 주세요.'를 출력한다. 
2. scanNumbers : ','로 구분되는 숫자의 문자열을 반환한다. 
3. inquireBonusNumber : '보너스 번호를 입력해 주세요.'를 출력한다. 
4. scanBonusNumber : 보내스 숫자를 문자열로 반환한다.
### WinningView

## Controller
### LotteryController