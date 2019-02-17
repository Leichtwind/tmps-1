package liquids_factories.tea_factory

import liquids_factories.AbstractLiquid

class Tea internal constructor(): AbstractLiquid() {
  override val name = "Tea"

  override fun clone() = Tea()
}
