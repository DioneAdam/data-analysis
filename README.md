# 🚀 Data Analyzer

A data analysis system that import lots of flat files, read, analyse the data, and output a report. 

Everytime that a new file is created, or a file is modified, the system will analyze again.

By default, if the input directory is already created and contains files,
the system will analyse all the files on it.
> this feature can be disabled in `application.yml`

### 📝 input file layout
There are 3 kinds of data inside those files. For each kind of data there is a different layout.

 - Salesman
    - 001çCPFçNameçSalary

 - Customer
    - 002çCNPJçNameçBusiness Area
 - Sales
    - 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

System reads input files from `{user.home}/data/in` by default.
> Input directory can be changed in `application.yml`

### 📄 Output file
 - Amount of clients in the input file
 - Amount of salesman in the input file
 - ID of the most expensive sale
 - Name of the worst salesman ever

The output file will be created at `{user.home}/data/out`
> Output directory can be changed in `application.yml`

### 🎲 How to use:

 - To build the application:
   ```
   ./gradlew clean build 
   ```
   
 - To run unit tests:
   ```
   ./gradlew clean test
   ```

 - To run unit tests:
   ```
   ./gradlew clean bootRun
   ```

### 🛠 Technologies

- [Java 11](https://www.java.com/pt-BR/)
- [Spring](https://spring.io/)
- [Java WatchService](https://docs.oracle.com/javase/7/docs/api/java/nio/file/WatchService.html)
- [Gradle](https://gradle.org/)
- [JUnit](https://junit.org/)
- [AssertJ](https://assertj.github.io/doc/)
