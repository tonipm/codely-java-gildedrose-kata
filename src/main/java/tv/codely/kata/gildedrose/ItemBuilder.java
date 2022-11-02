package tv.codely.kata.gildedrose;

public final class ItemBuilder {

 public static Item from(final String rawName, final int rawSellIn, final int rawQuality) {
  ItemName name = new ItemName(rawName);
  ItemSellIn sellIn = new ItemSellIn(rawSellIn);
  ItemQuality quality = new ItemQuality(rawQuality);

  if (name.isAgedBrie()) return new AgedBrie(name, sellIn, quality);
  if (name.isBackstagePasses()) return new BackstagePasses(name, sellIn, quality);
  if (name.isSulfuras()) return new Sulfuras(name, sellIn, quality);

  return new DefaultItem(name, sellIn, quality);
 }
}
