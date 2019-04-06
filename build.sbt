resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

name := "troubleshooting-apache-spark"

version := "0.0.1"

scalaVersion := "2.11.12"

libraryDependencies += "mrpowers" % "spark-daria" % "0.27.1-s_2.11"
libraryDependencies += "MrPowers" % "spark-fast-tests" % "0.17.2-s_2.11" % "test"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.4" % "test",
  "org.apache.spark" %% "spark-core" % "2.4.0",
  "org.apache.spark" %% "spark-sql" % "2.4.0",
  "org.apache.spark" %% "spark-mllib" % "2.4.0",
  "org.postgresql" % "postgresql" % "9.4.1209.jre7",
  "log4j" % "log4j" % "1.2.17",
  "edu.umd" % "cloud9" % "1.5.0",
  "org.apache.hadoop" % "hadoop-client" % "2.7.3",
  "org.scalatest" %% "scalatest" % "3.0.1" % Test,
  "datastax" % "spark-cassandra-connector" % "2.0.1-s_2.11"
)



// test suite settings
fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
// Show runtime of tests
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

// JAR file settings

// don't include Scala in the JAR file
//assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

// Add the JAR file naming conventions described here: https://github.com/MrPowers/spark-style-guide#jar-files
// You can add the JAR file naming conventions by running the shell script



javaOptions in(Test, run) ++= Seq("-Dspark.master=local",
  "-Dlog4j.debug=true",
  "-Dlog4j.configuration=log4j.properties")

outputStrategy := Some(StdoutOutput)

fork := true
