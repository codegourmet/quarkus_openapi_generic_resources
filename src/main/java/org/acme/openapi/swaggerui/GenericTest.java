package org.acme.openapi.swaggerui;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/*

Actual:

    paths:
      /generic:
        get:
          responses:
            "200":
              description: OK
              content:
                application/json:
                  schema:
                    type: object

Expected:

    paths:
      /generic:
        get:
          responses:
            "200":
              description: OK
              content:
                application/json:
                  schema:
                    $ref: '#/components/schemas/Apple'
    components:
      schemas:
        Apple:
          type: object
          properties:
            id:
              type: string
            name:
              type: string

 *
 */
class GenericTest {
    static class Apple {
        public String name;
    }

    static class BaseResource<T> {
        @GET
        public T test() {
            return null;
        }
    }

    @Path("/generic")
    static class TestResource extends BaseResource<Apple> {
        public TestResource() {
        }
    }
}
