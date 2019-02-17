package container_factory.glass_factory

import container_factory.ContainerInterface

class Glass internal constructor() : ContainerInterface {
  override val name = "Glass"

  override fun clone() = Glass()
}
