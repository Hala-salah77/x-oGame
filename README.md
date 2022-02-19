# XO Game 
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)



A network XO game as the java project for Open Source Application Development Track, ITI intake 42.


# Contents

- [Running the Project]()
- [Prerequisites]()
- [Features ](#features)
	  

# Running the project

## Import Database
- [Open your DBMS]()
- [Create new database call it game]()
- [Import the attached game.sql from x-oGame folder to your database ](#features) 

</br>

## First Way


You can run it on the same machine through the project itself in Netbeans application, Eclipse, VScode (with Java extensions) or IntelliJ by running the server then the client. 

<br>


-Be carfeful, You may face problems in old versions of Netbeans in running the project. </br></br>



## Secong Way by Terminal

cd to Server\target... the Server jar file directory and run:
```
java -jar Server-1.0-SNAPSHOT.jar
```
the server will listen to requests on the localhost port 5005

cd to Client\target... Client jar file directory and run the client two time with two different cmd:
```

java -jar TicTacToeFX-1.0-SNAPSHOT.jar

```
</br>

<br>
To run on different machines you've to change the connection ip in the Client project in a class SocketPlayer.java from localhost to the ip of the machine which the server is runing on.

</br>

<br>

# Prerequisites

JDK 8 or higher. 

# Features

### Client Side Features:
</br>

- [Sign up and Login Up]()
- [See who is online offline orplaying with other players]()
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



