package com.rodosaenz.examples.restlet.server;

import com.rodosaenz.examples.restlet.server.restlet.DefaultRestlet;
import com.rodosaenz.examples.restlet.server.restlet.HelloRestlet;
import com.rodosaenz.examples.restlet.server.resource.CiaoResource;
import com.rodosaenz.examples.restlet.server.resource.HelloResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * @author Rodolfo
 */
public class ResletApplicationExample extends Application {
    

    @Override
    public Restlet createInboundRoot() {
        
        HelloRestlet helloRestlet = new HelloRestlet(getContext());
        DefaultRestlet defaultRestlet = new DefaultRestlet(getContext());
        
        Router router = new Router(getContext());
        router.attachDefault(defaultRestlet);
        
        router.attach("http://127.0.0.1:8081"+"/hello", helloRestlet);
        router.attach("http://127.0.0.1:8081"+"/hello/{name}", HelloResource.class);
        router.attach("http://127.0.0.1:8081"+"/hello/{name}/ciao/{message}", CiaoResource.class);

        return router;
    }
}
