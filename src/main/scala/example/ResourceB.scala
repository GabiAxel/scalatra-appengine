package example

import org.scalatra.gae.ScalatraResource

class ResourceB extends ScalatraResource {

  get("/") {
    <p>Root of Resource B</p>
  }
  
  get("/inner") {
    <p>Inner mapping under Resource B</p>
  }
  
  notFound {
    <p>Not found under Resource B</p>
  }

}
