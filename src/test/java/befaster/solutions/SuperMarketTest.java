package befaster.solutions;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SuperMarketTest {

    @Test
    public void emptyCheckout() throws Exception {

        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout(""), equalTo(0));

    }

    @Test
    public void nullCheckout() throws Exception {

        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout(null), equalTo(0));

    }


    @Test
    public void simpleCheckout() throws Exception {

        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("A"), equalTo(50));

    }

    @Test
    public void simpleTwoProductsCheckout() throws Exception {

        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("AB"), equalTo(80));

    }

    @Test
    public void simplePromotionCheckout() throws Exception {

        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("AAA"), equalTo(130));

    }

    @Test
    public void lotOfProductsWithoutPromotion() throws Exception {
        final SuperMarket superMarket = new SuperMarket();

        // 50 + 30 + 20 + 15 + 50 + 20
        assertThat(superMarket.checkout("ABCDAC"), equalTo(185));

    }

    @Test
    public void partialPromotion() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("AAAA"), equalTo(180));
    }

    @Test
    public void twoPromotion() throws Exception {
        final SuperMarket superMarket = new SuperMarket();

        // 130 + 20 + 45
        assertThat(superMarket.checkout("ABACAB"), equalTo(195));
    }

    @Test
    public void productNotAvailable() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("ABlYACAB"), equalTo(-1));
    }

    @Test
    public void specialOfferE() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("EEB"), equalTo(80));
    }

    @Test
    public void specialOffer3N1M() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("NNNM"), equalTo(120));
    }

    @Test
    public void specialOffer4N1M() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("NNNNM"), equalTo(160));
    }

    @Test
    public void specialOffer6N1M() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("NNNNNNM"), equalTo(240));
    }

    @Test
    public void specialOfferR() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("RRRQ"), equalTo(150));
    }

    @Test
    public void specialOfferU() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("UUUU"), equalTo(120));
    }

    @Test
    public void specialOffer5A() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("AAAAA"), equalTo(200));
    }

    @Test
    public void specialOffer5H() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("HHHHH"), equalTo(45));
    }

    @Test
    public void specialOffer10H() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("HHHHHHHHHH"), equalTo(80));
    }

    @Test
    public void specialOffer2F() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("FF"), equalTo(20));
    }


    @Test
    public void specialOffer2K() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("KK"), equalTo(120));
    }

    @Test
    public void specialOffer2V() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("VV"), equalTo(90));
    }

    @Test
    public void specialOffer3V() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("VVV"), equalTo(130));
    }

    @Test
    public void specialOffer2P() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("PPPPP"), equalTo(200));
    }

    @Test
    public void specialOffer2Q() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("QQQ"), equalTo(80));
    }

    @Test
    public void specialOfferSTXYZ2() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("SSSZ"), equalTo(65));
    }

    @Test
    public void specialOfferSTXZ() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("STXZ"), equalTo(62));
    }

}
