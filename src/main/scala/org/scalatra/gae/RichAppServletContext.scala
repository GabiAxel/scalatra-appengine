package org.scalatra.gae

import org.scalatra.servlet.RichServletContext

import javax.servlet.ServletContext

/**
 * Enriched [[javax.servlet.ServletContext]] which delegates the mounting 
 * operation to application-level mapping, instead of 
 * [[javax.servlet.ServletContext#addServlet(String, javax.servlet.Servlet)]]
 * which is not available in API 2.5
 */
class RichAppServletContext(sc: ServletContext) extends RichServletContext(sc) {

  def mount(handler: ScalatraResource, urlPattern: String) = AppMapper.mount(handler, urlPattern)
}