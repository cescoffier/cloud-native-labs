package com.redhat.cloudnative.gateway;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.ext.web.Router;

public class GatewayVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> future) {
        Router router = Router.router(vertx);

        router.get("/*").handler(rc -> {
            rc.response().end("{\"message\": \"Hello Vert.x\"}");
        });

        vertx.createHttpServer().requestHandler(router::accept).listen(8080);
    }
}
