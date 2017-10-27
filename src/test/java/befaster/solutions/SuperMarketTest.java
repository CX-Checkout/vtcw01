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
        assertThat(superMarket.checkout("ABYACAB"), equalTo(-1));
    }

    @Test
    public void specialOfferE() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("EEB"), equalTo(80));
    }

    @Test
    public void specialOffer5A() throws Exception {
        final SuperMarket superMarket = new SuperMarket();
        assertThat(superMarket.checkout("AAAAA"), equalTo(200));
    }


}
