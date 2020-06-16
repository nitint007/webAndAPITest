# webAndAPITest

The project is fix on solution for DKatalis lab assignment that were not up to the mark in first submit
The new solution is updated to TestNG instead of Cucumber

# The new solution contains 2 suites in one framework:

1. testng_web.xml - helps run web ui tests as per user input on either chrome or firefox 
(have to enter browser names 2 times as two tests run)

2. testng_api.xml - helps run api tests parellel

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Framework

Page Object model Test automation framework using Selenium with Java, TestNG and Maven

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Please find details BELOW for WEB test automation suite

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# demo.trans

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Executing cross browser

The web tests require user inputs as browser names either 'chrome' or 'firefox'

# IMP NOTE: You have to enter browser names 2 times as it accepts user input for 2 tests.

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
# Steps to clone execute the tests:

git clone https://github.com/nitint007/webAndAPITest

cd webAndAPITest

mvn clean test -Dsurefire.suiteXmlFiles=testng_web.xml

# If fails to execute from cmd line -

Go to 'webAndAPITest/testng_web.xml' Run as > 'TestNG Suite'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# For reporting:

Go to 'webAndAPITest/test-output/' and open 'index.html'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Execution for DKatalis lab:

Executable created at webAndAPITest/bin/parking_lot.bat

# If fails to execute from cmd line -

Go to '/webAndAPITest/testng_web.xml' Run as > 'TestNG Suite'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Assumption/s for WEB suite

Considered the site is beta and has only one product to buy

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Please find details BELOW for API test automation suite

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# apicomparator

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Execution of suite

The suite runs the tests parallel.

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
# Steps to clone execute the tests:

git clone https://github.com/nitint007/webAndAPITest

cd webAndAPITest

mvn clean test -Dsurefire.suiteXmlFiles=testng_api.xml

# If fails to execute from cmd line -

Go to 'webAndAPITest/testng_api.xml' Run as > 'TestNG Suite'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# For reporting:

Go to 'webAndAPITest/test-output/' and open 'index.html'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Execution for DKatalis lab:

Executable created at webAndAPITest/bin/parking_lot.bat

# If fails to execute from cmd line -

Go to 'webAndAPITest/testng_api.xml' Run as > 'TestNG Suite'

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Test data files:
Two type of file are provided:

1. For basic validation of library - 'file1' and 'file2'
2. To check 1000+ request - 'longfile1' and 'longfile2'
NOTE: Long files contains 1000 request are also verified.

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

# Assumption:

Currently provided files with combination of URLs considering the problem statement to provide a two files only.

*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-