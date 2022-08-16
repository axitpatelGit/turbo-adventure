Pre requisites for Test setup –
--------------------------------------------------------------------------------------------------------
1.	Get the project from below Git repository path.
	https://github.com/axitpatelGit/turbo-adventure
2.	Ensure Java and Maven installed in the system and path added in environment variables as below. 
	a.	Add M2_HOME, MAVEN_HOME, JAVA_HOME in system variables.
	b.	Also add %MAVEN_HOME%\bin  and %M2_HOME%\bin in Path variable.

========================================================================================================

Cucumber Project Structure – 
--------------------------------------------------------------------------------------------------------
-	Cucumber test runner file path : "\turbo-adventure\TrivialPublicAPI\src\test\resources\cucumber\Options\CucumberRunnerTest.java"
-	Feature file path - "\turbo-adventure\TrivialPublicAPI\src\test\resources\features\EpochToHumanReadable.feature"
-	Step definition file path - "\turbo-adventure\TrivialPublicAPI\src\test\resources\stepDefinations\StepDefination.java"

========================================================================================================

Test scenario written at below excel – 
"\turbo-adventure\TrivialPublicAPI\Test Scenario Sheet.xlsx"

========================================================================================================

Steps for Test suite execution -
--------------------------------------------------------------------------------------------------------
	1.	Open command line
	2.	Navigate to Project folder
		- Suppose your project path in local directory is  ‘C:\Users\eclipse-workspace\TrivialPublicAPI’. 
		- In command line navigate to above folder by giving command  cd C:\Users\eclipse-workspace\TrivialPublicAPI
	3.	Execute the cucumber test runner file by giving below MAVEN test execution command.
		
		maven test

	4.	Once execution completes, check the reports in below project folder path. –
		
		TrivialPublicAPI\target\cucumber-reports
		
		Reports available in xml, json and html format. We can directly open html report in any browser to check execution details.
