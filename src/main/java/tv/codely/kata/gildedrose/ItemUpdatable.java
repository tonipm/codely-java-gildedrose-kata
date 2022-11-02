package tv.codely.kata.gildedrose;

abstract class ItemUpdatable implements Item {

  private final ItemName name;
  private ItemSellIn sellIn;
  private ItemQuality quality;

  public ItemUpdatable(final ItemName name, final ItemSellIn sellIn, final ItemQuality quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public abstract void update();

  @Override
  public ItemSellIn sellIn() {
    return sellIn;
  }

  @Override
  public ItemQuality quality() {
    return quality;
  }

  void resetQuality() {
    quality = quality.reset();
  }

  void increaseQuality() {
    quality = quality.increase();
  }

  void decreaseQuality() {
    quality = quality.decrease();
  }

  void decreaseSellIn() {
    sellIn = sellIn.decrease();
  }

  boolean hasToBeSoldInLessThan(Integer days) {
    return sellIn.isLessThan(days);
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
