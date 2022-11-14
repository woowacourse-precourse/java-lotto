## Requirement list

### Core logic

#### Validate payment

- Raise 'IllegalArgumentException' if cash divided by 1000 is not '0'

#### Check number range

- Raise 'Illegal Argument Exception' if each number is not in the valid range

#### Check duplication

- Raise 'IllegalArgumentException' if there are duplicated numbers

#### Input lotto number

- Read lotto number, split, and cast each number to int

#### Generate lotto number

- Generate lotto cases
- return type: List<List<Integer>>

#### Check number match

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

- Read cash and return


#### Input bonus number

- Read bonus number and cast to integer

#### Show lotto payment receipt

- Print the amount of lotto purchased
- Print the whole list of lotto

#### Show total winning result

- Get the result and print the result
- return type: void

