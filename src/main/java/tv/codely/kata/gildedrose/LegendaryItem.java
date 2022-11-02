package tv.codely.kata.gildedrose;

class LegendaryItem extends UpdatableItem {

  LegendaryItem(final ItemName name, ItemSellIn sellIn, ItemQuality quality) {
    super(name, sellIn, quality);
  }

  @Override
  public void update() {}
}
