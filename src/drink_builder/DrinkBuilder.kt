package drink_builder

import container_factory.ContainerInterface
import liquids_factories.AbstractLiquid

class DrinkBuilder {
  private var drink = PackedDrink()

  fun reset(): DrinkBuilder {
    drink = PackedDrink()
    return this
  }

  fun setLiquid(liquid: AbstractLiquid): DrinkBuilder {
    drink.liquid = liquid
    return this
  }

  fun setContainer(container: ContainerInterface): DrinkBuilder {
    drink.container = container
    return this
  }

  fun getDrink() = drink
}
