# Data Analysis

A data analysis system that import lots of flat files, read, analyse the data, and output a report. Everytime new files become available or a file is changed, the analysis should be executed again.

### Flat input file layout
There are 3 kinds of data inside those files. For each kind of data there is a different layout.

 - Salesman
    - 001çCPFçNameçSalary

 - Customer
    - 002çCNPJçNameçBusiness Area
 - Sales
    - 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name

Input files must be placed in `%HOMEPATH%/data/in`

### Output file data
 - Amount of clients in the input file
 - Amount of salesman in the input file
 - ID of the most expensive sale
 - Worst salesman ever

The output file will be create at `%HOMEPATH%/data/out`


## How to use?

 - Open the terminal and go to ```$ challenge/``` directory:

 - Execute the commands:
    ```
    $ gradle wrapper
    $ gradle clean build
    $ gradle run
    ```

  - Done! The directory `%HOMEPATH%/data/out` now have a report file.


 ## Technologies used
  - Spring Core
  - Java WatchService
  - Logger - slf4j
