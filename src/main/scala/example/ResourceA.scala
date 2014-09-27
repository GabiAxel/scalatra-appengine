package example

import org.scalatra.gae.ScalatraResource

class ResourceA extends ScalatraResource {

  get("/") {
    <p>Root of Resource A</p>
  }
  
  get("/inner") {
    <p>Inner mapping under Resource A</p>
  }

  notFound {
    <p>Not found under Resource A</p>
  }
}
