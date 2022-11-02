package tv.codely.kata.gildedrose;

class GildedRose {

  private final Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      item.update();
    }
  }
}