# 기능목록
## 도메인
### Lotto
1. validate
   1. isNotRightLength : 리스트의 길이가 6이 아니면 참을 반환
   2. notRightLengthException : 맞지 않은 길이에 대한 예외처리
   3. containsSameNumber : 리스트의 숫자를 셋에 담았을 때, 둘의 사이즈가 다르면 참을 반환
   4. sameNumbersException : 같은 숫자를 가짐에 예외처리
2. 생성자 : 정수형 리스트를 입력받아 validate후에 저장한다. 
3. addBonusNumber : 정수를 입력받아 전역변수에 저장시킨다. 
4. getNumbers : 정수형 리스트를 반환한다. 
5. getBonusNumber : 보너스 숫자를 반환한다. 
### Player
1. makeTickets : 입력받은 개수만큼 전역변수 tickets에 pickUniqueNumbersInRange로 리스트들을 넣어준다.
2. getTickets : List<List<Integer>형으로 티켓들을 반환한다. 
### Winning

## 예외처리
### LottoException

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