package controllers;

import play.mvc.*;

import util.pdf.PDF;
import views.html.*;

public class DocumentController extends Controller {

	public static Result document() {
        final String body = request().body().asText();
        if(body == null || body.isEmpty()) return badRequest("Make sure to provide some content as [text/plain; charset=UTF-8]");
        return PDF.ok(document.render(body));
	}

}
