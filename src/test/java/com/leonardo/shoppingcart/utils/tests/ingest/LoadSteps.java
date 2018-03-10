package com.leonardo.shoppingcart.utils.tests.ingest;

import com.leonardo.shoppingcart.entities.site.Cart;
import org.jbehave.core.annotations.*;
import org.jbehave.core.steps.Steps;

import static org.junit.Assert.*;

public class LoadSteps extends Steps {

    @Given("empty cart")
    public void emptyCart() {
        Cart cart = new Cart();
    }

    @Then("cart is empty")
    public void isEmpty(Cart cart) {
        assertNull(cart);
    }


}
