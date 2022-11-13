## Requirement list

### Core logic

#### Validate payment

- Raise 'IllegalArgumentException' if cash divided by 1000 is not '0'

#### Generate lotto number

- Generate lotto cases
- return type: List<List<Integer>>

#### Number match

- confirm if two number match
- return type: int

#### Get individual lotto score

- Count the matching numbers and return
- return type: int

#### Calculate lotto result

- Calculate each lotto case and turn it into score
- Make integer array to store data
- return type: List<Integer>

#### Calculate yield

- Calculate its yield and return
- return type: String

### UI logic

#### Input total payment

- Read cash and cast to integer

#### Error Handler

- Throw IllegalArgumentException if there's an invalid input
- throw Error: "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."

#### Input lotto number

- Read lotto number, split, and cast each number to int

#### Input bonus number

- Read bonus number and cast to integer

#### Show lotto payment receipt

- Print the amount of lotto purchased
- Print the whole list of lotto

#### Show total winning result

- Get the result and print the result
- return type: void

