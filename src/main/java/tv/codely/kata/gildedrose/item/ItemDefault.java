package tv.codely.kata.gildedrose.item;

final class ItemDefault extends ItemUpdatable {

  private static final int DECREASE_QUALITY_THRESHOLD = 0;

  ItemDefault(final ItemName name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    decreaseSellIn();
    decreaseQuality();
    if (sellIn() < DECREASE_QUALITY_THRESHOLD) {
      decreaseQuality();
    }
  }
}
