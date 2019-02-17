package liquids_factories.coffee_factory

import liquids_factories.AbstractLiquidFactory
import liquids_factories.AbstractLiquid

class CoffeeFactory private constructor(): AbstractLiquidFactory() {
  override fun createObject(): AbstractLiquid {
    return Coffee()
  }

  companion object {
    val instance by lazy { CoffeeFactory() }
  }
}
