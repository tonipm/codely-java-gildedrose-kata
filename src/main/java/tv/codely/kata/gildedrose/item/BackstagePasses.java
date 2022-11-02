package tv.codely.kata.gildedrose.item;

final class BackstagePasses extends ItemUpdatable {

    private static final int INCREASE_QUALITY_01_THRESHOLD = 10;
    private static final int INCREASE_QUALITY_02_THRESHOLD = 5;
    private static final int RESET_QUALITY_THRESHOLD = 0;

    BackstagePasses(final ItemName name, final int sellIn, final int quality) {
      super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();
        increaseQuality();

        if (sellIn() < INCREASE_QUALITY_01_THRESHOLD) {
            increaseQuality();
        }
        if (sellIn() < INCREASE_QUALITY_02_THRESHOLD) {
            increaseQuality();
        }
        if (sellIn() < RESET_QUALITY_THRESHOLD) {
            resetQuality();
        }
    }
}
