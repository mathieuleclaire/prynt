import AssemblyKeys._

assemblySettings

jarName in assembly := "prynt.jar"

name := "prynt"

scalaVersion := "2.10.2"

version := "0.1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Sonatype Release" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.0-M2-SNAPSHOT"

libraryDependencies += "org.scala-lang" % "scala-compiler" % "2.10.2"

libraryDependencies += "net.sf.opencsv" % "opencsv" % "2.0"

libraryDependencies += "com.typesafe.slick" %% "slick" % "1.0.1"

libraryDependencies += "com.h2database" % "h2" % "1.3.173"
