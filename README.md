# XO Game 
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)



A network XO game as the java project for Open Source Application Development Track, ITI intake 42.


# Contents

- [Running the Project]()
- [Prerequisites]()
- [Features ](#features)
	  

# Running the project


## First Way


-You can run it on the same machine through the project itself in Netbeans application, Eclipse or IntelliJ by running the server then the client. 

<br>
To run on different machines you've to change the connection ip in the Client project in a class PlayerSoc.java from localhost to the ip of the machine which the server is runing on.

<br>


-Be carfeful old versions of Netbeans may not run the project. </br></br>



## Secong Way by Terminal

cd to the Server jar file directory and run:
```
java -jar ./Server.jar
```
the server will listen to requests on the localhost port 5005

cd to the Client jar file directory and run:
```
java -jar ./Client.jar 
```
</br>

# Prerequisites

JDK 8 or higher. 

# Features

### Client Side Features:
</br>

- [sign up and Login Up]()
- [see who is online offline orplaying with other players]()
- [Play with PC with levels of difficulity]()
- [Play with Online Players]()
- [Chat]()
- [Score of the players]()

</br>

### Server side Features 
</br>

- [Player List]()
- [Player Score and Status]()
- [Server Closing and Opening]()

</br>
</br>


## Built With

* [Maven]()
* [JavaFX]()
* [MySQL]()
* [AnimateFX]()
* [JSON-Simple]()



## Authors

* **Abdelrahman Magdy Ibrahim Eldesouky**
* **Ahmed Reda Mohamed Bastwesy**
* **Hala Salah Ata Ahmed**
* **Mahmoud Nehro Mahmoud Aboelkher**
* **Heba Esmael Mohammed Abo Elfadl**

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details



