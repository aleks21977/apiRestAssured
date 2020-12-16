package api.models.google_places;

import api.utils.NetworkCore;
import io.restassured.http.Method;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

import static constants.Connstants.Endpoint.GOOGLE_PLACE_ENDPOINT_SEARCH;
import static constants.Connstants.Path.GOOGLE_PLACE_PATH;
import static constants.Connstants.ServerName.GOOGLE_PLACE_SERVER;


public class GooglePlacesModel extends NetworkCore {


    @Setter
    @Getter
    @Builder
    public static class RequestModel {
        private String key;
        private String input;
        private String inputtype;
    }

    public GooglePlacesModel search(RequestModel model, Method method, int statusCode){
        HashMap requestParams = new HashMap();
        requestParams.put("key", model.getKey());
        requestParams.put("input", model.getInput());
        requestParams.put("inputtype", model.getInputtype());
        requestSpecBuilder.setBaseUri(GOOGLE_PLACE_SERVER + GOOGLE_PLACE_PATH + GOOGLE_PLACE_ENDPOINT_SEARCH)
                .addQueryParams(requestParams);
        sendRequestAndGetResponse(method, statusCode);
        return this;
    }
}
