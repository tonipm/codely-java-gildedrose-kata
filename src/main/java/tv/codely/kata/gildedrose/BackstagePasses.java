package tv.codely.kata.gildedrose;

final class BackstagePasses extends UpdatableItem {

    private static final int INCREASE_QUALITY_01_THRESHOLD = 10;
    private static final int INCREASE_QUALITY_02_THRESHOLD = 5;
    private static final int RESET_QUALITY_THRESHOLD = 0;

    BackstagePasses(final ItemName name, final ItemSellIn sellIn, final ItemQuality quality) {
      super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();
        increaseQuality();

        if (hasToBeSoldInLessThan(INCREASE_QUALITY_01_THRESHOLD)) {
            increaseQuality();
        }
        if (hasToBeSoldInLessThan(INCREASE_QUALITY_02_THRESHOLD)) {
            increaseQuality();
        }
        if (hasToBeSoldInLessThan(RESET_QUALITY_THRESHOLD)) {
            resetQuality();
        }
    }
}
