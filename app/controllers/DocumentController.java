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
package controllers;

import play.api.templates.Html;
import play.mvc.Controller;
import play.mvc.Result;
import util.pdf.PDF;

import static com.google.common.base.Strings.isNullOrEmpty;

public class DocumentController extends Controller {

	public static Result document() {
        final String body = request().body().asText();
        if(isNullOrEmpty(body)) return badRequest("Make sure to provide some content as [text/plain; charset=UTF-8]");
        return PDF.ok(new Html(body));
	}

}
