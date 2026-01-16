# Exercise 7 (Repo 2): Add test dependencies and explore the Maven lifecycle
For each command, answer the following in your notes:

**Which phases of the Maven lifecycle are executed?**

`mvn clean` : Deletes the target/ file in order to build from something clean
*Executed maven phases*: `clean`
*New files in `target/`* : none

`mvn test` :
  - Compile sources `src/main/java`
  - Compile tests `src/test/java`
  - Executes unit testing
*Executed maven phases* : `validate -> compile -> test-compile -> test`
*New files in `target/`* :
- `target/classes/`: Compiled classes 
- `target/classes/`: Compiled test classes
- Maven specifics files
<img width="367" height="341" alt="image" src="https://github.com/user-attachments/assets/ee721aa8-c0f9-49bd-9739-387fec62a11a" />
