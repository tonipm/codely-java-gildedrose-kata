package tv.codely.kata.gildedrose.item;

abstract class ItemUpdatable implements Item {
  private static final int MIN_QUALITY = 0;
  private static final int MAX_QUALITY = 50;

  private final String name;
  private int sellIn;
  private int quality;

  public ItemUpdatable(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  public abstract void update();

  @Override
  public int sellIn() {
    return this.sellIn;
  }

  @Override
  public int quality() {
    return this.quality;
  }

  void resetQuality() {
    this.quality = 0;
  }

  void increaseQuality() {
    if (this.quality < MAX_QUALITY) {
      this.quality += 1;
    }
  }

  void decreaseQuality() {
    if (this.quality > MIN_QUALITY) {
      this.quality -= 1;
    }
  }

  void decreaseSellIn() {
    this.sellIn -= 1;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }
}
