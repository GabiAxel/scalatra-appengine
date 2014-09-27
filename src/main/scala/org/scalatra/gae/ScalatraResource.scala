package org.scalatra.gae

import org.scalatra.ScalatraServlet
import javax.servlet.http.HttpServletRequest
import org.scalatra.Handler

/**
 * Instances of this class are meant to be mounted via 
 * [[org.scalatra.gae.AppMapper]] , as opposed to 
 * [[javax.servlet.ServletContext]], which cannot be done in API 2.5 .
 */
class ScalatraResource extends ScalatraServlet {

  /**
   * The length of the top-level URI mapping
   */
  protected[gae] var basePathLength: Int = _

  /*
   * Trim the top-level mapping from the URI before using Scalatra's mapping
   */
  override def requestPath(implicit request: HttpServletRequest): String = {
    super.requestPath(request).substring(basePathLength)
  }
}