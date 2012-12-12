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

import play.api.mvc._

object Application extends Controller {
  
  def index = Action {
    Ok("Welcome to FinPDF")
  }

}