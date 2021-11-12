import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        Client client = Client.create();
        WebResource resource = client.resource("https://jsonplaceholder.typicode.com/posts");
        ClientResponse response = resource.accept(MediaType.APPLICATION_XML).get(ClientResponse.class);
        if (response.getStatus() == 200) {
            String resp = response.getEntity(String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            List<Post> postList = objectMapper.readValue(resp, new TypeReference<List<Post>>(){});
            System.out.println(postList);
        }

    }
}
