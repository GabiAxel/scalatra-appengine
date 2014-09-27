package org.scalatra.gae

import org.scalatra.servlet.RichResponse
import javax.servlet.http.HttpServletResponse
import org.scalatra.ResponseStatus

/**
 * Enriched [[javax.servlet.http.HttpServletResponse]] which does not rely on 
 * [[javax.servlet.http.HttpServletResponse#getStatus()]] method, which is not
 * available in API 2.5 .
 */
class RichResponseLocalStatus(response:HttpServletResponse) extends RichResponse(response) {

  var statusCode:Int = _
  
  override def status = ResponseStatus(statusCode)
  
  override def status_=(statusLine: ResponseStatus) {
    statusCode = statusLine.code 
    super.status_=(statusLine)
  }
}