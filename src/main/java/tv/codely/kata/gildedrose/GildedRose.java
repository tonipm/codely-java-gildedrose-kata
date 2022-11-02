package tv.codely.kata.gildedrose;

import java.util.List;

final class GildedRose {

  public void updateQuality(List<Item> items) {
    items.forEach(Item::update);
  }
}