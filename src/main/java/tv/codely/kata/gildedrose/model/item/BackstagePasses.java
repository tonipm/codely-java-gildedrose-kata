package tv.codely.kata.gildedrose.model.item;

public final class BackstagePasses extends ItemUpdatable {

    private static final int INCREASE_QUALITY_01_THRESHOLD = 10;
    private static final int INCREASE_QUALITY_02_THRESHOLD = 5;
    private static final int RESET_QUALITY_THRESHOLD = 0;

    public BackstagePasses(final String name, final int sellIn, final int quality) {
      super(name, sellIn, quality);
    }

    @Override
    public void update() {
        decreaseSellIn();
        increaseQuality();

        if (this.sellIn < INCREASE_QUALITY_01_THRESHOLD) {
            increaseQuality();
        }
        if (this.sellIn < INCREASE_QUALITY_02_THRESHOLD) {
            increaseQuality();
        }
        if (this.sellIn < RESET_QUALITY_THRESHOLD) {
            resetQuality();
        }
    }
}
