import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "FinPDF"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "pdf" % "pdf_2.9.1" % "0.3"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
      resolvers += Resolver.url("joergviola GitHub Play Repository", url("http://www.joergviola.de/releases/"))(Resolver.ivyStylePatterns)
    )

}