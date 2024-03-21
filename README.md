To import this library into your project, do the following steps:
1. Generate a github token under **Developer Settings** section in your Github account.
2. Make sure that token has permission **read package**
3. Go to your local maven **settings.xml** file and add the following Profile
```
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
 
    <activeProfiles>
        <activeProfile>github</activeProfile>
    </activeProfiles>
 
    <profiles>
        <profile>
            <id>github</id>
            <repositories>
                <repository>
                    <id>central</id>
                    <url>
                        https://repo1.maven.org/maven2
                    </url>
                </repository>
                <repository>
                    <id>github</id>
                    <url>
                        https://maven.pkg.github.com/EPAM-VN/be-commons
                    </url>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>
        </profile>
    </profiles>
 
    <servers>
        <server>
            <id>github</id>
            <username>GITHUB_USERNAME</username>
            <password>GITHUB_TOKEN</password>
        </server>
    </servers>
 
</settings>
 ```
4. Add be-commons into your pom.xml
```
<dependency>
  <groupId>com.sephora</groupId>
  <artifactId>be-commons</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>
```
5. mvn install
