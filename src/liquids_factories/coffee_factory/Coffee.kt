package liquids_factories.coffee_factory

import liquids_factories.AbstractLiquid

class Coffee internal constructor(): AbstractLiquid() {
  override val name = "Coffee"

  override fun clone() = Coffee()
}
