## Setup:
In order to install all necessary dependencies
* Run `mvn clean package` once or run `Maven (clean+package)` in Intellij Idea if you don't have a globally installed maven.

## Run tests:
Run tests using `mvn clean test`
* Supported browsers
    * Chrome
    * Firefox
    
Define this value for browser property in 
* `config.properties` file (default run value)
 
 or using in commandline
 * `mvn -Dbrowser=<value> clean test`

## Reports
Results of each run can be checked
* target/cucumber/index.html