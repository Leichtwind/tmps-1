package liquids_factories

abstract class AbstractLiquidFactory {
  abstract fun createObject(): AbstractLiquid
}
