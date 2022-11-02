package tv.codely.kata.gildedrose;

import tv.codely.kata.gildedrose.model.item.Item;
import tv.codely.kata.gildedrose.model.item.ItemBuilder;

public class GildedRoseCliEntryPoint {
    public static void main(String[] args) {
        System.out.println("OMGHAI!");

        Item[] items = new Item[] {
            ItemBuilder.from("+5 Dexterity Vest", 10, 20), //
            ItemBuilder.from("Aged Brie", 2, 0), //
            ItemBuilder.from("Elixir of the Mongoose", 5, 7), //
            ItemBuilder.from("Sulfuras, Hand of Ragnaros", 0, 80), //
            ItemBuilder.from("Sulfuras, Hand of Ragnaros", -1, 80),
            ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
            ItemBuilder.from("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 2;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (Item item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
