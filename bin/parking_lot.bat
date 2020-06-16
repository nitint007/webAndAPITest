#!/bin/bash
cd webAndAPITest
mvn clean test -Dsurefire.suiteXmlFiles=testng_api.xml,testng_web.xml