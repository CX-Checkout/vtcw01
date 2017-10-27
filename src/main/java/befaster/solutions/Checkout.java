package befaster.solutions;

import befaster.runner.SolutionNotImplementedException;

public class Checkout {

    public static int checkout(String skus) {
        //throw new SolutionNotImplementedException();

        final SuperMarket superMarket = new SuperMarket();
        return superMarket.checkout(skus);

    }
}
