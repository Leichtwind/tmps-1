package container_factory.can_factory

import container_factory.ContainerInterface

class Can internal constructor() : ContainerInterface {
  override val name = "Can"

  override fun clone() = Can()
}
