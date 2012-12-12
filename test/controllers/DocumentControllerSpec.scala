/*
*  FinPDF is free software; you can redistribute it and/or modify
*  it under the terms of the GNU Affero General Public License version 3.
*
*  FinPDF is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU Affero General Public License version 3 for more details.
*
*  You should have received a copy of the GNU Affero General Public License version 3
*  along with FinPDF; if not, write to the Free Software
*  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/
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
