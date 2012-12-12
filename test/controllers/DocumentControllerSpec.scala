package controllers

import org.specs2.mutable.Specification
import play.api.test.Helpers._
import play.api.test.TestServer
import play.api.libs.ws.WS

/**
 * @author: mgibowski
 */
class DocumentControllerSpec extends Specification{

  "DocumentController" should {

    "provide pdf document on correct request" in {
      running(TestServer(3333)) {
        // Given
        val promise = WS.url("http://localhost:3333/document")
          .withHeaders(("Content-Type", "text/plain; charset=UTF-8"))
          .post(body = "<h1>Hello World!</h1>")

        // When
        val response = await(promise)
        // Then
        response.status must equalTo(OK)
        response.getAHCResponse.getContentType must equalTo("application/pdf")
        response.getAHCResponse.getResponseBodyAsBytes.size must beGreaterThan(0)
      }
    }

    "complain on empty request body" in {
      running(TestServer(3333)) {
        // Given
        val promise = WS.url("http://localhost:3333/document")
          .withHeaders(("Content-Type", "text/plain; charset=UTF-8"))
          .post(body = "")

        // When
        val response = await(promise)
        // Then
        response.status must equalTo(BAD_REQUEST)
      }
    }

    "complain on wrong content type" in {
      running(TestServer(3333)) {
        // Given
        val promise = WS.url("http://localhost:3333/document")
          .withHeaders(("Content-Type", "application/x-www-form-urlencoded"))
          .post(body = "<h1>Hello World!</h1>")

        // When
        val response = await(promise)
        // Then
        response.status must equalTo(BAD_REQUEST)
      }
    }

  }

}
