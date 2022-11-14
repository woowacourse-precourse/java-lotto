# java-lotto

------

## 기능 목록
1. 게임 실행
   - 전체 게임을 실행하는 기능
<br><br>
2. 구입 금액을 입력받는다.
   - 구입 금액에 대한 유효성 검사를 시행
   <br><br>
3. 금액에 따른 개수만큼 로또를 생성한다.
   - 1~45 사이의 숫자 6개를 중복없이 골라 번호를 생성
   - 로또 번호에 대한 유효성 검사 시행
   <br><br>
4. 유효성 검사 기능
- 다음 상황에서 `IllegalArgumentException` 오류를 뿌리고, 프로그램을 종료한다.
  - 구입금액
    - 구입 금액이 1000으로 나눠떨어지지 않는 경우
    - 문자가 들어있는 경우
  - 로또 번호
    - 길이가 6이 아닌 경우
    - 문자가 들어있는 경우
    - 1 ~ 45 사이의 숫자가 아닌 경우
    - 중복 문자인 경우
  - 보너스 번호
    - 번호가 1~45 사이의 숫자가 아닌 경우

5. 보너스 번호를 입력받는다.
   - 1 ~ 45 사이의 번호가 아닌 경우 
   - 당첨 번호와 중복될 경우
<br><br>
6. 통계를 저장하고 출력한다.
   - 당첨 번호와 보너스번호, 사용자가 구매한 로또를 비교.
   - 로또 등수와 등수 당 몇 개 일치하는지 출력.
   - 총 수익률 출력.
<br><br>
-------
- model(domain)
  - Lotto
  - LottoInput
  - LottoResult
  - LottoStatistics
- controller
  - InputController
  - LottoController
- util
  - InputValidator
  - RandomLottoGenerator
- view 
  - InputView
  - ResultView
- constant
  - Rank
  - WinPrize