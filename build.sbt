name := "BigData"

organization := "sict_309"

version := "1.0"

scalaVersion := "2.11.8"

assemblyJarName in assembly := "BigData.jar"

test in assembly := {}

assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false)

assemblyMergeStrategy in assembly := {
  case PathList("javax", "servlet", xs@_*) => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".class" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".xml" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".html" => MergeStrategy.first
  case PathList(ps@_*) if ps.last endsWith ".properties" => MergeStrategy.first
  case "application.conf" => MergeStrategy.concat
  case "unwanted.txt" => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

resolvers ++= Seq(
  "kompics" at "http://kompics.sics.se/maven/repository/"
)

javacOptions ++= Seq("-encoding", "UTF-8", "-source", "1.8", "-target", "1.8")

resolvers ++= Seq(
  "libs-releases" at "http://artifactory.jd.com/libs-releases",
  "libs-snapshots" at "http://artifactory.jd.com/libs-snapshots",
  "plugins-releases" at "http://artifactory.jd.com/plugins-releases",
  "plugins-snapshots" at "http://artifactory.jd.com/plugins-snapshots"
)

resolvers ++= Seq(
  "libs-releases" at "http://kompics.sics.se/maven/repository/"
)

libraryDependencies ++= Seq(
  "org.apache.spark" % "spark-core_2.11" % "2.3.0" % "provided",
  "org.apache.spark" % "spark-sql_2.11" % "2.3.0" % "provided",
  "org.apache.spark" % "spark-mllib_2.11" % "2.3.0" % "provided",
  "org.apache.spark" % "spark-hive_2.11" % "2.3.0" % "provided",
  "org.apache.spark" % "spark-repl_2.11" % "2.3.0" % "provided",
  "org.apache.spark" % "spark-tags_2.11" % "2.3.0" % "provided",
  "org.apache.spark" % "spark-graphx_2.11" % "2.3.0" % "provided"
)

libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.7.3"

libraryDependencies += "org.apache.hadoop" % "hadoop-client" % "2.7.3"

libraryDependencies += "org.apache.hadoop" % "hadoop-hdfs" % "2.7.3"

libraryDependencies += "org.apache.hadoop" % "hadoop-mapreduce-client-core" % "2.7.3"

libraryDependencies += "com.yammer.metrics" % "metrics-core" % "2.2.0"

libraryDependencies += "com.typesafe" % "config" % "1.2.1"

libraryDependencies += "net.liftweb" % "lift-json_2.11" % "3.0"

libraryDependencies += "org.tensorflow" %% "spark-tensorflow-connector" % "1.6.0"

libraryDependencies += "com.databricks" % "spark-avro_2.11" % "4.0.0"
