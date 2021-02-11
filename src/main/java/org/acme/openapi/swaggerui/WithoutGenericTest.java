package org.acme.openapi.swaggerui;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

class WithoutGenericTest {
    static abstract class BananaDto {
        public String id;
    }

    static class Banana extends BananaDto {
        public String name;
    }

    @Path("/without-generic")
    static class TestResource {
        public TestResource() {
        }

        @GET
        public Banana test() {
            return null;
        }
    }
}
