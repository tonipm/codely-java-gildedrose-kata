package tv.codely.kata.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class GildedRoseShould {

    private List<Item> listOf(Item item) {
        return Collections.singletonList(item);
    }

    @Test
    public void testThatSellInValueIsDecreased() {
        Item whateverItem = ItemBuilder.from("whatever", 10, 0);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        final ItemSellIn expectedSellIn = new ItemSellIn(9);
        assertEquals(whateverItem.sellIn(), expectedSellIn);
    }

    @Test
    public void testThatQualityValueIsDecreased() {
        Item whateverItem = ItemBuilder.from("whatever", 1, 10);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        final ItemQuality expectedQuality = new ItemQuality(9);
        assertEquals(whateverItem.quality(), expectedQuality);
    }

    @Test
    public void testThatQualityDecreasesTwiceAsMuchWhenSellByIsPassed() {
        Item whateverItem = ItemBuilder.from("whatever", 0, 10);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        final ItemQuality expectedQuality = new ItemQuality(8);
        assertEquals(whateverItem.quality(), expectedQuality);
    }

    @Test
    public void testThatQualityIsNeverNegative() {
        Item whateverItem = ItemBuilder.from("whatever", 0, 0);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(whateverItem));

        final ItemQuality expectedQuality = new ItemQuality(0);
        assertEquals(whateverItem.quality(), expectedQuality);
    }

    @Test
    public void testAgedBrieIncreasesQualityWithAge() {
        Item agedBrie = ItemBuilder.from("Aged Brie", 5, 1);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(agedBrie));

        final ItemQuality expectedQuality = new ItemQuality(2);
        assertEquals(agedBrie.quality(), expectedQuality);
    }

    @Test
    public void testQualityNeverIncreasesPastFifty() {
        Item agedBrie = ItemBuilder.from("Aged Brie", 5, 50);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(agedBrie));

        final ItemQuality expectedQuality = new ItemQuality(50);
        assertEquals(agedBrie.quality(), expectedQuality);
    }

    @Test
    public void testSulfurasNeverChanges() {
        Item sulfuras = ItemBuilder.from("Sulfuras, Hand of Ragnaros", 0, 25);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(sulfuras));

        final ItemQuality expectedQuality = new ItemQuality(25);
        final ItemSellIn expectedSellIn = new ItemSellIn(0);
        assertEquals(sulfuras.quality(), expectedQuality);
        assertEquals(sulfuras.sellIn(), expectedSellIn);
    }

    @Test
    public void testBackstagePassIncreasesQualityByOneIfSellByGreaterThenTen() {
        Item backstagePasses = ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 11, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        final ItemQuality expectedQuality = new ItemQuality(21);
        assertEquals(backstagePasses.quality(), expectedQuality);
    }

    @Test
    public void testBackstagePassIncreasesQualityByTwoIfSellBySmallerThanTen() {
        Item backstagePasses = ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 6, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        final ItemQuality expectedQuality = new ItemQuality(22);
        assertEquals(backstagePasses.quality(), expectedQuality);
    }

    @Test
    public void testBackstagePassIncreasesQualityByThreeIfSellBySmallerThanFive() {
        Item backstagePasses = ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 5, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        final ItemQuality expectedQuality = new ItemQuality(23);
        assertEquals(backstagePasses.quality(), expectedQuality);
    }

    @Test
    public void testBackstagePassLosesValueAfterSellByPasses() {
        Item backstagePasses = ItemBuilder.from("Backstage passes to a TAFKAL80ETC concert", 0, 20);

        GildedRose gildedRose = new GildedRose();
        gildedRose.updateQuality(listOf(backstagePasses));

        final ItemQuality expectedQuality = new ItemQuality(0);
        assertEquals(backstagePasses.quality(), expectedQuality);
    }
}
