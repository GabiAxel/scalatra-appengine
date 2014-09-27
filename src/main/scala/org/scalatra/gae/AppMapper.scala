package org.scalatra.gae

/**
 * This object holds the top-level resource mappings
 */
object AppMapper {

  val mapping = scala.collection.mutable.Map[String, ScalatraResource]()
  
  /*
   * Map a URI prefix to a resource
   */
  def mount(handler: ScalatraResource, path: String) {

    // Consistent handling of "/path", "/path/" and "/path/*"
    val fixedPath = if (path.endsWith("/*"))
      path.stripSuffix("*")
    else if (!path.endsWith("/"))
      path + "/"
    else
      path

    handler.basePathLength = fixedPath.length - 1
    mapping.put(fixedPath, handler)
  }
  
  /*
   * Get the resource that matches the prefix of a URI
   */
  def getHandler(uri: String) = mapping.find(m => uri.startsWith(m._1))
}