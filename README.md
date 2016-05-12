# Aostefan

What does this Java Application do?
-----------------------------------
A sample springboot app configured with ssl and self signed certificate. App is also custom configured(without the @Springbootapplication annotaton). The Application also has a configured Webservice endpoint (Buttom up) and a default login page. Checkout the AppWebSecurityConfig.java class of login details.


Prerequisites
=============

You need to install the following tools if you want to run this application:-

Backend
-------
* [JDK 8 1.8.0.60 JRE](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
	* Set your JAVA_HOME
* [Maven](http://maven.apache.org/) (the application is tested with Maven 3.2.1)
	* Configure Maven 3.3.3
* Eclipse IDE, for Eclipse Kempler R2, update to Java 1.8 via http://download.eclipse.org/eclipse/updates/4.3-P-builds/ for Java8 support
* Download Apache commons-daemon 1.0.1.5 binaries (This is optional as it has already being configured for this app)
* [GIT Bash](https://github.com/git-for-windows/git/releases/download/v2.6.1.windows.1/Git-2.6.1-64-bit.exe)
* [Keystore Explorer](http://sourceforge.net/projects/keystore-explorer/files/KSE%205.1.1/kse-511-setup.exe/download)


# GIT Repository details
All work is done on the "developer" branch!!

	* name 				aos-demo-springboot-ssl
	* Lead dev 			Stephan Asemota
		
## To try out:
	* Web GUI access: is https://localhost:8443/login
	* Webservice https://localhost:8443/api/
