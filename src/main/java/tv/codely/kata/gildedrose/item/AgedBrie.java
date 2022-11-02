package tv.codely.kata.gildedrose.item;

final class AgedBrie extends ItemUpdatable {

  private static final int INCREASE_QUALITY_THRESHOLD = 0;

  AgedBrie(final String name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    decreaseSellIn();
    increaseQuality();

    if (sellIn() < INCREASE_QUALITY_THRESHOLD) {
      increaseQuality();
    }
  }
}
