package tv.codely.kata.gildedrose.item;

public final class ItemBuilder {

 public static Item from(final String rawName, final int sellIn, final int quality) {
  ItemName name = new ItemName(rawName);

  if (name.isAgedBrie()) return new AgedBrie(name, sellIn, quality);
  if (name.isBackstagePasses()) return new BackstagePasses(name, sellIn, quality);
  if (name.isSulfuras()) return new Sulfuras(name, sellIn, quality);

  return new ItemDefault(name, sellIn, quality);
 }
}
