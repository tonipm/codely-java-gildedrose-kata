package tv.codely.kata.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseShould {
    private Item[] arrayWith(Item item) {
        return new Item[]{item};
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = ItemBuilder.from("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        final ItemSellIn expectedSellIn = new ItemSellIn(9);
        assertEquals(whateverItem.sellIn(), expectedSellIn);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = ItemBuilder.from("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.quality(), 9);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = ItemBuilder.from("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.quality(), 8);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = ItemBuilder.from("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose(arrayWith(whateverItem));
        gildedRose.updateQuality();

        assertEquals(whateverItem.quality(), 0);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = ItemBuilder.from("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.quality(), 2);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = ItemBuilder.from("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose(arrayWith(agedBrie));
        gildedRose.updateQuality();

        assertEquals(agedBrie.quality(), 50);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = ItemBuilder.from("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose(arrayWith(sulfuras));
        gildedRose.updateQuality();

        final ItemSellIn expectedSellIn = new ItemSellIn(0);
        assertEquals(sulfuras.quality(), 25);
        assertEquals(sulfuras.sellIn(), expectedSellIn);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        Item backstagePasses = ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality(), 21);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        Item backstagePasses = ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 6, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality(), 22);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        Item backstagePasses = ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality(), 23);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose(arrayWith(backstagePasses));
        gildedRose.updateQuality();

        assertEquals(backstagePasses.quality(), 0);
    }
}
