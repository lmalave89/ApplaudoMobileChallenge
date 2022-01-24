package tests.cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import screens.ShoppingScreen;
import tests.ThreadLocalDriver;
import utilities.data.Data;

import java.io.IOException;

public class ApplaudoSteps extends BaseSteps {

    ShoppingScreen shoppingScreen;

    @Before
    public void setupLoginSteps () {
        setupCucumber();
        shoppingScreen = new ShoppingScreen(ThreadLocalDriver.getTLDriver());

    }
    @Given("^create a new shopping list$")
    public void create_a_new_shopping_list() throws IOException {
        shoppingScreen.clickButtonListEmpty();
        shoppingScreen.clickButtonNewList();
        shoppingScreen.createList("My shopping list");
        shoppingScreen.clickButtonAdd();
        shoppingScreen.addListItemsToList(Data.DataElements());
    }

    @When("^edit the shopping created before$")
    public void edit_the_shopping_created_before() throws IOException {
        shoppingScreen.editEachitemsToList(Data.DataElements());
    }

    @Then("^Verified there is no list in any section$")
    public void verified_there_is_no_list_in_any_section(){
        shoppingScreen.verifyArchiveListEmpty();
        shoppingScreen.swipeArchiveToCurrent();
        shoppingScreen.verifyCurrentListEmpty();
    }

    @And("^delete two elements of the list$")
    public void delete_two_elements_of_the_list(){
        shoppingScreen.deleteItemToList(Data.DataElements(), "Blueberries");
        shoppingScreen.deleteItemToList(Data.DataElements(), "Apricots");
    }

    @And("^select the rest of the items on the list$")
    public void select_the_rest_of_the_items_on_the_list(){
        shoppingScreen.clickAllCheckBoxItems();
    }

    @And("^archive the list created before$")
    public void archive_the_list_created_before(){
        shoppingScreen.clickButtonArchive();
    }

    @And("^delete the archived list$")
    public void delete_the_archived_list(){
        shoppingScreen.clickButtonListEmpty();
        shoppingScreen.swipeCurrentToArchive();
        shoppingScreen.tabByCoordinatesThreePointsButton();
        shoppingScreen.clickButtonDelete();
        shoppingScreen.clickButtonDeleteConfirmation();
    }


    @After
    public synchronized void teardown () {
        tearDownSteps();
    }
}
