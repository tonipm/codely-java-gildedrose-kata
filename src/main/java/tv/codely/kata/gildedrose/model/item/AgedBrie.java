package tv.codely.kata.gildedrose.model.item;

public final class AgedBrie extends ItemUpdatable {

  private static final int INCREASE_QUALITY_THRESHOLD = 0;

  public AgedBrie(final String name, final int sellIn, final int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    decreaseSellIn();
    increaseQuality();

    if (this.sellIn < INCREASE_QUALITY_THRESHOLD) {
      increaseQuality();
    }
  }
}
