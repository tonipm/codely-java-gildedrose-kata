package tv.codely.kata.gildedrose;

final class AgedBrie extends ItemUpdatable {

  private static final int INCREASE_QUALITY_THRESHOLD = 0;

  AgedBrie(final ItemName name, final ItemSellIn sellIn, final ItemQuality quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    decreaseSellIn();
    increaseQuality();

    if (hasToBeSoldInLessThan(INCREASE_QUALITY_THRESHOLD)) {
      increaseQuality();
    }
  }
}
