package tv.codely.kata.gildedrose.model.item;

public final class ItemDefault extends ItemUpdatable{

  private static final int DECREASE_QUALITY_THRESHOLD = 0;

  public ItemDefault(String name, int sellIn, int quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {
    decreaseSellIn();
    decreaseQuality();
    if (this.sellIn < DECREASE_QUALITY_THRESHOLD) {
      decreaseQuality();
    }
  }
}
