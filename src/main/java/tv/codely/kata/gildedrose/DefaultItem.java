package tv.codely.kata.gildedrose;

final class DefaultItem extends UpdatableItem {

  private static final int DECREASE_QUALITY_THRESHOLD = 0;

  DefaultItem(final ItemName name, ItemSellIn sellIn, ItemQuality quality) {
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
