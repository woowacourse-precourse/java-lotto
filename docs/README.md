Lotto Project
=============

> 기능구현목록   
> --
> 1. [X] 로또 숫자의 범위는 1~45이다. =>MakeNumber#makeLottoNumber
> 2. [X] 중복되지 않는 6개 + 보너스 번호 1개의 숫자를 만든다. => duplicateCheck(다음숫자추가)
>   -[X] 당첨번호 입력시 6개의 번호는 쉼표로 구분하여 입력받는다
>     -[X] 1~45이내 범위가 아닐시 예외처리 [ERROR]
>   -[X] 보너스 번호를 따로 입력받는다.
> 3. [X] 사용자의 숫자는 6개 뽑는다 => makeUserNumber
>   -[X] 랜덤으로 뽑는다.
>   -[X] 중복되지 않는다.
>   -[X] 오름차순 정렬한다.
>   -[X] 한장당 금액은 1,000원이다
>   -[X] 1000원으로 나누어떨어지지않으면 예외 처리한다.[ERROR]
> 4. [X] 로또 숫자와 사용자의 숫자를 체크한다 => hasCheckNumber
>   - 1등: 6개 번호 일치 / 2,000,000,000원
>   - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
>   - 3등: 5개 번호 일치 / 1,500,000원
>   - 4등: 4개 번호 일치 / 50,000원 
>   - 5등: 3개 번호 일치 / 5,000원
> 5. [X] 수익률을 구한다.(소수점 둘째 자리에서 반올림)
> 6. [X] Check Point 
>    - Depth를 3미만으로 구성한다.
>    - 함수의 길이가 15라인을 넘지 않도록한다.
>    - Else를 사용하지 않는다.
>    - Java Enum을 사용한다. ==> 당첨등수?
>    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다. 
>    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
>    - 제공된 Lotto 클래스를 활용해 구현해야 한다.
       Lotto에 매개 변수가 없는 생성자를 추가할 수 없다.
       numbers의 접근 제어자인 private을 변경할 수 없다.
       Lotto에 필드(인스턴스 변수)를 추가할 수 없다.
       Lotto의 패키지 변경은 가능하다.


---
COMMIT TYPE
--
::

>feat: 새로운 기능
>
>fix: 버그 해결
>
>docs: 문서 변경
>
>style: formatting, 놓친 세미콜론 등... 코드의 변경은 없음
>
>refactor: 코드 리팩토링
>
>test: 테스트 코드 추가 혹은 테스트 코드 리팩토링. 코드의 변경은 없음
>
>chore: 패키지 매니저 구성, 빌드 작업 업데이트. 코드의 변경은 없음
>
::