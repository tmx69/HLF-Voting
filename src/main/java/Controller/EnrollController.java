package Controller;

import FabricTools.AppUser;
import FabricTools.Storage;
import FabricTools.FabricClient;
import Models.EnrollUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/enroll")
public class EnrollController {
    private static final String url = "0.0.0.0";
    private static final String url_ca = "https://ca.org1.example.com:7054";
    private static final String msp = "Org1MSP";

    private static AppUser curUser;

    private static AppUser getAppUser(FabricClient fabricClient, EnrollUser user) throws Exception {
        AppUser appUser;

        if (Storage.exist(user.getName())) {
            return Storage.load(user.getName());
        }

        appUser = fabricClient.enrollUser(user.getName(), user.getOrg(), msp, user.getSecret());
        Storage.save(appUser);

        return appUser;
    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public void enroll(@RequestBody EnrollUser user) throws Exception{
        FabricClient fabricClient = new FabricClient(url_ca, user.getOrg());
        AppUser appUser = getAppUser(fabricClient, user);
        this.curUser = appUser;
    }
}
