# Omise Scala

[![Build Status](https://travis-ci.org/nimid/omise-scala.svg?branch=master)](https://travis-ci.org/nimid/omise-scala)

## Installation

- Install by using JAR file, download [JAR file](https://github.com/nimid/omise-scala/releases/download/v0.1/omise-scala-v0.1.jar) to your machine and set classpath to the downloaded file.

- Install by using dependency management such as sbt is coming soon.

## Usage

```scala
// File Main.scala
import co.omise.{OmiseCharge, OmiseToken}

object Main extends App {
  OmiseToken.publicKey = "YOUR-OMISE-PUBLIC-KEY"
  val token = OmiseToken.create(
    cardName = "Saroj Sangphongamphai",
    cardNumber = "4242424242424242",
    cardExpirationMonth = 6,
    cardExpirationYear = 2019,
    cardCity = "Bangkok",
    cardPostalCode = "10230",
    cardSecurityCode = "123",
  )

  OmiseCharge.secretKey = "YOUR-OMISE-SECRET-KEY"
  val charge = OmiseCharge.create(
    amount = 100000, // ฿ 1,000.00
    currency = "thb",
    card = Some(token.id),
  )

  println(charge.id)
}
```

If using JAR file;

```
$ scalac -classpath omise-scala-v0.1.jar Main.scala 
$ scala -classpath omise-scala-v0.1.jar Main 
```