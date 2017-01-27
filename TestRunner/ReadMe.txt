Description of how to compile and run test.

Raw implementation.

1. Create an appropriate library.
2. Make a source library
3. Make a lib library
4. Place execTest.cmd in library
5. Place source files in source library
6. Run execTest.cmd
7. Result delivered in base library in testResults.json

The following assumption are made:

A. JAVA_HOME must be defined
B. TestRunner is in main.java.TestRunner

Sample of structure:

 Directory of C:\baseLibrary\javac

27-01-2017  09:28    <DIR>          .
27-01-2017  09:28    <DIR>          ..
27-01-2017  09:17               218 execTest.cmd
27-01-2017  09:15    <DIR>          lib
27-01-2017  09:21    <DIR>          source
27-01-2017  09:21               174 testResults.json
               3 File(s)            392 bytes

 Directory of C:\baseLibrary\javac\lib

27-01-2017  09:15    <DIR>          .
27-01-2017  09:15    <DIR>          ..
27-01-2017  09:15    <DIR>          main
               0 File(s)              0 bytes

 Directory of C:\baseLibrary\javac\lib\main

27-01-2017  09:15    <DIR>          .
27-01-2017  09:15    <DIR>          ..
27-01-2017  09:15    <DIR>          java
               0 File(s)              0 bytes

 Directory of C:\baseLibrary\javac\lib\main\java

27-01-2017  09:15    <DIR>          .
27-01-2017  09:15    <DIR>          ..
27-01-2017  09:21               393 ChallengeReply.class
27-01-2017  09:21             2.306 TestRunner.class
               2 File(s)          2.699 bytes

 Directory of C:\baseLibrary\javac\source

27-01-2017  09:21    <DIR>          .
27-01-2017  09:21    <DIR>          ..
27-01-2017  09:14               262 ChallengeReply.java
27-01-2017  09:21             1.699 TestRunner.java
               2 File(s)          1.961 bytes

     Total Files Listed:
               7 File(s)          5.052 bytes

