import org.scalatra.LifeCycle

import example.ResourceA
import example.ResourceB
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext) {
    
    context mount(new ResourceA, "/a/")
    context mount(new ResourceB, "/b/*")

  }
}
