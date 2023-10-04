- Add maven config into <build> </build> tag:
  + Maven compiler
  + Maven surefire plugin
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M7</version>
            </plugin>
        </plugins>

**Dependencies for excel reader:
  + poi
  + poi--ooxml-schemas
  + dom4j
  + xmlbeans
  + commons-compress
  + commons-collections
**Note:
- 3 type repository(local, central & remote repo)
- mvn clean(delete target folder) install
** Command line run a specific test:
1. mvn test -Dtest=testclass_name
2. mvn clean test -DsuiteXmlFile=src/test/resources/TestDataProvider
or mvn clean test -DsuiteXmlFile=TestDataProvider


How to generate the allure report
+ run mvn clean test
+ run  allure generate allure-results
to directly access to the report --clean

#Timeout Exception vs. No Such Element
Timeout Exception: the program running to compare element values. 
Ex: 
wait.Until(ExpectedConditions.invisibilityOf(driver.findElement(headingSel)));
or \
wait.Until(ExpectedConditions.UrlToBe("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#identifier"))

No Such Element:
Ex:
wait.Until(ExpectedConditions.visibilityOf(driver.findElement(headingSel)));
