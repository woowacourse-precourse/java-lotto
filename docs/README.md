
## Description
* 로또 게임을 진행할 수 있는 서비스이다.
* 당첨 내역 및 수익률까지 확인 가능하다.

## Environment
* JDK 11.0.17+8

## Functions
**Application.java**
* validate : 입력받은 금액이 1000 단위가 아닌 예외 상황을 처리하는 함수
* input_validate : 입력받은 수가 정수가 아닌 예외 상황을 처리하는 함수
* lotto_create : 입력받은 금액에 맞게 랜덤 숫자로 이루어진 로또를 발행하는 함수
* display_lottos : 총 구매한 로또 개수 및 각 로또의 번호를 출력하는 함수
* get_prize_num : 로또가 3개 이상 일치한 경우 해당 되는 당첨 항목을 당첨 통계 리스트에 카운팅하는 함수
* display_result : 당첨 통계 및 수익률을 출력하는 함수
* get_yield : 수익률을 계산하여 반환하는 함수

**Lotto.java**
* Lotto(생성자) : 파라미터로 받은 로또 번호 리스트의 예외 여부를 확인 후 Lotto 클래스의 리스트 numbers에 담는 함수
* get_numbers : Lotto 클래스의 리스트 numbers에 접근해 데이터를 가져오는 함수(=Getter)
* validate : 파라미터로 받은 로또 번호 리스트가 예외 상황일 때 이를 처리하는 함수
* display_num : 로또 번호 리스트를 오름차순으로 정렬 후 출력하는 함수
* compare_win : 로또가 총 몇 개 당첨되었는지 카운팅하여 그 값을 반환하는 함수