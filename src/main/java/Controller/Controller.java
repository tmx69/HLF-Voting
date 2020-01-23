package Controller;

import FabricTools.AppUser;
import FabricTools.Storage;
import FabricTools.FabricClient;
import Models.EnrollUser;
import Models.Voting;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final String url = "https://0.0.0.0";
    private static final String url_ca = "https://ca.org1.example.com:7054";
    private static final String msp = "Org1MSP";

    private static AppUser curUser = null;
    private static FabricClient client = null;

    private static AppUser getAppUser(FabricClient fabricClient, EnrollUser user) throws Exception {
        AppUser appUser;

        if (Storage.exist(user.getName())) {
            return Storage.load(user.getName());
        }

        appUser = fabricClient.enrollUser(user.getName(), user.getOrg(), msp, user.getSecret());
        Storage.save(appUser);

        return appUser;
    }

    private static JSONObject getVoting() throws Exception{
        return new JSONObject()
                .put("title", "test voting")
                .put("participants", new JSONArray()
                        .put("user1")
                        .put("user2")
                        .put("user3"))
                .put("questions", new JSONArray()
                        .put(new JSONObject()
                                .put("title", "question1")
                                .put("answers", new JSONArray()
                                        .put(new JSONObject()
                                                .put("value","answers1")
                                                .put("value","answers2"))))
                        .put(new JSONObject()
                                .put("title", "question2")
                                .put("answers", new JSONArray()
                                        .put(new JSONObject()
                                                .put("value","answers1")
                                                .put("value","answers2")))));
    }

    @PostMapping(path = "/enroll", consumes = "application/json", produces = "application/json")
    public void enroll(@RequestBody EnrollUser user) throws Exception{
        FabricClient fabricClient = new FabricClient(url_ca, user.getOrg());
        AppUser appUser = getAppUser(fabricClient, user);
        this.curUser = appUser;
        this.client = fabricClient;
    }

    @PostMapping(path = "/createVoting", consumes = "application/json", produces = "application/json")
    public String createVoting(@RequestBody Voting voting) throws Exception{
        return client.createVoting(this.curUser, getVoting());
    }
}
