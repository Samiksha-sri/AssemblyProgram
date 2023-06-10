# AssemblyProgram
MIKO Assignment for assembly program

## Description

Create a simple assembly Language which will have 3 operations:

Get a constant into a register of the form
MV REG1,#2000

MV REG2,#4000

Add two registers together. Save results in the first register

ADD REG1, REG2

Add register and constant together. Save results in the first register.

ADD REG1,600

Show the results of a register

SHOW REG

The simple java  program should be able to accept a program containing one or more MV
statements and an ADD statement and print the results of a SHOW REG at the end.
The assembly language program should be passed to a spring boot program. It should be able to
save the program id and success/failure in a DB in mySQL.

## Steps to run the program

1. Download the git folder in zip.
2. Extract files in local folder
3. Import the project in any IDE of your choice.
4. Run the Spring Boot Application. Make sure you have postman(or any such tool) for testing and Database to view the results.
