## Java-Lotto 구현 기능 목록

### Manager Class
로또 구매와 관련된 메소드는 Manager Class 내에서 관리한다.

구현할 함수 목록은 아래와 같다.

1. ```purchase()```: 구입 희망 금액을 입력받은 뒤, 금액에 맞는 개수만큼의 로또를 발행하여 저장한다.


2. ```validateAmountInput(amountInput)```: ```purchase()``` 함수에서 입력받은 금액의 input 이 유효한지 검사한다. 1000 으로 나눈 나머지가 0인지 검사하여 0이 아닌 경우 ```IllegalArgumentException``` 을 발생시킨다.
   - 파라미터: 사용자가 입력한 금액 (String 형태)
   - 예외 처리:
      - 숫자가 아닌 문자가 입력되었을 때
      - 1000 단위가 아닌 숫자가 입력되었을 때

3. ```generateLottoNumber(min, max, numCount)```: 중복되지 않은 6개의 숫자로 이루어진 리스트를 오름차순으로 정렬하여 반환한다.
    - 파라미터: 랜덤 숫자 시 최소 숫자, 최대 숫자, 생성할 숫자 개수 

4. ```setPurchasedLottos(lottoCount)```:
    - 파라미터: 넘겨받은 개수만큼의 로또를 생성하고 저장한다.

5. ```getPurchasedLottos()```: 저장한 로또 정보를 반환한다.

6. ```showPurchasedLottos()```: 구입한 로또의 개수와 각각의 숫자를 프린트 한다.

7. ```start()```: 로또 구입과 구입한 로또를 프린트하는 과정을 시작하고, 당첨 번호 설정과 당첨 결과 반환 과정을 관장하는 Lotto 클래스의 메소드를 호출한다.


### Lotto Class
로또 당첨과 관련된 메소드는 Lotto Class 내에서 관리한다.

1. ```inputWinningNumber()```: 당첨번호를 입력 받고 리스트 형태로 반환한다.
2. ```validateWinningNumberInput()```: 
    - 파라미터: 당첨 번호가 담긴 리스트
    - 예외 처리:
      - 당첨번호가 6자리 숫자가 아닐 때
      - 당첨번호에 중복되는 숫자가 존재할 때