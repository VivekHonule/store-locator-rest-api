
* This Repository contains Rest API project for Store which allow users to create, update, delete store and retrieve stores within x miles of USA zip code.

* Software or API used and its version.
  JDK - 1.8
  tomcat - 7.0
  Maven - 4.0
  Jersey API - 2.19
  Hibernate-spatial - 4.0
  MySQL - 5.5
  Eclipse IDE Luna.

* 
1) To Run this project you need eclipse luna, jdk8, tomcat 7, mysql 5.5 installed in your system.

2)Check out code from BitBucket Repository.

3) Check whether maven plugin is installed or not. If not then go and install maven plugin (m2e plugin).

4)When you check out code, it might give you build path error. To set this go to window -> preferences -> Java -> Installed JRE -> add -> add jdk 1.8 and mark it -> ok.

5) selecting jdk 1.8 is necessary as maven compile plugin will use jdk to compile java source code.

6) create database in mysql named "store_db". make sure your database server runs on port 3306, if not then make changes in persistence.xml

7) right click on project->maven->update project.

8)right click on project ->run as -> maven clean.

9) right click on project -> run as -> maven build -> specify goal as "tomcat:run". (This goal will start your tomcat and deploy war on it automatically).

10) If you get BindException while maven build then start task manager and close javaw instance and build the project again.

11)Now you project is up and running.

12) in com.causecode.dao package test class is given, go and run that class to enter zipcodes inside database. We are entering 3 zipcodes for testing.

11) Hit following url in browser to create store in db.
   
     http://localhost:8080/StoreRestAPI/rest/store/create?storeName=ABC&licenceNumber=abc12345&ownerName=vivek honule&storeType=grocery&storeLocation=18.179017,-66.748981
&zipCode=00601&state=texas&country=usa&streetAdd=street-4

  note - parameters should be passed correctly otherwise it will throw error. "storeLocation" value is lat/lang pair separated by comma, so be careful. Pass zipcode which is already there in database as we have entered only 3 zipcodes in database for testing.

12) Hit following URL in browser to update store.

     http://localhost:8080/StoreRestAPI/rest/store/update?storeName=XYZ&licenceNumber=abc12345&ownerName=vivek honule&storeType=stationary&storeLocation=18.179017,-66.748981
&zipCode=00601&state=texas&country=usa&streetAdd=street-4&storeID=13

  note - parameters should be passed correctly otherwise it will throw error. "storeLocation" value is lat/lang pair separated by comma, so be careful. Pass zipcode which is already there in database as we have entered only 3 zipcodes in database for testing.

13) Hit following URL in browser to delete store.
   
     http://localhost:8080/StoreRestAPI/rest/store/delete?licenceNumber=abc12345

 note - store associated with the given licenceNumber will get deleted from the database.

14 Hit following URL in browser to get stores within x miles of usa zipcode.

   http://localhost:8080/StoreRestAPI/rest/store/get?miles=2&zipcode=00601

  note - specify zipcode which is present in database as we have entered only 3 zipcodes in the database for testing.

15) use following URL to get lat/long nearest to your zipcode location, to test the "get stores within x miles of USA Zipcode".

  http://www.latlong.net/Show-Latitude-Longitude.html

  





* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact