package container_factory.can_factory

import container_factory.ContainerFactoryInterface

class CanFactory private constructor(): ContainerFactoryInterface {
  override fun createContainer() = Can()

  companion object {
    val instance by lazy { CanFactory() }
  }
}
