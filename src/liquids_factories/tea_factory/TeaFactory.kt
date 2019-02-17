package liquids_factories.tea_factory

import liquids_factories.AbstractLiquidFactory
import liquids_factories.AbstractLiquid

class TeaFactory private constructor(): AbstractLiquidFactory() {
  override fun createObject(): AbstractLiquid {
    return Tea()
  }

  companion object {
    val instance by lazy { TeaFactory() }
  }
}
