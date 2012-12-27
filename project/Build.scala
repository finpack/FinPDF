import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName = "FinPDF"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "pdf" % "pdf_2.9.1" % "0.3.2"
  )

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    resolvers ++= Seq(
      Resolver.file("Local Ivy Repository", file(Path.userHome.absolutePath + "/.ivy2/local"))(Resolver.ivyStylePatterns)
    )
  )

}
