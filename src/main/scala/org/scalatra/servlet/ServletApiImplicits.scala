package org.scalatra
package servlet

import javax.servlet.ServletContext
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession
import org.scalatra.gae.RichResponseLocalStatus
import org.scalatra.gae.RichAppServletContext

trait ServletApiImplicits {
  implicit def enrichRequest(request: HttpServletRequest): RichRequest =
    RichRequest(request)

  // Changed to overcome lack of HttpServletResponse.getStatus() in Servlet API 2.5
  implicit def enrichResponse(response: HttpServletResponse): RichResponse =
    new RichResponseLocalStatus(response)

  implicit def enrichSession(session: HttpSession): RichSession =
    RichSession(session)

  // Changed to overcome the lack of ServletContext.mount() in Servlet API 2.5
  implicit def enrichServletContext(servletContext: ServletContext): RichAppServletContext =
    new RichAppServletContext(servletContext)

}

object ServletApiImplicits extends ServletApiImplicits
