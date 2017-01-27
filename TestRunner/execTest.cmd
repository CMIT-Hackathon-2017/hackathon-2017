rem clean up
del testResults.json
del .\lib\*.class
echo Compiling
"%java_home%\bin\javac" -d lib source\TestRunner.java source\ChallengeReply.java
echo running
"%java_home%\bin\java" -cp lib main.java.TestRunner