package tv.codely.kata.gildedrose;

final class ItemDefault extends ItemUpdatable {

  private static final int DECREASE_QUALITY_THRESHOLD = 0;

  ItemDefault(final ItemName name, ItemSellIn sellIn, ItemQuality quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    decreaseSellIn();
    decreaseQuality();

    if (hasToBeSoldInLessThan(DECREASE_QUALITY_THRESHOLD)) {
      decreaseQuality();
    }
  }
}
