package tv.codely.kata.gildedrose;

import tv.codely.kata.gildedrose.model.item.Item;

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