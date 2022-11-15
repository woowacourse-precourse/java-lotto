## 기능 구현 목록

### 입력
[✅] 로또 구입 금액 입력. 1000으로 나눠떨어지지 않는 경우 예외 처리 - User#lotteryPurchaseAmount<br>
[✅] 당첨번호 입력. 쉼표 기준 - User#winningNumber<br>
[✅] 보너스 번호 입력 - User#bonusNumber <br>
[✅] 입력값들 숫자 아닐때 예외처리 <br>
[✅] 로또 번호 1~45 사이 아니면 예외처리 <br>
[✅] 예외 발생 시 IllegalArgumentException 발생<br>
<hr>

### 로또
[✅] 로또 번호 발행 - RandomNumGenerator#makeUniqueLottoNum <br>
[✅] 로또 번호 중복 확인 - Lotto#validate<br>
[✅] 로또 숫자 6개 확인 - Lotto#validate<br>
[✅] 로또 번호 범위 1~45 확인 - Lotto#validate<br>
[✅] 발행한 로또 번호 오름차순 정렬 - Lotto#sortAscending<br>
[✅] 예외 발생 시 IllegalArgumentException 발생 <br>

<hr>

### 출력 
[✅] 발행한 로또 수량 및 번호 출력 - Print#lottoInfo <br>
[✅] 당첨 내역 출력 - Print#lottoWinningHistory<br>
>n개 일치, 보너스 볼 일치 (금액) - 0개<br>
>
[✅] 수익률 출력. 소수점 둘째자리 반올림 - Print#yield<br>
> 총 수익률은 #%입니다.<br>
> 
[✅] 예외 발생 시 예외 문구 출력 <br>
> [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.

 
<hr>

### 당첨 계산
[✅] 3개 번호만 일치하는 로또 수 count - Winning#three <br>
[✅] 4개 번호만 일치하는 로또 수 count - Winning#four <br>
[✅] 5개 번호만 일치하고 보너스 볼 일치안하는 로또 수 count - Winning#fiveNotBonus <br>
[✅] 5개 번호만 일치하고 보너스 볼 일치하는 로또 수 count - Winning#fiveWithBonus <br>
[✅] 6개 번호 일치하는 로또 수 count - Winning#six <br>

<hr>

### 과제 요구사항 
[] indent depth 2까지<br>
[] 3항 연산자 사용 금지<br>
[] 메소드는 한가지 기능만<br>
[] 함수(메소드) 길이 15줄 이하<br>
[] java enum 사용<br>
[] 도메인 로직에 단위 테스트 구현




