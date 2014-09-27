package org.scalatra.gae

import scala.collection.JavaConversions._
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * This is the only servlet that needs to be registered in web.xml .
 * It dispatches the request to the resource that matches the URI prefix
 * as mounted to [[org.scalatra.gae.AppMapper]]
 */
class Dispatcher extends HttpServlet {

  override def service(request: HttpServletRequest, response: HttpServletResponse) {

    val uri = request.getRequestURI.substring(request.getServletPath().length())
    val o = AppMapper.getHandler(uri)
    if (o.isDefined) {
      val (basePath, handler) = o.get
      handler.handle(request, response)
    }

  }

}

