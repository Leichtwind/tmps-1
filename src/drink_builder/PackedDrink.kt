package drink_builder

import container_factory.ContainerInterface
import liquids_factories.AbstractLiquid
import util.PrototypeInterface

class PackedDrink internal constructor() : PrototypeInterface {
  var liquid: AbstractLiquid? = null
  internal set

  var container: ContainerInterface? = null
  internal set

  override fun clone(): PackedDrink {
    return PackedDrink().apply {
      this@apply.liquid = this@PackedDrink.liquid!!.clone() as AbstractLiquid
      this@apply.container = this@PackedDrink.container!!.clone() as ContainerInterface
    }
  }
}
