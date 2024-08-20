package com.ronaldo.data;

import io.quarkus.runtime.StartupEvent;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;
import jakarta.enterprise.event.Observes;

public class StaticResources {

    void installRoute(@Observes StartupEvent startupEvent, Router router) {
        router.route().method(HttpMethod.GET)
                .method(HttpMethod.HEAD)
                .path("/static/*")
                .handler(StaticHandler.create("src/static/"));
    }
}
