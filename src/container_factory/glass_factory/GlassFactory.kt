package container_factory.glass_factory

import container_factory.ContainerFactoryInterface

class GlassFactory private constructor(): ContainerFactoryInterface {
  override fun createContainer() = Glass()

  companion object {
    val instance by lazy { GlassFactory() }
  }
}
