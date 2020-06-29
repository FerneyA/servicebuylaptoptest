package co.com.test.service.buyonline.stepdefinitions;

import co.com.test.service.buyonline.tasks.FindAUser;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.hamcrest.MatcherAssert;

import java.util.List;

import static co.com.test.service.buyonline.tasks.UserTasks.listAllUsers;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class ManagingUserStepDefinitions {

    private Actor peter;

    @Before
    public void setBaseUri() {
        RestAssured.baseURI = "https://reqres.in/api";
        peter = Actor.named("Sam the manager")
                .whoCan(CallAnApi.at(RestAssured.baseURI));
    }


    @When("^Peter wants to find a user with ID (.*)$")
    public void findAUser(int idUser) {
        peter.attemptsTo(
                FindAUser.withId(idUser)
        );
    }

    @Then("^he should see the first name (.*) and last name (.*)$")
    public void validateNamesUser(String firstName, String lastName) {
        peter.should(
                seeThatResponse( "User details should be correct",
                        response -> response.statusCode(200)
                                .body("data.first_name", equalTo(firstName))
                                .body("data.last_name", equalTo(lastName))
                ));
    }

    @When("^Peter wants to find the number of users$")
    public void findAllUser() {
        peter.attemptsTo(
                listAllUsers()
        );
    }

    @Then("^he should see (.*) users$")
    public void validateNamesUsers(int numberUsers) {
        List<String> userSurnames = SerenityRest.lastResponse().path("data.last_name");
        MatcherAssert.assertThat("The number of users is different",userSurnames.size()==6);
    }

    @When("^Peter can delete the user with Id (.*)$")
    public void deleteUser(String idUser) {
        peter.attemptsTo(
                Delete.from("/users/".concat(idUser))
        );
        peter.should(
                seeThatResponse(response -> response.statusCode(204))
        );
    }
}
