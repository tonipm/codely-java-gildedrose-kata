package tv.codely.kata.gildedrose;

class GildedRose {

  private static final String ITEM_AGED_BRIE_NAME = "Aged Brie";
  private static final String ITEM_BACKSTAGE_PASSES_NAME = "Backstage passes to a TAFKAL80ETC concert";
  private static final String ITEM_SULFURAS_PASSES_NAME = "Sulfuras, Hand of Ragnaros";
  private static final int ITEM_DECREASE_SELL_IN_THRESHOLD = 0;
  private static final int ITEM_AGED_BRIE_INCREASE_QUALITY_THRESHOLD = 0;
  private static final int ITEM_BACKSTAGE_PASSES_RESET_QUALITY_THRESHOLD = 0;
  private static final int ITEM_BACKSTAGE_PASSES_INCREASE_QUALITY_01_THRESHOLD = 10;
  private static final int ITEM_BACKSTAGE_PASSES_INCREASE_QUALITY_02_THRESHOLD = 5;
  private static final int ITEM_MIN_QUALITY = 0;
  private static final int ITEM_MAX_QUALITY = 50;
  private final Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (Item item : items) {
      switch (item.name) {
        case ITEM_AGED_BRIE_NAME:
          decreaseSellIn(item);
          updateAgedBrieQuality(item);
          break;
        case ITEM_BACKSTAGE_PASSES_NAME:
          decreaseSellIn(item);
          updateBackstagePassesQuality(item);
          break;
        case ITEM_SULFURAS_PASSES_NAME:
          break;
        default:
          decreaseSellIn(item);
          updateDefaultItemQuality(item);
      }
    }
  }

  private void updateAgedBrieQuality(Item item) {
    increaseQuality(item);

    if (item.sellIn < ITEM_AGED_BRIE_INCREASE_QUALITY_THRESHOLD) {
      increaseQuality(item);
    }
  }

  private void updateBackstagePassesQuality(Item item) {
    increaseQuality(item);

    if (item.sellIn < ITEM_BACKSTAGE_PASSES_INCREASE_QUALITY_01_THRESHOLD) {
      increaseQuality(item);
    }
    if (item.sellIn < ITEM_BACKSTAGE_PASSES_INCREASE_QUALITY_02_THRESHOLD) {
      increaseQuality(item);
    }
    if (item.sellIn < ITEM_BACKSTAGE_PASSES_RESET_QUALITY_THRESHOLD) {
      resetQuality(item);
    }
  }

  private void updateDefaultItemQuality(Item item) {
    decreaseQuality(item);
    if (item.sellIn < ITEM_DECREASE_SELL_IN_THRESHOLD) {
      decreaseQuality(item);
    }
  }

  private void resetQuality(Item item) {
    item.quality = 0;
  }

  private void increaseQuality(Item item) {
    if (item.quality < ITEM_MAX_QUALITY) {
      item.quality += 1;
    }
  }

  private void decreaseQuality(Item item) {
    if (item.quality > ITEM_MIN_QUALITY) {
      item.quality -= 1;
    }
  }

  private void decreaseSellIn(Item item) {
    item.sellIn -= 1;
  }
}
